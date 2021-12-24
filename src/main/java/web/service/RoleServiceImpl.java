package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.Repository.RoleRepository;
import web.models.Role;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{

    private RoleRepository roleDao;

    @Autowired
    public RoleServiceImpl(RoleRepository roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    @Transactional
    public Role addRole(Role role) {
        return roleDao.save(role);
    }

    @Override
    public Role getRoleByRoleName(String role) {
        return roleDao.getRoleByRoleName(role);
    }

    @Override
    public HashSet<Role> getSetOfRoles(String[] roleNames) {
        Set<Role> roleSet = new HashSet<>();
        for (String role : roleNames) {
            roleSet.add(getRoleByRoleName(role));
        }
        return (HashSet) roleSet;
    }

    @Override
    @Transactional (readOnly = true)
    public List<Role> getAllRoles() {
        return roleDao.findAll();
    }
}
