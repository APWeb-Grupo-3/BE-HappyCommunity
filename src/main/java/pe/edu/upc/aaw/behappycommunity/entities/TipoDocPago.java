package pe.edu.upc.aaw.behappycommunity.entities;

import javax.persistence.*;

@Entity
@Table(name = "TipoDocPago")
public class TipoDocPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoDocPago;
    @Column(name = "nombre",length = 150,nullable = false)
    private String nombre;

    public TipoDocPago() {
    }

    public TipoDocPago(int idTipoDocPago, String nombre) {
        this.idTipoDocPago = idTipoDocPago;
        this.nombre = nombre;
    }

    public int getIdTipoDocPago() {
        return idTipoDocPago;
    }

    public void setIdTipoDocPago(int idTipoDocPago) {
        this.idTipoDocPago = idTipoDocPago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
