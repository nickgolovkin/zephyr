package com.golovkin.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;

public class ObjectMapper {
    private static com.fasterxml.jackson.databind.ObjectMapper objectMapper;

    static {
        objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public static <T> T read(String json, Class<T> clazz) {
        try {
            // TODO failOnUnknownProperties disable
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T read(String json, TypeReference<T> typeReference) {
        try {
            // TODO failOnUnknownProperties disable
            return objectMapper.readValue(json, typeReference);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String toJson(Object object) {
        try {
            // TODO failOnUnknownProperties disable
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}