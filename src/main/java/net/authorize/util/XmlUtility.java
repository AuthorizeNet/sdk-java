package net.authorize.util;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

/**
 * Helper methods for serializing and de-serializing to XML using JAXB
 * @author ramittal
 *
 */
public final class XmlUtility {
	private static Logger logger = LogManager.getLogger(XmlUtility.class);
	private static final String XmlHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
	private static JAXBContext request_ctx = null;
	private static JAXBContext response_ctx = null;
	private static HashMap<String, JAXBContext> jaxbContext = new HashMap<String, JAXBContext>();


	/**
	* Default C'tor, cannot be instantiated
	*/
	private XmlUtility() {
	}

	/**
	 * Helper method to serialize an object to XML. Requires object to be Serializable
	 * @param entity Object to serialize
	 * @param <T> class that implements Serializable
	 * @return String XML representation of object
	 * @throws IOException if errors during serialization
	 * @throws JAXBException if errors during serialization
	 */
	public static synchronized <T extends Serializable> String getXml(T entity) throws IOException, JAXBException
	{
		StringWriter sw = new StringWriter();

		if ( null != entity)
		{
			if(!jaxbContext.containsKey(entity.getClass().toString()))
			{
				request_ctx = JAXBContext.newInstance(entity.getClass());
				jaxbContext.put(entity.getClass().toString(), request_ctx);
			}
			else
			{
				request_ctx = jaxbContext.get(entity.getClass().toString());
			}
	
			if(request_ctx != null)
			{
				Marshaller m = request_ctx.createMarshaller();
				m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
				m.marshal(entity, sw);
			}
		}
		sw.flush();
		sw.close();
		
		return sw.toString();
	}

	/**
	 * Helper method to de-serialize XML to an object. Requires object to be Serializable
	 * @param xml object serialized into valid XML
	 * @param classType Class Type of the object to be de-serialized into
	 * @param <T> class that implements Serializable
	 * @return T De-serialized object
	 * @throws JAXBException if errors during de-serialization
	 * @throws ParserConfigurationException 
	 * @throws SAXException 
	 */
	@SuppressWarnings("unchecked")
	public static synchronized <T extends Serializable> T create(String xml, Class<T> classType) throws JAXBException, ParserConfigurationException, SAXException
	{
		T entity = null;
		
		//Disable XXE
		SAXParserFactory spf = SAXParserFactory.newInstance();
		spf.setNamespaceAware(true);
		spf.setValidating(true);		   
		spf.setFeature("http://xml.org/sax/features/external-general-entities", false);
		spf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
		spf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

		//Do unmarshall operation
		Source xmlSource = new SAXSource(spf.newSAXParser().getXMLReader(), new InputSource(new StringReader(xml)));

		//make sure we have not null and not-empty string to de-serialize
		if ( null != xml && !xml.trim().isEmpty())
		{
			if(!jaxbContext.containsKey(classType.toString()))
			{
				response_ctx = JAXBContext.newInstance(classType);
				jaxbContext.put(classType.toString(), response_ctx);
			}
			else
			{
				response_ctx = jaxbContext.get(classType.toString());
			}
			
			if(response_ctx != null)
			{
				Unmarshaller um = response_ctx.createUnmarshaller();
				try {
					Object unmarshaled = um.unmarshal(xmlSource);
					if ( null != unmarshaled)
					{
						try {
							entity = classType.cast(unmarshaled);
						} catch (ClassCastException cce) {
							if (unmarshaled instanceof JAXBElement) {
								@SuppressWarnings("rawtypes")
								JAXBElement element = (JAXBElement) unmarshaled;
								if ( null != element.getValue() && element.getValue().getClass()==classType) {
									entity = (T) element.getValue();
								}
							}
						}
					}
				} catch (JAXBException jaxbe) {
					LogHelper.info(logger, "Exception - while deserializing text:'%s' ", xml);
					LogHelper.warn(logger, "Exception Details-> Code:'%s', Message:'%s'", jaxbe.getErrorCode(), jaxbe.getMessage());
					throw jaxbe;
				}
			}
		}

		return entity;
	}
	
	/**
	 * Helper method to encode a string to XML
	 * Returns the same string if null or empty
	 * @param valueToSerialize string value to encode into xml
	 * @return xml encoded string
	 */
	public static String escapeStringForXml( String valueToSerialize) {
		String retVal = valueToSerialize;
		
		if ( null != valueToSerialize && valueToSerialize.length() > 0) { 
			try {
				XmlUtility.XmlString value = new XmlString(valueToSerialize);
				String xmlString = XmlUtility.getXml(value);
				int begin = xmlString.indexOf(XmlString.VALUE_BEGIN) + XmlString.VALUE_BEGIN.length();
				int end = xmlString.indexOf(XmlString.VALUE_END);
				if (begin >= 0 && end >= 0)
				{
					retVal = xmlString.substring(begin, end);
				}
			}
			catch ( Exception e)
			{
				LogHelper.warn(logger, "Error encoding to XML, value: '%s', ErrorMessage: '%s'", valueToSerialize, e.getMessage());
				retVal = valueToSerialize;
			}
		}
		return 	retVal;	
	}

	/**
	 * Helper method to decode a string from XML string
	 * Returns the same string if null or empty
	 * @param valueToDeserialize string value to decode from xml
	 * @return string decoded from xml
	 */
	public static String descapeStringForXml(String valueToDeserialize) {
		String retVal = valueToDeserialize;
		
		if ( null != valueToDeserialize && valueToDeserialize.length() > 0)
		{
			try {
				StringBuilder value = new StringBuilder();
				value.append(XmlString.CLASS_BEGIN).append(XmlString.VALUE_BEGIN);
				value.append(valueToDeserialize);
				value.append(XmlString.VALUE_END).append(XmlString.CLASS_END);
				XmlString xmlString = XmlUtility.create(value.toString(), XmlString.class);
				if ( null != xmlString) { 
					retVal = xmlString.getXmlStringValueUnlikelyToBeElementUsedInRealXmlStringValue();
				}
			}
			catch ( Exception e)
			{
				LogHelper.warn(logger, "Error decoding from XML, value: '%s', ErrorMessage: '%s'", valueToDeserialize, e.getMessage());
				retVal = valueToDeserialize;
			}
		}
		return 	retVal;	
	}

	/**
	 * Removes the XML prologue 
	 * @param entity object to remove prologue 
	 * @return String  String XML representation of root element xml without prologue
	 */
	public static  <T extends Serializable> String getRootElementXml(T entity) {
		String rootElementXml;
		try {
			String xml = getXml(entity);
			rootElementXml = getRootElementXml(xml);
		} catch (Exception e) {
			LogHelper.warn(logger, "Unable to serialize into xml: '%s'", entity);
			rootElementXml = String.format( "<%s/>", entity.getClass().getSimpleName());
		}
		
		return rootElementXml;
	}
	
	/**
	 * Removes the XML prologue 
	 * @param xmlString string to remove prologue 
	 * @return String  root element xml without prologue
	 */
	public static String getRootElementXml(String xmlString) {
		return xmlString.replace(XmlHeader, "");
	}
	
	@XmlRootElement
	static class XmlString implements Serializable {
		public static final String VALUE_BEGIN = "<xmlStringValueUnlikelyToBeElementUsedInRealXmlStringValue>";
		public static final String VALUE_END = "</xmlStringValueUnlikelyToBeElementUsedInRealXmlStringValue>";
		public static final String CLASS_BEGIN = "<xmlString>";
		public static final String CLASS_END = "</xmlString>";
		
		private static final long serialVersionUID = 1L;
		String xmlStringValueUnlikelyToBeElementUsedInRealXmlStringValue = null;
		
		XmlString() {
		}
		
		XmlString(String value) {
			this.setXmlStringValueUnlikelyToBeElementUsedInRealXmlStringValue(value);
		}

		public String getXmlStringValueUnlikelyToBeElementUsedInRealXmlStringValue() {
			return xmlStringValueUnlikelyToBeElementUsedInRealXmlStringValue;
		}
		public void setXmlStringValueUnlikelyToBeElementUsedInRealXmlStringValue(String value) {
			this.xmlStringValueUnlikelyToBeElementUsedInRealXmlStringValue = value;
		}
		
		public String toString() {
			return xmlStringValueUnlikelyToBeElementUsedInRealXmlStringValue;
		}
	}
}
