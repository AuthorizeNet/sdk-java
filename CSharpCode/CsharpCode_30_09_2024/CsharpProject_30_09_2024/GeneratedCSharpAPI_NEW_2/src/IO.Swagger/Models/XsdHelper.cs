using System;
using System.IO;
using System.Xml;
using System.Xml.Serialization;
using Newtonsoft.Json;

namespace IO.Swagger.Models
{
    public class XsdHelper
    {
        /// <summary>
        /// Serializes a C# object to XML based on the generated XSD class.
        /// </summary>
        /// <typeparam name="T">Type of object to serialize.</typeparam>
        /// <param name="objectToSerialize">The object to serialize.</param>
        /// <returns>XML representation of the object.</returns>
        //public string SerializeToXml<T>(T objectToSerialize)
        //{
        //    if (objectToSerialize == null)
        //        throw new ArgumentNullException(nameof(objectToSerialize));

        //    XmlSerializer serializer = new XmlSerializer(typeof(T));

        //    using (StringWriter textWriter = new StringWriter())
        //    {
        //        serializer.Serialize(textWriter, objectToSerialize);
        //        return textWriter.ToString();
        //    }
        //}
        /// <summary>
        /// Converts a JSON string to a C# object.
        /// </summary>
        /// <typeparam name="T">The type of object to convert to.</typeparam>
        /// <param name="jsonData">JSON data to convert.</param>
        /// <returns>Deserialized C# object.</returns>
        //public T ConvertJsonToCSharpObject<T>(string jsonData)
        //{
        //    if (string.IsNullOrEmpty(jsonData))
        //        throw new ArgumentNullException(nameof(jsonData));

        //    return JsonConvert.DeserializeObject<T>(jsonData);
        //}

        /// <summary>
        /// Converts a C# object to a JSON string.
        /// </summary>
        /// <typeparam name="T">The type of object to convert.</typeparam>
        /// <param name="objectToConvert">The C# object to convert.</param>
        /// <returns>JSON string representation.</returns>
        //public string ConvertObjectToJson<T>(T objectToConvert)
        //{
        //    if (objectToConvert == null)
        //        throw new ArgumentNullException(nameof(objectToConvert));

        //    //return JsonConvert.SerializeObject(objectToConvert);
        //    return JsonConvert.DeserializeObject(objectToConvert);
        //}
        public string ConvertObjectToJson<T>(T objectToConvert)
        {
            if (objectToConvert == null)
                throw new ArgumentNullException(nameof(objectToConvert));

            // Serialize the object to JSON
            return JsonConvert.SerializeObject(objectToConvert);
        }

        // Method to convert C# object to JSON string
        public string FirstConvertObjectToJson<T>(T obj)
        {
            return JsonConvert.SerializeObject(obj, (Newtonsoft.Json.Formatting)System.Xml.Formatting.Indented);
        }

        // Method to convert JSON string to XML string
        public string ConvertJsonToXml(string json)
        {
            XmlDocument doc = JsonConvert.DeserializeXmlNode(json, "Root");
            return doc.OuterXml;
        }

        public string ToXml()
        {
            var xmlSerializer = new XmlSerializer(typeof(Address));
            using (var stringWriter = new StringWriter())
            {
                xmlSerializer.Serialize(stringWriter, this);
                return stringWriter.ToString();
            }
        }

        public static Address FromXml(string xml)
        {
            var xmlSerializer = new XmlSerializer(typeof(Address));
            using (var stringReader = new StringReader(xml))
            {
                return (Address)xmlSerializer.Deserialize(stringReader);
            }
        }
        public static Address FromJson(string json)
        {
            return JsonConvert.DeserializeObject<Address>(json);
        }
    }
}
