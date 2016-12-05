package com.example.psmo.medteam1;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Konrad on 01.12.2016.
 */

public class AlgoritmListXmlParser {
    private static final String ns = null;
    private final String algorithm;
    public AlgoritmListXmlParser(String desiredAlgorithm) {
        algorithm = desiredAlgorithm;
    }


    public List parse(InputStream in) throws XmlPullParserException, IOException {
        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in, null);
            parser.nextTag();
            return readList(parser);
        } finally {
            in.close();
        }
    }

    private List readList(XmlPullParser parser) throws XmlPullParserException, IOException {
        List elements = new ArrayList();

        int id = -1;
        String name = "";
        parser.require(XmlPullParser.START_TAG, ns, "algorithms");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String algName = parser.getName();
            if (algName.equals("name")){
                name = readText(parser);
            }
            else if (algName.equals("element")){
                elements.add(readElement(parser));
            }else {
                skip(parser);
            }
        }
        return elements;
    }
    private SingleAlgorithm readElement(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, "element");
        int id = Integer.parseInt(parser.getAttributeValue(null, "id"));
        String name = "";
        String file = "";
        String image = "";
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String tagName = parser.getName();
            if (tagName.equals("name")) {
                name = readTagText(parser, "name");
            }else if (tagName.equals("file")) {
                file = readTagText(parser, "file");
            }else if (tagName.equals("image")) {
                image = readTagText(parser, "image");
            }else {
                skip(parser);
            }
        }
        return new SingleAlgorithm(id, name, file, image);
    }

    private String readTagText(XmlPullParser parser, String tagName) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, tagName);
        String description = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, tagName);
        return description;
    }

    private String readText(XmlPullParser parser) throws IOException, XmlPullParserException {
        String result = "";
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.getText();
            parser.nextTag();
        }
        return result;
    }

    private void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            throw new IllegalStateException();
        }
        int depth = 1;
        while (depth != 0) {
            switch (parser.next()) {
                case XmlPullParser.END_TAG:
                    depth--;
                    break;
                case XmlPullParser.START_TAG:
                    depth++;
                    break;
            }
        }
    }
}
