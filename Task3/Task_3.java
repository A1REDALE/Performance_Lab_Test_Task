import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task_3 {
    public static void main(String[] args) throws IOException {

        Gson gson = new Gson();
        TestsContainer testJson = gson.fromJson(new FileReader((args[0])), TestsContainer.class);
        ValuesContainer valuesJson = gson.fromJson(new FileReader((args[1])), ValuesContainer.class);
        Map<Integer,String> values = new HashMap<>();
        for (JsonValue value : valuesJson.values) {
            values.put(value.id, value.value);
        }
        for(JsonTest test: testJson.tests){
            fillReport(test,values);
        }
        String report = gson.toJson(testJson);
        FileWriter writer = new FileWriter("report.json");
        gson.toJson(report,writer);
        writer.close();
    }
    private static void fillReport(JsonTest test, Map<Integer, String> values) {
        if(values.containsKey(test.id)){
            test.value = values.get(test.id);
        }
        if (test.values != null){
            for (JsonTest subTest : test.values) {
                fillReport(subTest, values);
            }
        }
    }

    public static class TestsContainer {
        List<JsonTest> tests;
    }

    public static class JsonTest {
        int id;
        String title;
        String value;
        List<JsonTest> values;
    }

    public static class ValuesContainer{
        List<JsonValue> values;
    }

    public static class JsonValue{
        int id;
        String value;
    }
}


