package pe.edu.upc.aaw.behappycommunity.serviceinterfaces;

import pe.edu.upc.aaw.behappycommunity.entities.Tarjeta;

import java.util.List;

public interface ITarjetaService {

    public void insert(Tarjeta tarjeta);
    public List<Tarjeta>list();
    public void delete(int idTarjeta);

}
