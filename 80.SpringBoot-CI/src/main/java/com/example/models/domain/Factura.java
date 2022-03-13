package com.example.models.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.Serializable;
import java.util.List;

@Component
// TODO: @RequestScope // Esta factura ahora duraria lo de cada request
@SessionScope //-> Para carro de compra, que se mantega la session o timeout -> Se tiene que implementar Serializable
// Serializable convierte el objeto en una secuencia de bytes para que se pueda guardar
// La session son varios request
// TODO: @ApplicationScope -> Es un singleton que se guarda en el contexto servlet
public class Factura implements Serializable {
    private static final long serialVersionUID = 687687686899688L;

    @Value("${factura.descripcion}")
    private String descripcion;
    @Autowired
    private Cliente cliente;
    @Autowired
    @Qualifier("itemsFacturaOficina")
    private List<ItemFactura> items;

    @PostConstruct // Se ejecuta despues de crear el objeto e inyectada la dependencia
    public void inicializar() {
        cliente.setNombre(cliente.getNombre().concat(" ").concat("Jose"));
        descripcion = descripcion.concat(" del cliente: ").concat(cliente.getNombre());
    }

    @PreDestroy // Cuando se haga un undeploy de la app, va aparecer en consola
    public void destruir() {
        System.out.println("Factura destruida ".concat(descripcion));
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemFactura> getItems() {
        return items;
    }

    public void setItems(List<ItemFactura> items) {
        this.items = items;
    }

}
