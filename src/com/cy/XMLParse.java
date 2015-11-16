package com.cy;

import java.io.*;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class XMLParse {

    public static void main(String[] args) {
        File[] files= new File("./").listFiles();
        SAXParserFactory saxfa = SAXParserFactory.newInstance();
        HandlerParseXml handlerParseXml = new HandlerParseXml();
        for (File file:files) {
            String fileName=file.getName();
            if (!fileName.endsWith("xml")) continue;
            try {
                SAXParser saxparser = saxfa.newSAXParser();
                InputStream is = new FileInputStream(fileName);
                saxparser.parse(is, handlerParseXml);

            } catch (Exception e) {
                e.printStackTrace();
            }

            CodeGenerator codeGenerator = new CodeGenerator(handlerParseXml.getList());
//            System.out.println(codeGenerator.getContent2());
            Utils.write_UTF8_FileContent(new File(fileName.substring(0,fileName.lastIndexOf(".")+1)+"java"),codeGenerator.getContent2());
        }
    }
}
