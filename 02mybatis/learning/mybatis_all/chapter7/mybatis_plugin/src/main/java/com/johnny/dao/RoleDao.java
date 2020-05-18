package com.johnny.dao;

import com.johnny.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {
    int insertRole(@Param("role") Role role);

    List<Role> queryRolesByName(@Param("roleName") String roleName);

}