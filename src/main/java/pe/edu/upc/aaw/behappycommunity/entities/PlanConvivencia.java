package pe.edu.upc.aaw.behappycommunity.entities;

import javax.persistence.*;
@Entity
@Table(name="PlanConvivencia")


public class PlanConvivencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlanConvivencia;
    @Column(name = "titulo",nullable = false,length = 75)
    private String titulo;
    @Column(name = "descripcion",nullable = false,length = 254)
    private String descripcion;
    @ManyToOne
    @JoinColumn(name ="idCondominio")
    private Condominio condominio;

    public PlanConvivencia() {
    }

    public PlanConvivencia(int idPlanConvivencia, String titulo, String descripcion, Condominio condominio) {
        this.idPlanConvivencia = idPlanConvivencia;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.condominio = condominio;
    }

    public int getIdPlanConvivencia() {
        return idPlanConvivencia;
    }

    public void setIdPlanConvivencia(int idPlanConvivencia) {
        this.idPlanConvivencia = idPlanConvivencia;
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

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }
}
