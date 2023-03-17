package com.golovkin.httpclient;

import lombok.Data;

import java.util.List;

@Data
public class Response {
    private int statusCode;
    private List<String> headers;
    private String body;
}
