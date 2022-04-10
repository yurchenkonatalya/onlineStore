package by.bsuir.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

@Slf4j
public class JsonParser {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T>  T simpleParser(String json, Class<T> clazz){
        try {
            return objectMapper.readValue(json, clazz);
        }catch (JsonProcessingException e){
            log.error("FAILED TO PARSE STRING {}", json);
        }
        return null;
    }

    public static <T>  T simpleParser(File jsonFile, Class<T> clazz){
        try {
            return objectMapper.readValue(jsonFile, clazz);
        }catch (IOException e){
            log.error("FAILED TO PARSE FILE {}", jsonFile.getPath());
        }
        return null;
    }

}
