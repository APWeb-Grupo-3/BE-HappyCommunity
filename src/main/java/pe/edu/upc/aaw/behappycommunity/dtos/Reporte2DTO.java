package pe.edu.upc.aaw.behappycommunity.dtos;

public class Reporte2DTO {
    private int anio;
    private String mes;
    private int cantidad_de_avisos;

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getCantidad_de_avisos() {
        return cantidad_de_avisos;
    }

    public void setCantidad_de_avisos(int cantidad_de_avisos) {
        this.cantidad_de_avisos = cantidad_de_avisos;
    }
}
