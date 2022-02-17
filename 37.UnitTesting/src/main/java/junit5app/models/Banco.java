package junit5app.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Cuenta> cuentas;
    private String nombre;

    public Banco() {
        this.cuentas = new ArrayList<>();
    }

    public Banco(String nombre) {
        this();
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public void addCuenta(Cuenta cuenta) {
        cuenta.setBanco(this);
        cuentas.add(cuenta);
    }

    public void transferir(Cuenta origen, Cuenta destino, BigDecimal monto) {
        origen.debito(monto);
        destino.credito(monto);
    }
}
