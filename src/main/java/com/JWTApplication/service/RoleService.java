package com.JWTApplication.service;

import com.JWTApplication.Model.RoleMaster;
import com.JWTApplication.response.GenericResponse;

public interface RoleService {
    public GenericResponse addRole(RoleMaster roleMaster);

    public GenericResponse updateRole(RoleMaster roleMaster);

    public GenericResponse deleteRole(int roleId);

    public GenericResponse getAllRoles();
}
