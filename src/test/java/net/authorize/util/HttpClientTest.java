package net.authorize.util;

import org.junit.Assert;
import org.junit.Test;

public class HttpClientTest {

    @Test
    public void defaultTimeoutsAreInMilliseconds() {
        Assert.assertEquals(Constants.HTTP_CONNECTION_TIME_OUT_DEFAULT_VALUE, HttpClient.newHttpConnectionTimeout.toMilliseconds());
        Assert.assertEquals(Constants.HTTP_READ_TIME_OUT_DEFAULT_VALUE, HttpClient.newHttpReadTimeout.toMilliseconds());
    }
}
