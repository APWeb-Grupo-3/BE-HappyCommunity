package pe.edu.upc.aaw.behappycommunity.entities;

import javax.persistence.*;
@Entity
@Table(name="SolicitudAcceso")

public class SolicitudAcceso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSolicitudAcceso;
    @Column(name = "estado",nullable = false,length = 200)
    private String estado;
    @ManyToOne
    @JoinColumn(name ="idCondominio")
    private Condominio condominio;

    @ManyToOne
    @JoinColumn(name ="idUsuario")
    private Usuario usuario;

    public SolicitudAcceso() {
    }

    public SolicitudAcceso(int idSolicitudAcceso, String estado, Condominio condominio, Usuario usuario) {
        this.idSolicitudAcceso = idSolicitudAcceso;
        this.estado = estado;
        this.condominio = condominio;
        this.usuario = usuario;
    }

    public int getIdSolicitudAcceso() {
        return idSolicitudAcceso;
    }

    public void setIdSolicitudAcceso(int idSolicitudAcceso) {
        this.idSolicitudAcceso = idSolicitudAcceso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
