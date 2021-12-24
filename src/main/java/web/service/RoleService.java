package web.service;

import web.models.Role;

import java.util.HashSet;
import java.util.List;

public interface RoleService {
    Role addRole(Role role);
    Role getRoleByRoleName(String role);
    HashSet<Role> getSetOfRoles(String[] roleNames);
    List<Role> getAllRoles();
}
