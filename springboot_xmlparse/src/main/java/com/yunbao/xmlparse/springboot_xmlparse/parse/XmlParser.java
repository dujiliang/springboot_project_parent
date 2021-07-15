package com.yunbao.xmlparse.springboot_xmlparse.parse;

import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

public class XmlParser {


    /***
     * <p>sdsdfsdf</p>
     * <p>@param args</p>
     */
    public static void main(String[] args) {
         /*String resource = "classpath:nodelet_test.xml";*/
        URL resource = XmlParser.class.getClassLoader().getResource("nodelet_test.xml");
        File file = new File(resource.getFile());
        try {
            InputStream inputSource = new FileInputStream(file);


            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false);
            factory.setNamespaceAware(false);
            factory.setIgnoringComments(true);
            factory.setIgnoringElementContentWhitespace(false);
            factory.setCoalescing(false);
            factory.setExpandEntityReferences(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document parse = builder.parse(inputSource);


            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xPath = xPathFactory.newXPath();

            String string = (String)xPath.evaluate("/employee/birth_date/year", parse, new QName("http://www.w3.org/1999/XSL/Transform", "STRING"));
            System.out.println(string);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
