package com.example.psmo.medteam1;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Konrad on 21.11.2016.
 */

public class XmlParser {
    private static final String ns = null;

    public List parse(InputStream in) throws XmlPullParserException, IOException {
        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in, null);
            parser.nextTag();
            return readAlgorithm(parser);
        } finally {
            in.close();
        }
    }

    private List readAlgorithm(XmlPullParser parser) throws XmlPullParserException, IOException {
        List elements = new ArrayList();

        int id = -1;
        String algName= null;
        int steps = -1;
        String meantime = null;
        parser.require(XmlPullParser.START_TAG, ns, "id");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals("id")) {
                id = Integer.parseInt(readText(parser));
            }else if (name.equals("name")){//odczytal name i koniec xd
                algName = readText(parser);
            }else if (name.equals("steps")){
                steps = Integer.parseInt(readText(parser));
            }else if (name.equals("meantime")){
                meantime = readText(parser);
            }else
            if (name.equals("element")){
                elements.add(readElement(parser));
            }
            else {
                skip(parser);
            }
        }
        return elements;
    }
    private AlgorithmElement readElement(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, "element");
        int id = Integer.parseInt(parser.getAttributeValue(null, "id"));
        String description= null;
        List successors = null;
        String b64Image= null;
        String extraDescription= null;
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals("description")) {
                description = readDescription(parser);
            } else if (name.equals("successors")) {
                successors = readSuccessors(parser);
            } else if (name.equals("image")) {
                b64Image = readB64Image(parser);
            } else if (name.equals("extraDescription")) {
                extraDescription = readExtraDescription(parser);
            } else {
                skip(parser);
            }
        }
        return new AlgorithmElement(id, description, successors, b64Image, extraDescription);
    }

    private String readDescription(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "description");
        String description = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "description");
        return description;
    }

    private String readB64Image(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "image");
        String b64Image = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "image");
        return b64Image;
    }

    private List readSuccessors(XmlPullParser parser) throws IOException, XmlPullParserException {
        List<Successor> successors = new ArrayList<Successor>();
        parser.require(XmlPullParser.START_TAG, ns, "successors");
        String tag = null;
        String relType = null;
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            parser.require(XmlPullParser.START_TAG, ns, "child");

            int tmpId = -1;
            String tmpDesc = null;
            tag = parser.getName();
            relType = parser.getAttributeValue(null, "id");
            if (tag.equals("child")) {
                tmpId = Integer.parseInt(relType);
            }
            tmpDesc = readText(parser);
            successors.add(new Successor(tmpId, tmpDesc));

            parser.require(XmlPullParser.END_TAG, ns, "child");
        }
        return successors;
    }

    private String readExtraDescription(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "extraDescription");
        String exDescription = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "extraDescription");
        return exDescription;
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
