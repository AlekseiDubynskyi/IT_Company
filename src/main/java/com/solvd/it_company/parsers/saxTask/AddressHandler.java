package com.solvd.it_company.parsers.saxTask;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class AddressHandler extends DefaultHandler {
    private final List<AddressesSAX> addressesSAXList = new ArrayList<>();
    private AddressesSAX addressesSAX;
    boolean isStreet = false;
    boolean isDistrict = false;
    boolean isPostalCode = false;
    boolean isCity = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("address")) {
            addressesSAX = new AddressesSAX();
            String id = attributes.getValue("id");
            addressesSAX.setId(Integer.parseInt(id));
        } else if (qName.equalsIgnoreCase("street")) {
            isStreet = true;
        } else if (qName.equalsIgnoreCase("district")) {
            isDistrict = true;
        } else if (qName.equalsIgnoreCase("postalCode")) {
            isPostalCode = true;
        } else if (qName.equalsIgnoreCase("city")) {
            isCity = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("address")) {
            addressesSAXList.add(addressesSAX);
        }
    }

    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        if (isStreet) {
            addressesSAX.setStreet(new String(chars, start, length));
            isStreet = false;
        } else if (isDistrict) {
            addressesSAX.setDistrict(new String(chars, start, length));
            isDistrict = false;
        } else if (isPostalCode) {
            addressesSAX.setPostalCode(new String(chars, start, length));
            isPostalCode = false;
        } else if (isCity) {
            addressesSAX.setCity(new String(chars, start, length));
            isCity = false;
        }
    }

    public List<AddressesSAX> getAddressesSAXList() {
        return addressesSAXList;
    }
}
