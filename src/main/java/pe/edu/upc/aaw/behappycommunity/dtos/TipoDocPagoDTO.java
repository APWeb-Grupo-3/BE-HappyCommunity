package pe.edu.upc.aaw.behappycommunity.dtos;

import javax.persistence.Column;

public class TipoDocPagoDTO {
    private int idTipoDocPago;
    private String nombre;
    private String administrador;

    public String getAdministrador() {
        return administrador;
    }

    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }

    public int getIdTipoDocPago() {
        return idTipoDocPago;
    }

    public void setIdTipoDocPago(int idTipoDocPago) {
        this.idTipoDocPago = idTipoDocPago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
