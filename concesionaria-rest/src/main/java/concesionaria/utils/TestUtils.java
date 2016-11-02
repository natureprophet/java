/**
 * TodoList java backend.
 * Part of the TodoList project.
 * Copyright (c) 2016 GlobalLogic
 * All rights reserved.
 * Distribution under license.
 */
package concesionaria.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Test utilities.
 */
public class TestUtils {

    /**
     * Method that convert an object in a Json String.
     * @param obj Object to transform.
     * @return Json in string format.
     */
    public static String toJson(final Object obj) throws JsonProcessingException {
        final ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }
}
