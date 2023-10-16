package pe.edu.upc.aaw.behappycommunity.dtos;

import pe.edu.upc.aaw.behappycommunity.entities.Condominio;

public class PlanConvivenciaDTO {
    private int idPlanConvivencia;
    private String titulo;
    private String descripcion;
    private Condominio condominio;
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
