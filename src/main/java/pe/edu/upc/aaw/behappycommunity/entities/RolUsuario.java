package pe.edu.upc.aaw.behappycommunity.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "RolUsuario")
public class RolUsuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRolUsuario;

    @Column(name = "rol",length = 150,nullable = false)
    private String rol;

    public RolUsuario() {
    }

    public RolUsuario(Long idRolUsuario, String rol, Usuario usuario) {
        this.idRolUsuario = idRolUsuario;
        this.rol = rol;
    }

    public Long getIdRolUsuario() {
        return idRolUsuario;
    }

    public void setIdRolUsuario(Long idRolUsuario) {
        this.idRolUsuario = idRolUsuario;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

}
