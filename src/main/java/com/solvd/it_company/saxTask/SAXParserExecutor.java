package com.solvd.it_company.saxTask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class SAXParserExecutor {
    private static final Logger LOGGER = LogManager.getLogger(SAXParserExecutor.class);

    public static void main(String[] args) {
        var runner = new SAXRunner();
        List<AddressesSAX> lines = runner.parseAddresses();

        lines.forEach(LOGGER::info);
    }
}
