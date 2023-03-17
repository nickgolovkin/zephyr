package com.golovkin.httpclient;

public class HttpClientUtils {
    public static String getJson(Response response) {
        if (response.getStatusCode() != 200) {
            throw new UnexpectedStatusCodeException(response);
        }

        return response.getBody();
    }

    public static void checkSuccessful(Response response) {
        if (response.getStatusCode() != 200) {
            throw new UnexpectedStatusCodeException(response);
        }
    }
}
