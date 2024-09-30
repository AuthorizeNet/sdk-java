using System.Net.Http.Headers;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using System;
using System.Xml;
using System.Xml.Schema;

using Newtonsoft.Json;
using System.IO;
namespace IO.Swagger.Models
{
    public class xsd
    {
        public async Task<string> SendSoapRequest(string soapRequest, string xsdFilePath= "C:/Temp/New.xsd")
        {
            // Authorize.Net API credentials
            string apiLoginID = ""; // Your actual API Login ID
            string transactionKey = ""; // Your actual Transaction Key

            // Create the authorization value in base64
            string authValue = Convert.ToBase64String(Encoding.UTF8.GetBytes($"{apiLoginID}:{transactionKey}"));

            // Set the Base URL for the Authorize.Net API
            using (var httpClient = new HttpClient())
            {
                httpClient.BaseAddress = new Uri("https://apitest.authorize.net");

                // Set the Authorization header
                httpClient.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Basic", authValue);

                // The SOAP/REST API endpoint URL for the request
                string apiEndpoint = "https://apitest.authorize.net/xml/v1/customers/924517851/addresses";

                //Validate the SOAP request XML against the XSD schema
                if (!ValidateXmlAgainstXsd(soapRequest, xsdFilePath))
                {
                    Console.WriteLine("XML validation failed against the XSD schema.");
                    return "XML validation failed.";
                }

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
        }

        private string ConvertXmlToJson(string xml)
        {
            var xmlDoc = new XmlDocument();
            xmlDoc.LoadXml(xml); // Load the XML string into XmlDocument

            string jsonText = JsonConvert.SerializeXmlNode(xmlDoc, Newtonsoft.Json.Formatting.Indented);
            return jsonText; // Return the JSON string
        }

        public bool ValidateXmlAgainstXsd(string xmlContent, string xsdFilePath)
        {
            try
            {
                XmlSchemaSet schema = new XmlSchemaSet();

                // Specify the targetNamespace that matches your XSD
                string targetNamespace = "AnetApi/xml/v1/schema/AnetApiSchema.xsd";
                schema.Add(targetNamespace, xsdFilePath); // Load XSD file with the correct targetNamespace

                XmlReaderSettings settings = new XmlReaderSettings();
                settings.Schemas.Add(schema);
                settings.ValidationType = ValidationType.Schema;

                settings.ValidationEventHandler += (sender, args) =>
                {
                    Console.WriteLine($"Validation error: {args.Message}");
                };

                using (StringReader stringReader = new StringReader(xmlContent))
                using (XmlReader reader = XmlReader.Create(stringReader, settings))
                {
                    while (reader.Read()) { } // Perform validation
                }

                return true;
            }
            catch (XmlException ex)
            {
                Console.WriteLine("XML Exception: " + ex.Message);
                return false;
            }
            catch (Exception ex)
            {
                Console.WriteLine("Exception during XML validation: " + ex.Message);
                return false;
            }
        }


        public async Task<string> SendSoapRequestxsd(string soapRequest)
        {
            string[] paths = { "C:/Temp" };
            // Ensure the directory path where the XSD file will be placed
            string directoryPath = Path.Combine(paths); 



            // Check if the directory exists, if not, create it
            if (!Directory.Exists(directoryPath))
            {
                Directory.CreateDirectory(directoryPath);
            }

            // Define the full path to the XSD file
            //string xsdPath = Path.Combine(directoryPath, "out.xsd");
            string xsdPath = "C:/Temp/New.xsd";

            // Check if the XSD file doesn't exist, create it
            if (!File.Exists(xsdPath))
            {
                string xsdContent = @"<?xml version='1.0' encoding='utf-8'?>
<xs:schema xmlns:xs='http://www.w3.org/2001/XMLSchema' targetNamespace='AnetApi/xml/v1/schema/AnetApiSchema.xsd' xmlns='AnetApi/xml/v1/schema/AnetApiSchema.xsd' elementFormDefault='qualified'>
  <xs:element name='createCustomerShippingAddressRequest'>
    <xs:complexType>
      <xs:sequence>
        <xs:element name='merchantAuthentication'>
          <xs:complexType>
            <xs:sequence>
              <xs:element name='name' type='xs:string' />
              <xs:element name='transactionKey' type='xs:string' />
            </xs:sequence>
          </xs:complexType>
        </xs:element>
        <xs:element name='customerProfileId' type='xs:string' />
        <xs:element name='address'>
          <xs:complexType>
            <xs:sequence>
              <xs:element name='firstName' type='xs:string' />
              <xs:element name='lastName' type='xs:string' />
              <xs:element name='company' type='xs:string' minOccurs='0' />
              <xs:element name='address' type='xs:string' />
              <xs:element name='city' type='xs:string' />
              <xs:element name='state' type='xs:string' />
              <xs:element name='zip' type='xs:string' />
              <xs:element name='country' type='xs:string' />
              <xs:element name='phoneNumber' type='xs:string' />
              <xs:element name='faxNumber' type='xs:string' minOccurs='0' />
            </xs:sequence>
          </xs:complexType>
        </xs:element>
        <xs:element name='defaultShippingAddress' type='xs:boolean' />
      </xs:sequence>
    </xs:complexType>
  </xs:element>
</xs:schema>";

                // Write the XSD content to the file
                File.WriteAllText(xsdPath, xsdContent);
            }

            // Assuming SendSoapRequest is already implemented and accepts two parameters: XML request and XSD path
            string result = await SendSoapRequest(soapRequest, xsdPath);

            // Return the result
            return result;
        }
    }
}
