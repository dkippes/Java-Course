package com.example.models.services;

import org.springframework.stereotype.Component;

//@Component("miServicioComplejo") // Queda registrado como un bean en Spring, es un singleton - Se puede poner "Service" que es lo mismo, solo da semantica
public class MiServicioComplejo implements Servicio {

    @Override
    public String operacion() {
        return "ejecutando algun proceso importante complicado ..";
    }

}
