package com.cy;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class HandlerParseXml extends DefaultHandler {

    private List<WidgetInfo> list;

    @Override
    public void startDocument() throws SAXException {
        list = new ArrayList<WidgetInfo>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        add_elelement_to_list_widget(qName, attributes);
    }

    private void add_elelement_to_list_widget(String widgetType, Attributes attributes) {
        WidgetInfo widgetInfo = new WidgetInfo();
        widgetInfo.setType(widgetType);
        for (int i = 0, len = attributes.getLength(); i < len; i++) {
            String str = attributes.getValue(i).toString();
            if (attributes.getLocalName(i).equals("android:id") && attributes.getValue(i).toString().startsWith("@+id/m")) {
                widgetInfo.setIdName(str.substring(str.indexOf('/') + 1, str.length()));
                list.add(widgetInfo);
            }
        }
    }
    public List<WidgetInfo> getList() {
        return list;
    }
}
