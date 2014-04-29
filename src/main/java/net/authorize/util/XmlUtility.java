package net.authorize.util;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Helper methods for serializing and de-serializing to XML using JAXB
 * @author ramittal
 *
 */
@XmlRootElement
public final class XmlUtility {

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
	public static <T extends Serializable> String getXml(T entity) throws IOException, JAXBException
	{
        JAXBContext ctx = JAXBContext.newInstance(entity.getClass());

        Marshaller m = ctx.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter sw = new StringWriter();
        m.marshal(entity, sw);
        sw.close();
        
        return sw.toString();
	}

	/**
	 * Helper method to de-serialize XML to an object. Requires object to be Serializable
	 * @param xml object serialized into valid XML
	 * @param classType Class Type of the object to be de-serialized into
	 * @param <T> class that implements Serializable
	 * @return T De-serialized object
	 * @throws IOException if errors during de-serialization
	 * @throws JAXBException if errors during de-serialization
	 */
	public static <T extends Serializable> T create(String xml, Class<T> classType) throws IOException, JAXBException
	{
		T entity = null;
        JAXBContext ctx = JAXBContext.newInstance(classType);
        Unmarshaller um = ctx.createUnmarshaller();
        Object unmarshaled = um.unmarshal(new StringReader(xml));
        if ( null != unmarshaled)
        {
        	entity = (T) classType.cast(unmarshaled);
        }

        return entity;
	}
}
