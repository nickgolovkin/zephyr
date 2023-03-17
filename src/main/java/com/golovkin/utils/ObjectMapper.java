package com.golovkin.utils;

import com.fasterxml.jackson.databind.JsonNode;

public class ObjectMapper {
    private static com.fasterxml.jackson.databind.ObjectMapper objectMapper;

    static {
        objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
    }

    public static <T> T read(String json, Class<T> clazz) {
        try {
            // TODO failOnUnknownProperties disable
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}