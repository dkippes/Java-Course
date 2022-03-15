package com.example.springbootformulario.services;

import com.example.springbootformulario.models.domain.Pais;
import com.example.springbootformulario.models.domain.Role;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private List<Role> roles;

    public RoleServiceImpl() {
        this.roles = new ArrayList<>();
        roles.add(new Role(1, "Administrador", "ROLE_ADMIN"));
        roles.add(new Role(2, "Usuario", "ROLE_USER"));
        roles.add(new Role(3, "Moderador", "ROLE_MODERADOR"));
    }

    @Override
    public List<Role> listar() {
        return roles;
    }

    @Override
    public Role obtenerPorId(Integer id) {
        Role resultado = null;
        for (Role role : this.roles) {
            if (id == role.getId()) {
                resultado = role;
                break;
            }
        }
        return resultado;
    }
}
