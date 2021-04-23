package jsonResearch;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

public class readJsonFile {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream("insertAdPty.json");
            TypeReference<List<person>> typeReference = new TypeReference<List<person>>() {};
            List <person> persons = mapper.readValue(inputStream, typeReference);
            for (person p : persons) {

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (JsonMappingException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

