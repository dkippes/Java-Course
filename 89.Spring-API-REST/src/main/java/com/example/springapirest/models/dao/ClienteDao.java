package com.example.springapirest.models.dao;

import com.example.springapirest.models.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente, Long> {
}
