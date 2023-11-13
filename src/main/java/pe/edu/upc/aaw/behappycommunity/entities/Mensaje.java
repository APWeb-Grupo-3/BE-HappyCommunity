package pe.edu.upc.aaw.behappycommunity.entities;

import javax.persistence.*;

@Entity
@Table(name = "Mensaje")
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMensaje;
    @Column(name = "titulo", length = 50, nullable = false)
    private String titulo;
    @Column(name = "descripcion", length = 300, nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    @Column(name="idReceptor",nullable = false)
    private String receptor;

    public Mensaje(int idMensaje, String titulo, String descripcion, Usuario usuario, String receptor) {
        this.idMensaje = idMensaje;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.receptor = receptor;
    }

    public Mensaje() {

    }

    public int getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
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

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }
}
