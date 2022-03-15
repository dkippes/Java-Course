package com.example.springbootformulario.services;

import com.example.springbootformulario.models.domain.Role;

import java.util.List;

public interface RoleService {
    public List<Role> listar();
    public Role obtenerPorId(Integer id);
}
