package org.example;

import org.example.modelo.Categoria;
import org.example.modelo.Producto;
import org.example.repositorio.ProductoRepositorioImpl;
import org.example.repositorio.Repositorio;
import org.example.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) throws SQLException {
        Connection conn = ConexionBaseDatos.getInstance();

        Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
        if (conn.getAutoCommit()) {
            conn.setAutoCommit(false);
        }

        try {
            System.out.println("============== insertar producto con sku duplicado ==========");
            Producto producto = new Producto();
            producto.setNombre("Teclado Mecanico ASC");
            producto.setPrecio(1500);
            producto.setFechaRegistro(new Date());
            Categoria categoria = new Categoria();
            categoria.setId(3L);
            producto.setCategoria(categoria);
            producto.setSku("abcd");
            repositorio.guardar(producto);
            System.out.println("Producto guardado con exito!");

            repositorio.listar().forEach(System.out::println);
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            e.printStackTrace();
        }


    }
}
