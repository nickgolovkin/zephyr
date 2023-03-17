package com.golovkin.integration;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Resources {
    public static String read(String path) {
        try (InputStream file = TestObjectMapper.class.getResourceAsStream(path)) {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();

            int nRead;
            byte[] data = new byte[16384];
            while ((nRead = file.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }

            String string = new String(buffer.toByteArray(), StandardCharsets.UTF_8);
            buffer.close();

            return string;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
