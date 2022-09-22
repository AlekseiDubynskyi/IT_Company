package com.solvd.it_company.parsers.jsonTask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.json.*;
import javax.json.stream.JsonGenerator;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class JSONExecutor {
    private static final Logger LOGGER = LogManager.getLogger(JSONExecutor.class);

    public static void main(String[] args) throws IOException {
        WriteJSON();
        ReadJSON();
    }

    public static void WriteJSON() throws FileNotFoundException {
        Worker worker = workerGeneration();

        JsonObjectBuilder workerBuilder = Json.createObjectBuilder();
        JsonArrayBuilder languagesBuilder = Json.createArrayBuilder();

        for (String tag : worker.getLanguages()) {
            languagesBuilder.add(tag);
        }

        workerBuilder.add("id", worker.getId())
                .add("Full name", worker.getFullName())
                .add("Position", worker.getPosition())
                .add("Country", worker.getCountry())
                .add("Languages", languagesBuilder);

        JsonObject postJsonObject = workerBuilder.build();

        OutputStream outputStream = new FileOutputStream("src/main/java/com/solvd/it_company/parsers/jsonTask/worker.json");
        JsonWriter jsonWriter = Json.createWriter(outputStream);

        Map<String, Boolean> config = new HashMap<String, Boolean>();
        config.put(JsonGenerator.PRETTY_PRINTING, true);

        JsonWriterFactory factory = Json.createWriterFactory(config);
        jsonWriter = factory.createWriter(outputStream);

        jsonWriter.writeObject(postJsonObject);
        jsonWriter.close();
    }

    private static Worker workerGeneration() {
        Worker worker = new Worker();
        worker.setId("OD-814");
        worker.setFullName("Oliver Davidson");
        worker.setPosition("Senior Automation QA");
        worker.setCountry("United Kingdom");
        String[] languages = {"Java", "Python", "JavaScript", "C++"};
        worker.setLanguages(languages);

        return worker;
    }

    public static void ReadJSON() throws IOException {
        InputStream inputStream = new FileInputStream("src/main/java/com/solvd/it_company/parsers/jsonTask/worker.json");

        JsonReader jsonReader = Json.createReader(inputStream);
        JsonObject jsonObject = jsonReader.readObject();

        jsonReader.close();
        inputStream.close();

        Worker worker = new Worker();
        worker.setId(jsonObject.getString("id"));
        worker.setFullName(jsonObject.getString("Full name"));
        worker.setPosition(jsonObject.getString("Position"));
        worker.setCountry(jsonObject.getString("Country"));
        JsonArray jsonArray = jsonObject.getJsonArray("Languages");
        String[] languages = new String[jsonArray.size()];
        int index = 0;
        for (JsonValue value : jsonArray) {
            languages[index++] = value.toString();
        }
        worker.setLanguages(languages);

        LOGGER.info(worker.toString());
    }
}
