package pe.edu.upc.aaw.behappycommunity.serviceinterfaces;

import pe.edu.upc.aaw.behappycommunity.entities.Mensaje;

import java.util.List;

public interface IMensajeService {

    public void insert(Mensaje mensaje);
    public List<Mensaje> list();
    public void delete(int idMensaje);
    public Mensaje listarId(int idMensaje);

}
