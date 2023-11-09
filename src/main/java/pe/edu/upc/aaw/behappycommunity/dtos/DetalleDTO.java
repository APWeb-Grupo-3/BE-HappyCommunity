package pe.edu.upc.aaw.behappycommunity.dtos;


import pe.edu.upc.aaw.behappycommunity.entities.DocumentoPago;
import pe.edu.upc.aaw.behappycommunity.entities.Servicio;

public class DetalleDTO {


    private int idDetalle;

    private double subtotalDetalle;

    private DocumentoPago documentoPago;

    public DocumentoPago getDocumentoPago() {
        return documentoPago;
    }

    public void setDocumentoPago(DocumentoPago documentoPago) {
        this.documentoPago = documentoPago;
    }

    private Servicio servicio;

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public double getSubtotalDetalle() {
        return subtotalDetalle;
    }

    public void setSubtotalDetalle(double subtotalDetalle) {
        this.subtotalDetalle = subtotalDetalle;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}