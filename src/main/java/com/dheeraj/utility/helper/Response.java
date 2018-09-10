package com.dheeraj.utility.helper;


import com.dheeraj.utility.helper.models.EkartResponseCode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;
import play.mvc.Result;

import static play.mvc.Results.status;

/**
 * Created by IntelliJ IDEA.
 * User: Dheeraj Reddy
 * Date: 29/07/18
 */

public class Response {

    public static Result okAsJSON(String msg) {
        return resultAsJSON("200", msg);
    }

    public static Result createdAsJSON(String msg) {
        return resultAsJSON("201", msg);
    }

    public static Result badAsJSON(String msg) {
        return resultAsJSON("400", msg);
    }

    public static Result unauthenticatedAsJSON(String msg) {
        return resultAsJSON("401", msg);
    }

    public static Result forbiddenAsJSON(String msg) {
        return resultAsJSON("403", msg);
    }

    public static Result notFoundAsJSON(String msg) {
        return resultAsJSON("404", msg);
    }

    public static Result timeoutAsJSON(String msg) {
        return resultAsJSON("408", msg);
    }

    public static Result errorAsJSON(String msg) {
        return resultAsJSON("500", msg);
    }


    protected static Result resultAsJSON(String responseCode, String message) {
        ObjectNode result = Json.newObject();
        result.put("status", responseCode);
        result.put("message", message);
        return status(Integer.parseInt(responseCode), result);
    }

    public static Result getEkartResponse(EkartResponseCode ekartResponseCode) {
        ObjectNode result = Json.newObject();
        result.put("style", ekartResponseCode.getStyle() == null ? "inline" : ekartResponseCode.getStyle());
//        result.put("errorCode", ekartResponseCode.getErrorCode() == 0 ? 1 : ekartResponseCode.getErrorCode());
        if (ekartResponseCode.title != null) {
            result.put("title", ekartResponseCode.title);
        }
        if (ekartResponseCode.subTitle != null) {
            result.put("subTitle", ekartResponseCode.subTitle);
        }
        if (ekartResponseCode.description != null) {
            result.put("description", ekartResponseCode.description);
        }
        return status(ekartResponseCode.getStatusCode() > 199 ? ekartResponseCode.getStatusCode() : 400, result);
    }

}

