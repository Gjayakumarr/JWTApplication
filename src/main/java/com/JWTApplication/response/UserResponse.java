package com.JWTApplication.response;

import com.JWTApplication.Model.UserDetailsV1;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {
    private int statusCode;
    private String message;
    private boolean success;
    private ArrayList<UserDetailsV1> userDetails;
    private List<Map<String, Object>> listOfUsers;
    private Object data;
}
