package com.xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class XmlUtil {

	public static void WriteXmlFile(String path) {
		 try {

			    Document doc = new Document();
			    doc.setRootElement(new Element("StaffDetails"));
				Element staff = new Element("staff");
				staff.setAttribute(new Attribute("id", "1"));
				staff.addContent(new Element("firstname").setText("Santosh Kumar"));
				staff.addContent(new Element("lastname").setText("Verma"));
				staff.addContent(new Element("nickname").setText("SRAJ"));
				staff.addContent(new Element("salary").setText("2000"));

				doc.getRootElement().addContent(staff);

				Element staff2 = new Element("staff");
				staff2.setAttribute(new Attribute("id", "2"));
				staff2.addContent(new Element("firstname").setText("Ganesh"));
				staff2.addContent(new Element("lastname").setText("Raj"));
				staff2.addContent(new Element("nickname").setText("fong"));
				staff2.addContent(new Element("salary").setText("28525"));

				doc.getRootElement().addContent(staff2);

				// new XMLOutputter().output(doc, System.out);
				XMLOutputter xmlOutput = new XMLOutputter();

				// display nice nice
				xmlOutput.setFormat(Format.getPrettyFormat());
				xmlOutput.output(doc, new FileWriter(path));

				System.out.println("File Saved!");
			  } catch (IOException io) {
				System.out.println(io.getMessage());
			  }
	}
	public static void readXmlFile(String filePath) {
		  
		  File xmlFile = new File(filePath);

		  try {
			  
		    SAXBuilder builder = new SAXBuilder();
			  
			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();
			List list = rootNode.getChildren("staff");

			for (int i = 0; i < list.size(); i++) {

			   Element node = (Element) list.get(i);

			   System.out.println("First Name : " + node.getChildText("firstname"));
			   System.out.println("Last Name : " + node.getChildText("lastname"));
			   System.out.println("Nick Name : " + node.getChildText("nickname"));
			   System.out.println("Salary : " + node.getChildText("salary"));

			}

		  } catch (IOException io) {
			System.out.println(io.getMessage());
		  } catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		  }
		}
}
