package com.example.springapirest.models.services;

import com.example.springapirest.models.entity.Cliente;

import java.util.List;

public interface ClienteService {
    public List<Cliente> findAll();
    public Cliente findById(Long id);
    public Cliente save(Cliente cliente);
    public void delete(Long id);
}
