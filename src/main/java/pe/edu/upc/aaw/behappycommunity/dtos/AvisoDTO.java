package pe.edu.upc.aaw.behappycommunity.dtos;

import pe.edu.upc.aaw.behappycommunity.entities.Condominio;
import pe.edu.upc.aaw.behappycommunity.entities.Usuario;

import java.time.LocalDate;

public class AvisoDTO {

    private int idAviso;
    private String titulo;
    private String descripcion;
    private Usuario usuario;
    private Condominio condominio;
    private LocalDate fechaPublicacion;
    public int getIdAviso() {
        return idAviso;
    }

    public void setIdAviso(int idAviso) {
        this.idAviso = idAviso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }

    public LocalDate getFechaPublicacion() { return fechaPublicacion;}

    public void setFechaPublicacion(LocalDate fechaPublicacion) { this.fechaPublicacion = fechaPublicacion;
    }
}

