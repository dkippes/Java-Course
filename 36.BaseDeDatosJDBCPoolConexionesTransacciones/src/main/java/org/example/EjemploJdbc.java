package org.example;

import org.example.modelo.Categoria;
import org.example.modelo.Producto;
import org.example.repositorio.CategoriaRepositorioImpl;
import org.example.repositorio.ProductoRepositorioImpl;
import org.example.repositorio.Repositorio;
import org.example.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = ConexionBaseDatos.getConnection()) {
            if (conn.getAutoCommit()) {
                conn.setAutoCommit(false);
            }
            try {
                Repositorio<Categoria> repositorioCategoria = new CategoriaRepositorioImpl(conn);
                System.out.println("========== Insertar nueva categoria ==========");
                Categoria categoria = new Categoria();
                categoria.setNombre("Electrohogar");
                Categoria nuevaCategoria = repositorioCategoria.guardar(categoria);
                System.out.println("Categoria guardado con exito: " + nuevaCategoria.getId());

                Repositorio<Producto> repositorio = new ProductoRepositorioImpl(conn);
                System.out.println("============== listar ==========");
                repositorio.listar().forEach(System.out::println);

                System.out.println("============== obtener por id ==========");
                System.out.println(repositorio.porId(1L));

                System.out.println("============== insertar nuevo producto ==========");
                Producto producto = new Producto();
                producto.setNombre("Refrigerador Samsung");
                producto.setPrecio(90000);
                producto.setFechaRegistro(new Date());
                producto.setSku("abcd");

                producto.setCategoria(nuevaCategoria);
                repositorio.guardar(producto);
                System.out.println("Producto guardado con exito: " + producto.getId());
                repositorio.listar().forEach(System.out::println);

            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
            }

        }


    }
}
