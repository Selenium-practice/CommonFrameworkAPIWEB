package com.xml.utils;

import java.util.ArrayList;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;



public class XmlUtils {
	Document document = null;
	
	/**
	 * 
	 * @param filename
	 */
	
	public void loadXmlWithNameSpace(String filename) {
		document = null;

		String XmlFile = "./src/test/resources/" + filename + ".xml";
		SAXReader reader = new SAXReader();
		try {
			document = reader.read(XmlFile);
			document.accept(new NameSpaceCleaner());
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * 
	 * @param filename
	 */

	public void loadXml(String filename) {
		document = null;

		String XmlFile = "./src/test/resources/" + filename + ".xml";
		SAXReader reader = new SAXReader();
		try {
			document = reader.read(XmlFile);
			document.accept(new NameSpaceCleaner());
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * 
	 * @param filename
	 * @param nodeName
	 * @return
	 */
	
	public List<Node> getNodes(String filename, String nodeName) {
		this.loadXml(filename);
		List<Node> itemNodeList = document.selectNodes("//" + nodeName);
		return itemNodeList;
	}
	
	
	/**
	 * 
	 * @param filename
	 * @param nodeName
	 * @return
	 */
	public String  getNodeValue(String filename, String nodeName) {
		this.loadXml(filename);
		Node itemNodeList = document.selectSingleNode("//" + nodeName);
		return itemNodeList.getText();
	}
	
	/**
	 * 
	 * @param filename
	 * @param nodeName
	 * @param attrname+
	 * @return
	 */
	
	
	public String  getNodeAttribute(String filename, String nodeName,String attrname) {
		this.loadXml(filename);
		Node itemNodeList = document.selectSingleNode("//" + nodeName);
		String value=itemNodeList.valueOf("@"+attrname);
		return value;
	}


	
	public List<String> getListOfNodeValues(String filename, String nodeName) {
		this.loadXml(filename);
		List<String> values=new ArrayList<String>();
		List<Node> itemNodeList = document.selectNodes("//" + nodeName);
		for (Node node : itemNodeList) {
			
			values.add(node.getText());
			
		}
		
		return values;
		
		
	}


}
