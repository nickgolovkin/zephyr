package com.golovkin.integration;

public class Assertions {
    public static <T> void assertEquals(String expected, T actual) {
        org.junit.jupiter.api.Assertions.assertEquals(TestObjectMapper.readToJsonNode(expected), TestObjectMapper.readToJsonNode(actual));
    }
}
