package hibernateExample.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;

    @Column(name = "forma_pago")
    private String formaPago;

    @Embedded
    private Auditoria audit = new Auditoria();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    // @JoinColumn(name = "cliente_id") -> Para el FK
    @JoinTable(name = "clientes_direcciones",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "direccion_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"direccion_id"}))
    private Set<Direccion> direcciones;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "cliente") // Hay que especificar con mappedBy quien es el attributo
    private Set<Factura> facturas;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "cliente")
    private ClienteDetalle detalle;

    public Cliente() {
        facturas = new HashSet<>();
        direcciones = new HashSet<>();
    }

    public Cliente(String nombre, String apellido) {
        this();
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Cliente(Long id, String nombre, String apellido, String formaPago) {
        this();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.formaPago = formaPago;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public Set<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(Set<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public Auditoria getAudit() {
        return audit;
    }

    public void setAudit(Auditoria audit) {
        this.audit = audit;
    }

    public Set<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(Set<Factura> facturas) {
        this.facturas = facturas;
    }

    public ClienteDetalle getDetalle() {
        return detalle;
    }

    public void setDetalle(ClienteDetalle detalle) {
        this.detalle = detalle;
    }

    public Cliente addFactura(Factura factura) {
        this.facturas.add(factura);
        factura.setCliente(this);
        return this;
    }

    public void removeFactura(Factura factura) {
        this.facturas.remove(factura);
        factura.setCliente(null);
    }

    public void addDetalle(ClienteDetalle detalle) {
        this.detalle = detalle;
        detalle.setCliente(this);
    }

    public void removeDetalle() {
        detalle.setCliente(null);
        detalle = null;
    }

    @Override
    public String toString() {
        LocalDateTime creado = this.audit != null ? audit.getCreadoEn() : null;
        LocalDateTime editado = this.audit != null ? audit.getEditadoEn() : null;
        return "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", formaPago='" + formaPago + '\'' +
                ", creadoEn='" + creado + '\'' +
                ", editadoEn='" + editado + '\'' +
                ", direcciones='" + direcciones + '\'' +
                ", facturas='" + facturas + '\'' +
                ", deatlle='" + detalle + '\'' +
                '}';
    }
}
