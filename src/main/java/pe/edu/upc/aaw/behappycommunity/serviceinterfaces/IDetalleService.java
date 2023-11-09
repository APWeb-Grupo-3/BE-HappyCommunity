package pe.edu.upc.aaw.behappycommunity.serviceinterfaces;

import pe.edu.upc.aaw.behappycommunity.entities.Detalle;

import java.util.List;

public interface IDetalleService {



    void insert(Detalle detalle);
    List<Detalle> list();
    void delete(int idDetalle);

    public Detalle listarId(int idDetalle);




}
