package org.example;

import org.example.modelo.Categoria;
import org.example.modelo.Producto;
import org.example.repositorio.ProductoRepositorioImpl;
import org.example.repositorio.Repositorio;
import org.example.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) {



        try (
                Connection conn = ConexionBaseDatos.getInstance();
        ) {
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("============== listar ==========");
            repositorio.listar().forEach(System.out::println);

            System.out.println("============== obtener por id ==========");
            System.out.println(repositorio.porId(2L));

            System.out.println("============== insertar nuevo producto ==========");
            Producto producto = new Producto();
            producto.setNombre("Teclado Mecanico");
            producto.setPrecio(500);
            producto.setFechaRegistro(new Date());
            Categoria categoria = new Categoria();
            categoria.setId(3L);
            producto.setCategoria(categoria);
            repositorio.guardar(producto);
            System.out.println("Producto guardado con exito!");
            repositorio.listar().forEach(System.out::println);

            System.out.println("============== update producto ==========");
            producto.setId(2L);
            producto.setNombre("Teclado Rosa de ojalata");
            producto.setCategoria(categoria);
            repositorio.guardar(producto);
            repositorio.listar().forEach(System.out::println);

            System.out.println("============== eliminar producto ==========");
            // repositorio.eliminar(1L);
            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
