package com.JWTApplication.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@ToString(exclude = "password")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class UserDetailsV1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String password;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    private long contactNumber;
    private int managerId;
    private int departmentId;
    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdOn;
    private int roleId;
    @CreationTimestamp
    private Timestamp updatedOn;
    private Timestamp deletedOn;
    @JsonProperty("isDeleted")
    private boolean isDeleted;

}
