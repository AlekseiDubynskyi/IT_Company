package com.solvd.it_company.jaxbTask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBExecutor {
    private static final Logger LOGGER = LogManager.getLogger(JAXBExecutor.class);

    public static void main(String[] args) {
        List<Client> clients = new ArrayList<Client>();

        clients.add(new Client("John Smith", "+49041041794", "john.smith@gmail.com", "London"));
        clients.add(new Client("Oliver Adamsh", "+507558987358", "oliver.adams@gmail.com", "New York"));
        clients.add(new Client("Shelby Riley", "+758535848022", "riley.s@gmail.com", "Sheltered town"));
        clients.add(new Client("Jonnie Frank", "+55124141423", "jonnie@gmail.com", "Toronto"));

        try {
            marshal(clients, new File("src/main/java/com/solvd/it_company/jaxbTask/clients.xml"));
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }

        try {
            clients = unmarshal(new File("src/main/java/com/solvd/it_company/jaxbTask/clients.xml"));
            clients.forEach(LOGGER::info);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void marshal(List<Client> clients, File selectedFile) throws IOException, JAXBException {
        JAXBContext context;
        BufferedWriter writer = null;
        writer = new BufferedWriter(new FileWriter(selectedFile));
        context = JAXBContext.newInstance(Clients.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(new Clients(clients), writer);
        writer.close();
    }

    public static List<Client> unmarshal(File importFile) throws JAXBException {
        Clients clients = new Clients();
        JAXBContext context = JAXBContext.newInstance(Clients.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        clients = (Clients) unmarshaller.unmarshal(importFile);
        return clients.getClients();
    }
}