package pe.edu.upc.aaw.behappycommunity.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    @Column(length = 30, unique = true)
    private String nombreUsuario;
    @Column(length = 200)
    private String clave;
    private Boolean habilitado;

    @ManyToOne
    @JoinColumn(name = "idRolUsuario",nullable = false)
    private RolUsuario rol;

    @Column(name = "nombres",length = 100,nullable = false)
    private String nombres;
    @Column(name = "apellidos",length = 150,nullable = false)
    private String apellidos;
    @Column(name = "correo",length = 150,nullable = false)
    private String correo;
    @Column(name = "edad",nullable = false)
    private int edad;
    @Column(name = "telefono",nullable = false)
    private Long telefono;
    @Column(name = "genero",length = 100,nullable = false)
    private String genero;

    public Usuario() {
    }

    public Usuario(Long idUsuario, String nombreUsuario, String clave, Boolean habilitado, RolUsuario rol, String nombres, String apellidos, String correo, int edad, Long telefono, String genero) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.habilitado = habilitado;
        this.rol = rol;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.edad = edad;
        this.telefono = telefono;
        this.genero = genero;
    }

    public RolUsuario getRol() {
        return rol;
    }

    public void setRol(RolUsuario rol) {
        this.rol = rol;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }





    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
