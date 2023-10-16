package pe.edu.upc.aaw.behappycommunity.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "DocumentoPago")
public class DocumentoPago {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDocumentoPago;
    @Column(name = "idReceptor",nullable = false)
    private int idReceptor;
    @Column(name = "fechaEmision",nullable = false)
    private LocalDate fechaEmision;
    @Column(name = "fechaVencimeinto",nullable = false)
    private LocalDate fechaVencimiento;
    @Column(name = "moneda",length = 100,nullable = false)
    private String moneda;
    //total int->double
    @Column(name = "total",nullable = false)
    private double total;
    @Column(name = "estado",length = 150,nullable = false)
    private String estado;
    //Foreign keys
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "idTipoDocPago")
    private TipoDocPago tipoDocPago;

    public DocumentoPago() {
    }

    public DocumentoPago(int idDocumentoPago, int idReceptor, LocalDate fechaEmision, LocalDate fechaVencimiento, String moneda, double total, String estado, Usuario usuario, TipoDocPago tipoDocPago) {
        this.idDocumentoPago = idDocumentoPago;
        this.idReceptor = idReceptor;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.moneda = moneda;
        this.total = total;
        this.estado = estado;
        this.usuario = usuario;
        this.tipoDocPago = tipoDocPago;
    }

    public int getIdReceptor() {
        return idReceptor;
    }

    public void setIdReceptor(int idReceptor) {
        this.idReceptor = idReceptor;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getIdDocumentoPago() {
        return idDocumentoPago;
    }

    public void setIdDocumentoPago(int idDocumentoPago) {
        this.idDocumentoPago = idDocumentoPago;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoDocPago getTipoDocPago() {
        return tipoDocPago;
    }

    public void setTipoDocPago(TipoDocPago tipodocpago) {
        this.tipoDocPago = tipodocpago;
    }
}
