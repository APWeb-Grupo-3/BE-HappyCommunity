package pe.edu.upc.aaw.behappycommunity.dtos;

import pe.edu.upc.aaw.behappycommunity.entities.TipoDocPago;
import pe.edu.upc.aaw.behappycommunity.entities.Usuario;

import java.time.LocalDate;

public class DocumentoPagoDTO {
    private int idDocumentoPago;
    private int idReceptor;
    private LocalDate fechaEmision;
    private LocalDate fechaVencimiento;
    private String moneda;
    //total int->double
    private double total;
    private String estado;
    //Foreign keys
    private Usuario usuario;

    private TipoDocPago tipoDocPago;

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

    public void setTipoDocPago(TipoDocPago tipoDocPago) {
        this.tipoDocPago = tipoDocPago;
    }
}
