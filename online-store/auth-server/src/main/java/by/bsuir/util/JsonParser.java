package by.bsuir.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonParser {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T>  T simpleParser(String json, Class<T> clazz){
        try {
            return objectMapper.readValue(json, clazz);
        }catch (JsonProcessingException e){
            log.error("failed to parse");
        }
        return null;
    }

}
