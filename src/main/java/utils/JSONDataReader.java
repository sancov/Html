package utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class JSONDataReader {

    static String filePath = "configFiles/params.json";

    public static JsonArray readJsonData(String filePath) throws IOException {
        try (FileReader reader = new FileReader(filePath)) {
            // Parse JSON file and return the JSON array
            return JsonParser.parseReader(reader).getAsJsonArray();
        }
    }

    public static List<TestCase> getTestCasesFromJsonFile() throws IOException {
        JsonArray jsonArray = readJsonData(filePath);
        return TableHelper.extractTestCases(jsonArray);
    }
}

