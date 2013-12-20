package net.authorize.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;


public class BasicXmlDocument implements Serializable {

	private static final long serialVersionUID = 1L;

	Document document;
	private String sourceFile;
	private boolean accessible=false;
//	private int sourceType=0;
	DocumentBuilderFactory dbf;
	DocumentBuilder db;
	private long xmlParseTime=-1;
	private String resolve_path=null;

	private ArrayList<String> errors;

	public BasicXmlDocument(){
		this.errors = new ArrayList<String>();
		initClass();
	}
	public BasicXmlDocument(String sourceFile){
		this.errors = new ArrayList<String>();
		this.sourceFile=sourceFile;
	}
	private void initClass(){
		try{
			dbf = DocumentBuilderFactory.newInstance();
			// dbf.setValidating(true);
			db=dbf.newDocumentBuilder();
		}
		catch(ParserConfigurationException e){
			System.out.println("Error in parsing: " + e);
		}
	}
	public void setResolvePath(String p){
		resolve_path = p;
	}
	public long getParseTime(){
		return xmlParseTime;
	}
	public boolean IsAccessible(){
		return accessible;
	}
	public Document getDocument(){
		return document;
	}
	public Element getDocumentElement(){
		return document.getDocumentElement();
	}

	public Element createElement(String name){
		return document.createElement(name);
	}

	public ArrayList<String> getErrors(){
		return this.errors;
	}

	public void addError(String message){
		this.errors.add(message);
		System.out.println(message);
	}

	public boolean removeChildren(Node ref){
		boolean ret = false;
		if(ref == null || ref.hasChildNodes() == false) return ret;
		for(int i = ref.getChildNodes().getLength() - 1; i >= 0; i--){
			Node child = ref.getChildNodes().item(i);
			ref.removeChild(child);
		}
		ret = true;
		return ret;
	}

	public boolean parse(){
		return parse(sourceFile);
	}

	public boolean parse(String xmlFile){
		File f=new File(xmlFile);
		if(!f.exists()){
			addError("parse(String xmlFile):: File " + f.getAbsolutePath() + " does not exist");
			return false;
		}
		sourceFile=xmlFile;
		return parse(f);
	}

	public void saveDocument(String fileName){
		try{
			File f=new File(fileName);
			FileOutputStream fileOut=new FileOutputStream(f);
			XmlTreeUtil xtu=new XmlTreeUtil();
			xtu.printTree(document,fileOut);
			fileOut.close();
		}
		catch(IOException e){
			addError("saveDocument(String fileName):: " + e.toString());
			e.printStackTrace();
		}
	}

	public boolean parse(File in_file){
		boolean returnType=false;
		try{
			FileInputStream fis=new FileInputStream(in_file);
			returnType=parse(fis);
			fis.close();
		}
		catch(IOException e){
			addError("parse(File in_file):: " + e.toString());
//			System.out.println("Error in parsing: " + e);
		}
		return returnType;
	}

	public boolean parse(InputStream in){
		boolean returnType=false;
		try{
/*
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db=dbf.newDocumentBuilder();
*/
			long start=System.currentTimeMillis();

//			db.setErrorHandler(new BasicXMLDocumentErrorHandler());
			db.setEntityResolver(new BasicXmlDocumentEntityResolver(this));

			document=db.parse(in);
			long stop=System.currentTimeMillis();



			xmlParseTime=(stop - start);
			accessible=true;
//			sourceType=1;
			returnType=true;
		}
		catch(IOException e){
			addError("parse(InputStream in):: " + e.toString());
//			System.out.println("Error in parsing: " + e);
		}
		catch(SAXException e){
			addError("parse(InputStream in):: " + e.toString());
//			System.out.println("Error in parsing: " + e);
		}
		return returnType;
	}

	public boolean parseString(String xmlValue){
		return (parse(new ByteArrayInputStream(xmlValue.getBytes())));
	}
	public boolean parseBytes(byte[] xmlBytes){
		return (parse(new ByteArrayInputStream(xmlBytes)));
	}

	public String dump(){
		return dump(true);
	}
	public String dump(boolean collapse){
		XmlTreeUtil xtu=new XmlTreeUtil();
		if(collapse) xtu.setCollapsed();
		return xtu.printTree(document);
	}
	public boolean dumpToDisk(String fileName){
		return dumpToDisk(fileName, true);
	}
	public boolean dumpToDisk(String fileName, boolean collapse){
		try{
			File f=new File(fileName);
			FileOutputStream fos=new FileOutputStream(f);
			fos.write(dump(collapse).getBytes());
			fos.close();
			return true;
		}
		catch(IOException e){
			addError("dumpToDisk(String fileName):: " + e.toString());
//			System.out.println(e);
		}
		return false;
	}

	class BasicXmlDocumentEntityResolver implements EntityResolver{
		@SuppressWarnings("unused")
		private BasicXmlDocument xml_document = null;
		public BasicXmlDocumentEntityResolver(BasicXmlDocument xml_document){
			this.xml_document = xml_document;
		}
		public InputSource resolveEntity (String publicId, String systemId){
			if(resolve_path==null) return null;
			return null;
		}
	}

	class BasicXMLDocumentErrorHandler implements ErrorHandler{
		public BasicXMLDocumentErrorHandler(){

		}
		public void error(SAXParseException spe_error){
			System.out.println("SAXParseException Error: " + spe_error.toString() + " / " + spe_error.getPublicId());
		}

		public void fatalError(SAXParseException spe_fatal){
			System.out.println("SAXParseException Fatal: " + spe_fatal.toString());
		}

		public void warning(SAXParseException spe_warn){
			System.out.println("SAXParseException Warning: " + spe_warn.toString());
		}
	}

	/**
	 * Helper for getting element text from a parent.
	 *
	 * @param parent_el
	 * @param element_name
	 * @return element text
	 */
	public static String getElementText(Element parent_el, String element_name){
		String out_val = null;
		NodeList match_list = parent_el.getElementsByTagName(element_name);
		if(match_list.getLength() == 0) return out_val;
		Element match_el = (Element)match_list.item(0);
		if(match_el.hasChildNodes()){
			out_val = match_el.getFirstChild().getNodeValue();
		}
		return out_val;
	}


}
