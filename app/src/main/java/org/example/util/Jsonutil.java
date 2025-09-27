package org.example.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Jsonutil {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static <T> T read(File file, TypeReference<T> type, T defaultValue) {
        try {
            if (!file.exists()) return defaultValue;
            return MAPPER.readValue(file, type);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON: " + file.getPath(), e);
        }
    }

    public static void write(File file, Object value) {
        try {
            file.getParentFile().mkdirs();
            MAPPER.writerWithDefaultPrettyPrinter().writeValue(file, value);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write JSON: " + file.getPath(), e);
        }
    }
}
