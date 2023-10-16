package pe.edu.upc.aaw.behappycommunity.entities;

import javax.persistence.*;

@Entity
@Table(name= "Servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServicio;

    @Column(name="descripcionServicio", nullable = false, length = 300)
    private String descripcionServicio;


    @ManyToOne
    @JoinColumn(name ="idTipoServicio")
    private TipoServicio tipoServicio;

    public Servicio() {
    }


    public Servicio(int idServicio, String descripcionServicio, TipoServicio tipoServicio) {
        this.idServicio = idServicio;
        this.descripcionServicio = descripcionServicio;
        this.tipoServicio = tipoServicio;
    }


    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }
}
