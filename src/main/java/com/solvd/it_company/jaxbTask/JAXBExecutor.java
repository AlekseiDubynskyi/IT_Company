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
        Client client1 = new Client();
        client1.setFullName("John Smith");
        client1.setPhoneNumber("+49041041794");
        client1.setEmail("john.smith@gmail.com");
        client1.setLocation("London");

        Client client2 = new Client();
        client2.setFullName("Oliver Adams");
        client2.setPhoneNumber("+4197017907418");
        client2.setEmail("oliver.adams@gmail.com");
        client2.setLocation("New York");

        List<Client> clients = new ArrayList<Client>();
        clients.add(client1);
        clients.add(client2);

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