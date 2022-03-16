package com.example.springbootformulario.services;

import com.example.springbootformulario.models.domain.Pais;

import java.util.List;

public interface PaisService {
    public List<Pais> listar();
    public Pais obtenerPorId(Integer id);
}
