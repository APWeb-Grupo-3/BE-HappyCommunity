package pe.edu.upc.aaw.behappycommunity.entities;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "Tarjeta")
public class Tarjeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTarjeta;
    @Column(name = "tipoTarjeta", length = 50, nullable = false)
    private String tipoTarjeta;
    @Column(name = "numeroTarjeta", nullable = false)
    private Long numeroTarjeta;
    @Column(name = "fechaVencimiento",nullable = false)
    private LocalDate fechaVencimiento;
    @Column(name = "codigoSeguridad", nullable = false)
    private int codigoSeguridad;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Tarjeta() {
    }

    public Tarjeta(int idTarjeta, String tipoTarjeta, Long numeroTarjeta, LocalDate fechaVencimiento, int codigoSeguridad, Usuario usuario) {
        this.idTarjeta = idTarjeta;
        this.tipoTarjeta = tipoTarjeta;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.codigoSeguridad = codigoSeguridad;
        this.usuario = usuario;
    }

    public int getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(int idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public Long getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(Long numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(int codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
