package com.dheeraj.utility.helper.models;

/**
 * @author Dheeraj
 */
public class EkartResponseCode {
    private String style;

    // Status Code to use for Response
    private int statusCode;

    private int errorCode;

    public String title;
    public String subTitle;
    public String description;

    public EkartResponseCode(String style, int statusCode, int errorCode) {
        this.style = style;
        this.statusCode = statusCode;
        this.errorCode = errorCode;
    }

    public String getStyle() {
        return style;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
