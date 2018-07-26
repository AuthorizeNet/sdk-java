package net.authorize.util;

import java.io.*;
import org.w3c.dom.*;

/**
*
* @deprecated since version 1.9.8
* @deprecated We have reorganized and simplified the Authorize.Net API to ease integration and to focus on merchants' needs.
* @deprecated We have deprecated AIM, ARB, CIM, and Reporting as separate options, in favor of AuthorizeNet::API (package: net.authorize.api.*).
* @deprecated We have also deprecated SIM as a separate option, in favor of Accept Hosted. See https://developer.authorize.net/api/reference/features/accept_hosted.html for details on Accept Hosted.
* @deprecated For details on AIM, see https://github.com/AuthorizeNet/sample-code-java/tree/master/src/main/java/net/authorize/sample/PaymentTransactions.
* @deprecated For details on the deprecation and replacement of legacy Authorize.Net methods, visit https://developer.authorize.net/api/upgrade_guide/.
*
*/
@Deprecated
public class XmlTreeUtil{

	private String tabSpace="   ";
	private String lineSpace="\n";
	private boolean print_document_node = true;

	public XmlTreeUtil(){

	}
	public void setPrintDocumentNode(boolean b){
		print_document_node = b;
	}
	public void setCollapsed(){
		tabSpace="";
		lineSpace="";
	}
	public String printTree(Document XMLDocument){
		return new String(printTreeBytes(XMLDocument));
	}

	public byte[] printTreeBytes(Document XMLDocument){
		byte[] xmlData = new byte[0];
		try{
			ByteArrayOutputStream baos=new ByteArrayOutputStream();
			printTree(XMLDocument,baos);
			xmlData= baos.toByteArray();
			baos.close();
		}
		catch(IOException e){
			/* */
		}
		return xmlData;
	}

	public void printTree(Document XMLDocument, OutputStream os){
		int nodeLevel=0;
		try{
			_printTree(XMLDocument,os,nodeLevel);
		}
		catch(IOException e){
			e.printStackTrace();
		}

	}
	private void _printTree(Node node,OutputStream os,int nodeLevel) throws IOException{
		switch(node.getNodeType()){
			case Node.DOCUMENT_NODE:

				if(print_document_node){
					String data=new String("<?xml version=\"1.0\"?>" + lineSpace);
					os.write(data.getBytes());
				}

				Document doc=(Document)node;
				_printTree(doc.getDocumentElement(),os,nodeLevel);
				break;
			case Node.ELEMENT_NODE:
				String tab="";
				for(int i=0;i<nodeLevel;i++){
					tab+=tabSpace;
				}
				nodeLevel++;
				String name=node.getNodeName();
				String elmName=(tab + "<" + name);
				os.write(elmName.getBytes());
				NamedNodeMap attributes=node.getAttributes();
				for(int i=0;i<attributes.getLength();i++){
					Node current = attributes.item(i);
					String attrSet=new String(" " + current.getNodeName() + "=\"" + current.getNodeValue() + "\"");
					os.write(attrSet.getBytes());
				}

				NodeList children=node.getChildNodes();

				// whitespace counted as childnode

				if(children!=null && children.getLength()>0){
					String endElm=new String(">" + lineSpace);
					os.write(endElm.getBytes());
					for(int i=0;i<children.getLength();i++){
						_printTree(children.item(i),os,nodeLevel);
					}
					String closeElm=new String(tab + "</" + name + ">" + lineSpace);
					os.write(closeElm.getBytes());
				}
				else{
					String closeElm=new String(" />" + lineSpace);
					os.write(closeElm.getBytes());
				}
				nodeLevel--;
				break;
			case Node.TEXT_NODE:
				String value=node.getNodeValue();
				if(value!=null){
					value=value.trim();
					os.write(value.getBytes());
				}
				else{
//					System.out.println(node.hasChildNodes());
				}
				break;
			case Node.CDATA_SECTION_NODE:
				String dataValue=node.getNodeValue();
				if(dataValue!=null && dataValue.length() > 0){
					dataValue = new String("<![CDATA[" +  dataValue + "]]>");
					os.write(dataValue.getBytes());
				}
				break;
			case Node.PROCESSING_INSTRUCTION_NODE:
				break;
			case Node.ENTITY_REFERENCE_NODE:
				break;
			case Node.DOCUMENT_TYPE_NODE:
				break;
		}
	}
}
