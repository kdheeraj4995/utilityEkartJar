package com.dheeraj.utility.helper;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Created by IntelliJ IDEA.
 * User: Dheeraj Reddy
 * Date: 29/07/18
 */

public class JsonHelper {

    public static boolean requestHasRequiredParameters(JsonNode json, String... requiredParams) {
        if (json == null) {
            throw new IllegalArgumentException("Json request body cannot be null");
        }
        for (String param : requiredParams) {
            if (json.has(param)) {
                if (json.get(param) == null || json.get(param).asText().isEmpty()) {
                    throw new IllegalArgumentException("Invalid field value in JSON : " + param);
                }
            } else {
                throw new IllegalArgumentException("JSON request body does not have the mandatory field : " + param);
            }
        }
        return true;
    }

    public static boolean IgnoreParams(JsonNode node, String... ignoreList) {
        if (node == null) {
            throw new IllegalArgumentException("Json request body cannot be null");
        }
        for (String param : ignoreList) {
            if (node.has(param)) {
                throw new IllegalArgumentException("Invalid field present in JSON Request body name : " + param);
            }
        }
        return true;
    }

    public static String getJsonDataAsText(JsonNode json, String param) {
        return json.get(param) != null
                ? json.get(param).textValue() : null;
    }

    public static Integer getJsonDataAsInteger(JsonNode json, String param) {
        return json.get(param) != null
                ? json.get(param).asInt() : 0;
    }

    public static Long getJsonDataAsLong(JsonNode json, String param) {
        return json.get(param) != null
                ? json.get(param).asLong() : 0l;
    }

    public static Double getJsonDataAsDouble(JsonNode json, String param) {
        return json.get(param) != null
                ? json.get(param).asDouble() : 0d;
    }

    public static Boolean getJsonDataAsBoolean(JsonNode json, String param) {
        return json.get(param) != null ?
                json.get(param).asBoolean() : false;
    }
}
