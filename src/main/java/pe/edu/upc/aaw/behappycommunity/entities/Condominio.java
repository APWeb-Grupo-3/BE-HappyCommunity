package pe.edu.upc.aaw.behappycommunity.entities;

import javax.persistence.*;

@Entity
@Table(name = "Condominio")
public class Condominio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCondominio;
    @Column(name = "nombre",nullable = false,length = 45)
    private String nombre;
    @Column(name = "departamento",nullable = false,length = 25)
    private String departamento;
    @Column(name = "distrito",nullable = false,length = 25)
    private String distrito;
    @Column(name = "direccion",nullable = false,length = 45)
    private String direccion;
    @Column(name = "administrador",nullable = false,length = 45)
    private String administrador;
    public Condominio() {
    }



    public int getIdCondominio() {
        return idCondominio;
    }

    public void setIdCondominio(int idCondominio) {
        this.idCondominio = idCondominio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getAdministrador() {
        return administrador;
    }

    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }
}
