package com.xml;

public class TestXmlAction {
	
	 private static final String FILE_NAME = "D://app//static_content//activity_documents//test.xml";

	public static void main(String[] args) {
		XmlUtil.WriteXmlFile(FILE_NAME);
		XmlUtil.readXmlFile(FILE_NAME);
	}
}
