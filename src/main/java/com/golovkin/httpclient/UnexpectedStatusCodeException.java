package com.golovkin.httpclient;

public class UnexpectedStatusCodeException extends RuntimeException {
    private final Response response;

    public UnexpectedStatusCodeException(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }
}
