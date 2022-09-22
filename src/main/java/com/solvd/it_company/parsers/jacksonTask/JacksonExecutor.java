package com.solvd.it_company.parsers.jacksonTask;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class JacksonExecutor {
    private static final Logger LOGGER = LogManager.getLogger(JacksonExecutor.class);

    public static void main(String[] args) throws IOException {
        writeJackson();
        readJackson();
    }

    public static void writeJackson() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            Company company = new Company("Amazon", "Jeff Bezos", "E-Commerce", 1608000);

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/java/com/solvd/it_company/parsers/jacksonTask/company.json"), company);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void readJackson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        Company company = objectMapper.readValue(new File("src/main/java/com/solvd/it_company/parsers/jacksonTask/company.json"), Company.class);

        LOGGER.info(company);
    }
}