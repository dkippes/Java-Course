package com.example.configuration;

import com.example.models.domain.ItemFactura;
import com.example.models.domain.Producto;
import com.example.models.services.MiServicio;
import com.example.models.services.MiServicioComplejo;
import com.example.models.services.Servicio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Arrays;
import java.util.List;

// Aca podemos registrar todos los components si no se usa la @Component
// Tambien se puede remplazar clases que use Spring, y modificarlas
@Configuration
public class AppConfig {

    @Bean("miServicioSimple")
    @Primary
    public Servicio registrarMiServicio() {
        return new MiServicio();
    }

    @Bean("miServicioComplejo")
    public Servicio registrarMiServicioComplejo() {
        return new MiServicioComplejo();
    }

    @Bean("itemsFactura")
    @Primary
    public List<ItemFactura> registrarItems() {
        Producto producto1 = new Producto("Camara Sony", 100);
        Producto producto2 = new Producto("Bicicleta Bianchi aro 26", 200);

        ItemFactura linea1 = new ItemFactura(producto1, 2);
        ItemFactura linea2 = new ItemFactura(producto2, 4);
        return Arrays.asList(linea1, linea2);
    }

    @Bean("itemsFacturaOficina")
    public List<ItemFactura> registrarItemsOficina() {
        Producto producto1 = new Producto("Monitor LG LCD 24", 250);
        Producto producto2 = new Producto("Notebook Asus", 500);
        Producto producto3 = new Producto("Impresora HP Multifuncional", 80);
        Producto producto4 = new Producto("Escritorio Oficina", 300);

        ItemFactura linea1 = new ItemFactura(producto1, 2);
        ItemFactura linea2 = new ItemFactura(producto2, 1);
        ItemFactura linea3 = new ItemFactura(producto3, 1);
        ItemFactura linea4 = new ItemFactura(producto4, 1);
        return Arrays.asList(linea1, linea2, linea3, linea4);
    }
}
