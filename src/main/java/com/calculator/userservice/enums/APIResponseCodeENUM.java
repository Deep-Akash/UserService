package com.calculator.userservice.enums;

/**
 * Created by akashdeepnew on 20/12/18.
 */
public enum APIResponseCodeENUM {
    SUCCESS("200","SUCCESS"),
    NO_USER_FOUND("400","NO USER FOUND"),
    GENERAL_FAILURE("500","SOME EXCEPTION");

    private final String code;
    private final String message;

    APIResponseCodeENUM(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "APIResponseCodeENUM{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
