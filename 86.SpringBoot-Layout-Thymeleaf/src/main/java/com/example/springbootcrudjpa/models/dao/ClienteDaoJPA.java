package com.example.springbootcrudjpa.models.dao;

import com.example.springbootcrudjpa.models.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDaoJPA extends CrudRepository<Cliente, Long> {

}
