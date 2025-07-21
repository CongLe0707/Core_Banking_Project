package com.example.Project_Core_Banking.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@UtilityClass
@Slf4j
public class Utils {
    private static final ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());

    public static String object2Json(Object input) {
        if (input == null) {
            return null;
        }

        try {
            return mapper.writeValueAsString(input);
        } catch (Exception ex) {
            log.error("Error while convert object to string", ex);
            return null;
        }
    }
}
