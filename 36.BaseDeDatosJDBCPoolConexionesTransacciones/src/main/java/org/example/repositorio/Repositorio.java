package org.example.repositorio;

import java.sql.SQLException;
import java.util.List;

public interface Repositorio<T> {
    List<T> listar() throws SQLException;
    T porId(Long id) throws SQLException;
    T guardar(T t) throws SQLException; // Funciona como modificar
    void eliminar(Long id) throws SQLException;
}
