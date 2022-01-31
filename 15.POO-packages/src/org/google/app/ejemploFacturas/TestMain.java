package org.google.app.ejemploFacturas;

import org.google.app.ejemploFacturas.domain.Cliente;
import org.google.app.ejemploFacturas.domain.Factura;
import org.google.app.ejemploFacturas.domain.ItemFactura;
import org.google.app.ejemploFacturas.domain.Producto;

import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNif("5555-5");
        cliente.setNombre("Diego");

        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese la descripcion de la factura");
        String desc = s.nextLine();
        Factura factura = new Factura(desc, cliente);

        Producto producto;

        System.out.println();

        for (int i=0; i < 5; i++) {
            producto = new Producto();
            System.out.println("Ingrese producto n° " + producto.getCodigo() + ": ");
            producto.setNombre(s.nextLine());

            System.out.println("Ingrese el precio: ");
            producto.setPrecio(s.nextFloat());

            System.out.println("Ingrese cantidad: ");
            factura.addItemFactura(new ItemFactura(s.nextInt(), producto));

            System.out.println();
        }

        System.out.println(factura);
    }
}
