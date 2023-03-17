package com.golovkin.integration;

import com.fasterxml.jackson.databind.JsonNode;

public class Assertions {
    public static <T> void assertEquals(String expected, T actual) {
        JsonNode expectedAsJsonNode = TestObjectMapper.readToJsonNode(expected, actual.getClass());
        JsonNode actualAsJsonNode = TestObjectMapper.readToJsonNode(actual);
        org.junit.jupiter.api.Assertions.assertEquals(expectedAsJsonNode, actualAsJsonNode);
    }
}
