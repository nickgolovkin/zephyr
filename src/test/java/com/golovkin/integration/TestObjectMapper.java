package com.golovkin.integration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class TestObjectMapper {
    private static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
    }

    public static <T> T read(String path, Class<T> clazz) {
        try {
            String file = Resources.read(path);
            return objectMapper.readValue(file, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JsonNode readToJsonNode(String path) {
        return read(path, JsonNode.class);
    }

    public static JsonNode readToJsonNode(Object object) {
        return objectMapper.valueToTree(object);
    }
}
