package pe.edu.upc.aaw.behappycommunity.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "RolUsuario",uniqueConstraints = { @UniqueConstraint(columnNames = { "usuario_id", "rol" }) })
public class RolUsuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRolUsuario;

    @Column(name = "rol",length = 150,nullable = false)
    private String rol;
    @ManyToOne
    @JoinColumn(name="usuario_id",nullable = false)
    private Usuario usuario;

    public RolUsuario() {
    }

    public RolUsuario(Long idRolUsuario, String rol, Usuario usuario) {
        this.idRolUsuario = idRolUsuario;
        this.rol = rol;
        this.usuario = usuario;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
