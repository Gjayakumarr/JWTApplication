package com.JWTApplication.security.model;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class UserDetailsImpl extends User {

    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String password;
    private String username;
    private long contactNumber;
    private int managerId;
    private int departmentId;
    private int roleId;
    private boolean isDeleted;

    public UserDetailsImpl(int id, String firstName, String middleName, String lastName, String username,
                           String password, long contactNumber, int managerId, int departmentId, int roleId,
                           boolean isDeleted, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.password = password;
        this.username = username;
        this.contactNumber = contactNumber;
        this.managerId = managerId;
        this.departmentId = departmentId;
        this.roleId = roleId;
        this.isDeleted = isDeleted;
    }

    public String getFullName() {
        return firstName + " " + (middleName != null ? middleName + " " : "") + lastName;
    }

    public boolean isDeleted() {
        return isDeleted;
    }
}
