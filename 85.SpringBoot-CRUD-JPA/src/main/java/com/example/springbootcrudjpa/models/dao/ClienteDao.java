package com.example.springbootcrudjpa.models.dao;

import com.example.springbootcrudjpa.models.entity.Cliente;

import java.util.List;

public interface ClienteDao {
    public List<Cliente> findAll();
    public void save(Cliente cliente);
    public Cliente findOne(Long id);
    public void delete(Long id);
}
