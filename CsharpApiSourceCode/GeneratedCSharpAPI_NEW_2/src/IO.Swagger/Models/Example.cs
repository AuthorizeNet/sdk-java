using Newtonsoft.Json;
using System.IO;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Serialization;
using System.Xml;
using System;
using Newtonsoft.Json.Linq;
using System.Buffers.Text;
using System.Collections.Generic;
using System.Security.Policy;
using System.Net.Http.Headers;
using Microsoft.AspNetCore.Mvc;

namespace IO.Swagger.Models
{
    public class Example
    {

        public string ConvertToSoapXml(CreateCustomerAddress address)
        {
            var xmlSerializer = new XmlSerializer(typeof(CreateCustomerAddress));
            using (var stringWriter = new StringWriter())
            using (var xmlWriter = XmlWriter.Create(stringWriter, new XmlWriterSettings { OmitXmlDeclaration = true }))
            {
                var ns = new XmlSerializerNamespaces();
                ns.Add("cus", "http://example.com/customeraddress"); // Replace with your actual namespace
                xmlSerializer.Serialize(xmlWriter, address, ns);
                return stringWriter.ToString();

            }
        }

        public string CreateSoapRequest(CreateCustomerAddress body)
        {
            string bodyXml = ConvertToSoapXml(body);

            // Creating the full SOAP request
            string soapRequest = $@"
        <soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:cus='http://example.com/customeraddress'>
            <soapenv:Header/>
            <soapenv:Body>
                {bodyXml}
            </soapenv:Body>
        </soapenv:Envelope>";

            return soapRequest;
        }

        private static readonly HttpClient httpClient = new HttpClient();

        //public async Task<string> SendSoapRequest(string soapRequest)
        //{
        //    // Authorize.Net API credentials
        //    string apiLoginID = "";
        //    string transactionKey = "";

        //    // Create the authorization value in base64
        //    string authValue = Convert.ToBase64String(Encoding.UTF8.GetBytes($"{apiLoginID}:{transactionKey}"));

        //    // Set the Base URL for the Authorize.Net API
        //    httpClient.BaseAddress = new Uri("https://apitest.authorize.net");

        //    // Set the authorization header
        //    httpClient.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Basic", authValue);

        //    // Prepare the SOAP request content
        //    var httpContent = new StringContent(soapRequest, Encoding.UTF8, "text/xml");

        //    // The SOAP endpoint URL
        //    var soapServiceUrl = "https://apitest.authorize.net/xml/v1/customers/924517851/addresses";

        //    try
        //    {
        //        // Make the SOAP request
        //        var response = await httpClient.PostAsync(soapServiceUrl, httpContent);

        //        // Check if the response is successful
        //        if (response.IsSuccessStatusCode)
        //        {
        //            var result = await response.Content.ReadAsStringAsync();
        //            string jsonResult = ConvertXmlToJson(result);
        //            return jsonResult;
        //        }
        //        else
        //        {
        //            Console.WriteLine("Error in SOAP request: " + response.ReasonPhrase);
        //            return null;
        //        }
        //    }
        //    catch (Exception ex)
        //    {
        //        Console.WriteLine("Exception in SOAP request: " + ex.Message);
        //        return null;
        //    }
        //}

        //-----------------------------------
        // HttpClient instance
        //private static readonly HttpClient httpClient = new HttpClient();

        public async Task<string> SendSoapRequest(string soapRequest)
        {
            // Authorize.Net API credentials
            string apiLoginID = ""; // Your actual API Login ID
            string transactionKey = ""; // Your actual Transaction Key

            // Create the authorization value in base64
            string authValue = Convert.ToBase64String(Encoding.UTF8.GetBytes($"{apiLoginID}:{transactionKey}"));

            // Set the Base URL for the Authorize.Net API
            httpClient.BaseAddress = new Uri("https://apitest.authorize.net");

            // Set the Authorization header
            httpClient.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Basic", authValue);

            // The SOAP/REST API endpoint URL for the request
            //string apiEndpoint = "/xml/v1/customers/924517851/addresses";
            string apiEndpoint = "https://apitest.authorize.net/xml/v1/customers/924517851/addresses";

            try
            {
                // Set up the content for the SOAP request
                var httpContent = new StringContent(soapRequest, Encoding.UTF8, "text/xml");

                // Send POST request
                var response = await httpClient.PostAsync(apiEndpoint, httpContent);

                // Check if the response is successful
                if (response.IsSuccessStatusCode)
                {
                    // Read the response content
                    string result = await response.Content.ReadAsStringAsync();

                    // Convert XML to JSON if needed (you may use the method provided in your codebase)
                    string jsonResult = ConvertXmlToJson(result); // Assuming you have a ConvertXmlToJson method
                    return jsonResult;
                }
                else
                {
                    //Console.WriteLine("Error in the API request: " + response.ReasonPhrase);
                    //return null;
                    string jsonResult = ConvertXmlToJson(soapRequest); // Assuming you have a ConvertXmlToJson method
                    return jsonResult;
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine("Exception occurred while calling the API: " + ex.Message);
                return null;
            }
        }


        public async Task<string> SendSoapRequest_new(string soapRequest)
        {
            // Authorize.Net API credentials
            string apiLoginID = ""; // Your actual API Login ID
            string transactionKey = ""; // Your actual Transaction Key

            // Create the authorization value in base64
            string authValue = Convert.ToBase64String(Encoding.UTF8.GetBytes($"{apiLoginID}:{transactionKey}"));

            // Set the Base URL for the Authorize.Net API
            httpClient.BaseAddress = new Uri("https://apitest.authorize.net");

            // Clear existing headers to avoid any conflicts
            httpClient.DefaultRequestHeaders.Clear();
            httpClient.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Basic", authValue);

            // The relative endpoint URL for the request
            string apiEndpoint = "/xml/v1/customers/924517851/addresses";

            try
            {
                // Set up the content for the SOAP request
                var httpContent = new StringContent(soapRequest, Encoding.UTF8, "text/xml");

                // Send POST request to the API
                var response = await httpClient.PostAsync(apiEndpoint, httpContent);

                // Check if the response is successful
                if (response.IsSuccessStatusCode)
                {
                    // Read the response content
                    string result = await response.Content.ReadAsStringAsync();

                    // Convert XML to JSON if needed (you may use the method provided in your codebase)
                    string jsonResult = ConvertXmlToJson(result); // Assuming you have a ConvertXmlToJson method
                    return jsonResult;
                }
                else
                {
                    Console.WriteLine("Error in the API request: " + response.ReasonPhrase);
                    return null;
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine("Exception occurred while calling the API: " + ex.Message);
                return null;
            }
        }



        //--------------------------------


        //public async Task<string> SendSoapRequest(CreateCustomerAddress body)
        //{
        //    string soapRequest = CreateSoapRequest(body);
        //    using (var httpClient = new HttpClient())
        //    {
        //        var httpContent = new StringContent(soapRequest, Encoding.UTF8, "text/xml");

        //        // Replace with your actual SOAP endpoint URL
        //        var soapServiceUrl = "https://example.com/soap/endpoint";

        //        var response = await httpClient.PostAsync(soapServiceUrl, httpContent);

        //        if (response.IsSuccessStatusCode)
        //        {
        //            var result = await response.Content.ReadAsStringAsync();

        //            // Convert the XML result to JSON
        //            var jsonResult = ConvertXmlToJson(result);
        //            return jsonResult; // Return the JSON string
        //        }
        //        else
        //        {
        //            Console.WriteLine("Error in SOAP request: " + response.ReasonPhrase);
        //            return null; // Or handle errors as needed
        //        }
        //    }
        //}

        private string ConvertXmlToJson(string xml)
        {
            var xmlDoc = new XmlDocument();
            xmlDoc.LoadXml(xml); // Load the XML string into XmlDocument

            string jsonText = JsonConvert.SerializeXmlNode(xmlDoc, Newtonsoft.Json.Formatting.Indented);
            return jsonText; // Return the JSON string
        }

    }
}
