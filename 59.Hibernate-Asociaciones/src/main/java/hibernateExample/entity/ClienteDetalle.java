package hibernateExample.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes_detalles")
public class ClienteDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean prime;

    @Column(name = "puntos_acumulados")
    private Long punosAcumulados;

    @OneToOne
    @JoinColumn(name = "cliente_detalle_id")
    private Cliente cliente;

    public ClienteDetalle() {
    }

    public ClienteDetalle(boolean prime, Long punosAcumulados) {
        this.prime = prime;
        this.punosAcumulados = punosAcumulados;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPrime() {
        return prime;
    }

    public void setPrime(boolean prime) {
        this.prime = prime;
    }

    public Long getPunosAcumulados() {
        return punosAcumulados;
    }

    public void setPunosAcumulados(Long punosAcumulados) {
        this.punosAcumulados = punosAcumulados;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "ClienteDetalle{" +
                "id=" + id +
                ", prime=" + prime +
                ", punosAcumulados=" + punosAcumulados +
                '}';
    }
}
