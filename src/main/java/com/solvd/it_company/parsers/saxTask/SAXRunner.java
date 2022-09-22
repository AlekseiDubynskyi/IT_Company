package com.solvd.it_company.parsers.saxTask;

import org.apache.logging.log4j.LogManager;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import org.apache.logging.log4j.Logger;

public class SAXRunner {
    private static final Logger LOGGER = LogManager.getLogger(SAXRunner.class);
    private SAXParser saxParser = null;

    private SAXParser createSaxParser() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            saxParser = factory.newSAXParser();
            return saxParser;
        } catch (ParserConfigurationException | SAXException e) {
            LOGGER.info(e.getMessage());
            return saxParser;
        }
    }

    public List<AddressesSAX> parseAddresses() {
        var handler = new AddressHandler();
        String fileName = "src/main/java/com/solvd/it_company/parsers/saxTask/Addresses.xml";
        File xmlDocument = Paths.get(fileName).toFile();

        try {
            SAXParser parser = createSaxParser();
            parser.parse(xmlDocument, handler);
        } catch (SAXException | IOException e) {
            LOGGER.info(e.getMessage());
        }
        return handler.getAddressesSAXList();
    }
}

