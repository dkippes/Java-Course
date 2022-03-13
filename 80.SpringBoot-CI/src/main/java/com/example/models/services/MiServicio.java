package com.example.models.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component("miServicioSimple") // Queda registrado como un bean en Spring, es un singleton - Se puede poner "Service" que es lo mismo, solo da semantica
//@Primary // Como servicio principal
public class MiServicio implements Servicio {

    @Override
    public String operacion() {
        return "ejecutando algun proceso importante... logica de negocio, acceso a los datos";
    }

}
