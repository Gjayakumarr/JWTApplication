package com.JWTApplication.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@Entity(name = "role_master")
public class RoleMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roleId;

    private String roleName;
    private String roleDescription;
    @JsonProperty("isDeleted")
    private boolean isDeleted;
    private String roleCode;

    @JsonProperty("isManager")
    private boolean isManager;

    @JsonProperty("isAdmin")
    private boolean isAdmin;

    @JsonProperty("isDefault")
    private boolean isDefault;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdOn;

    private Timestamp deletedOn;
}
