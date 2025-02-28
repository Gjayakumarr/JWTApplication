package com.JWTApplication.service;

import com.JWTApplication.Model.UserDetailsV1;
import com.JWTApplication.response.UserResponse;

public interface UserService {

    public UserResponse addUser(UserDetailsV1 userDetails);

    public UserResponse updateUser(UserDetailsV1 userDetails);

    public UserResponse deActivate(int userId);

    public UserResponse activate(int userId);

    public UserResponse getUserDetails();

    public UserResponse updatePassword(int userId, String oldPassword, String newPassword);
}
