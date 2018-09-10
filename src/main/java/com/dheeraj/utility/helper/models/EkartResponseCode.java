package com.dheeraj.utility.helper.models;

/**
 * @author Dheeraj
 */
public class EkartResponseCode {
    public String style;

    // Status Code to use for Response
    public int statusCode;
    public String title;
    public String subTitle;
    public String description;

    public EkartResponseCode(String style, int statusCode, String title, String subTitle, String description) {
        this.style = style;
        this.statusCode = statusCode;
        this.title = title;
        this.subTitle = subTitle;
        this.description = description;
    }
}
