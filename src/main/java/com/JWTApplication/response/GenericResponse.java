package com.JWTApplication.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResponse {
    private int statusCode;
    private String message;
    private boolean success;
    private ArrayList<Object> details;
    private Object data;
}
