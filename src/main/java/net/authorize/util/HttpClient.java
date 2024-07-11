package net.authorize.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyStore;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.hc.client5.http.config.ConnectionConfig;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.client5.http.ssl.NoopHostnameVerifier;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactoryBuilder;
import org.apache.hc.core5.http.io.SocketConfig;
import org.apache.hc.core5.http.ssl.TLS;
import org.apache.hc.core5.pool.PoolConcurrencyPolicy;
import org.apache.hc.core5.pool.PoolReusePolicy;
import org.apache.hc.core5.ssl.SSLContexts;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.client5.http.auth.AuthScope;
import org.apache.hc.client5.http.auth.Credentials;
import org.apache.hc.client5.http.auth.UsernamePasswordCredentials;
import org.apache.hc.client5.http.impl.auth.BasicCredentialsProvider;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.socket.LayeredConnectionSocketFactory;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.util.Timeout;

import net.authorize.Environment;

/**
 * Transportation object used to facilitate the communication with the
 * respective gateway.
 */
public class HttpClient {
    private static Logger logger = LogManager.getLogger(HttpClient.class);

    public static final String ENCODING = "UTF-8";
    static boolean proxySet = false;

    static boolean UseProxy = Environment.getBooleanProperty(Constants.HTTPS_USE_PROXY);
    static String ProxyHost = Environment.getProperty(Constants.HTTPS_PROXY_HOST);
    static int ProxyPort = Environment.getIntProperty(Constants.HTTPS_PROXY_PORT);
    static String proxyUsername = Environment.getProperty(Constants.HTTPS_PROXY_USERNAME);
    static String proxyPassword = Environment.getProperty(Constants.HTTPS_PROXY_PASSWORD);

    static int httpConnectionTimeout = Environment.getIntProperty(Constants.HTTP_CONNECTION_TIME_OUT);
    static int httpReadTimeout = Environment.getIntProperty(Constants.HTTP_READ_TIME_OUT);

    static Timeout newHttpConnectionTimeout, newHttpReadTimeout;

    static {
        LogHelper.info(logger, "Use Proxy: '%s'", UseProxy);

        httpConnectionTimeout = (httpConnectionTimeout == 0 ? Constants.HTTP_CONNECTION_TIME_OUT_DEFAULT_VALUE
                : httpConnectionTimeout);
        httpReadTimeout = (httpReadTimeout == 0 ? Constants.HTTP_READ_TIME_OUT_DEFAULT_VALUE : httpReadTimeout);

        newHttpConnectionTimeout = Timeout.ofSeconds(httpConnectionTimeout);
        newHttpReadTimeout = Timeout.ofSeconds(httpReadTimeout);
    }

    /**
     * Converts a response inputstream into a string.
     *
     * @param is
     * @return String
     */
    @Deprecated
    public static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            LogHelper.warn(logger, "Exception reading data from Stream: '%s'", e.getMessage());
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    LogHelper.warn(logger, "Exception closing BufferedReader: '%s'", e.getMessage());
                }
            }

            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    LogHelper.warn(logger, "Exception closing InputStream: '%s'", e.getMessage());
                }
            }
        }
        return sb.toString();
    }


    /**
     * @return returns an SSL context with TLSv1.2 protocol instance to be used in
     * the call
     */
    private static SSLContext getSSLContext() {
        try {
            final SSLContext sc = SSLContext.getInstance("TLSv1.2");
            final TrustManagerFactory trustManagerFactory = TrustManagerFactory
                    .getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            sc.init(null, trustManagerFactory.getTrustManagers(), new java.security.SecureRandom());
            return sc;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Returns a HTTPClient instance which enforce TLSv1.2 protocol for all the
     * calls
     *
     * @return CloseableHttpClient instance
     * @throws Exception
     */
    static CloseableHttpClient getHttpsClient() throws Exception {
        SSLContext sslcontext = getSSLContext();
        try {
            CloseableHttpClient httpClient;

            PoolingHttpClientConnectionManager connectionManager = PoolingHttpClientConnectionManagerBuilder.create()
                    .setSSLSocketFactory(SSLConnectionSocketFactoryBuilder.create()
                            .setSslContext(SSLContexts.createSystemDefault())
                            .setTlsVersions(TLS.V_1_2)
                            .setHostnameVerifier(NoopHostnameVerifier.INSTANCE)
                            .build())
                    .setPoolConcurrencyPolicy(PoolConcurrencyPolicy.STRICT)
                    .setConnPoolPolicy(PoolReusePolicy.LIFO)
                    .setDefaultSocketConfig(SocketConfig.custom()
                            .setSoTimeout(newHttpReadTimeout)
                            .build())
                    .setDefaultConnectionConfig(ConnectionConfig.custom()
                            .setConnectTimeout(newHttpConnectionTimeout)
                            .setSocketTimeout(newHttpReadTimeout)
                            .build())
                    .build();

            RequestConfig requestConfig = RequestConfig.custom()
                    .setExpectContinueEnabled(true)
                    .build();

            if (UseProxy && ProxyHost != null) {
                HttpClientBuilder hcBuilder;
                if (proxyUsername != null && proxyPassword != null) {
                    LogHelper.info(logger, "Setting up proxy to URL with Authentication: '%s://%s@%s:%d'",
                            Constants.PROXY_PROTOCOL, proxyUsername, ProxyHost, ProxyPort);
                    BasicCredentialsProvider credsProvider = new BasicCredentialsProvider();
                    AuthScope proxyScope = new AuthScope(ProxyHost, ProxyPort);
                    Credentials proxyCreds = new UsernamePasswordCredentials(proxyUsername, proxyPassword.toCharArray());
                    credsProvider.setCredentials(proxyScope, proxyCreds);
                    httpClient = HttpClientBuilder
                            .create()
                            .setDefaultCredentialsProvider(credsProvider)
                            .setProxy(new HttpHost(Constants.PROXY_PROTOCOL, ProxyHost, ProxyPort))
                            .setConnectionManager(connectionManager)
                            .setDefaultRequestConfig(requestConfig)
                            .build();
                } else {
                    LogHelper.info(logger, "Setting up proxy to URL: '%s://%s:%d'", Constants.PROXY_PROTOCOL, ProxyHost,
                            ProxyPort);
                    httpClient = HttpClientBuilder
                            .create()
                            .setProxy(new HttpHost(Constants.PROXY_PROTOCOL, ProxyHost, ProxyPort))
                            .setConnectionManager(connectionManager)
                            .setDefaultRequestConfig(requestConfig)
                            .build();
                }

                proxySet = true;
            } else {
                LogHelper.warn(logger, "Defaulting to non-proxy environment");

                httpClient = HttpClientBuilder
                        .create()
                        .setConnectionManager(connectionManager)
                        .setDefaultRequestConfig(requestConfig)
                        .build();
            }

            return httpClient;
        } catch (Exception e) {
            return null;
        }
    }
}
