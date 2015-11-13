package com.cy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class XMLParse {
    private static final String filePath = "account_login.xml";

    public static void main(String[] args) {
        SAXParserFactory saxfa = SAXParserFactory.newInstance();
        HandlerParseXml handlerParseXml = new HandlerParseXml();
        try {
            SAXParser saxparser = saxfa.newSAXParser();
            InputStream is = new FileInputStream(filePath);
            saxparser.parse(is, handlerParseXml);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        CodeGenerator codeGenerator = new CodeGenerator(handlerParseXml.getList());
        System.out.println(codeGenerator.getContent2());
    }
}
