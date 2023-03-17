package com.golovkin.httpclient;

import lombok.Data;

import java.util.List;

@Data
public class Request {
    private String url;
    private HttpMethod method;
    private List<String> headers;
    private String body;
}
