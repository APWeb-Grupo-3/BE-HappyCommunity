package pe.edu.upc.aaw.behappycommunity.serviceinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.aaw.behappycommunity.entities.Mensaje;

import java.util.List;

public interface IMensajeService {

    public void insert(Mensaje mensaje);
    public List<Mensaje> list();
    public void delete(int idMensaje);
    public Mensaje listarId(int idMensaje);
    public List<Mensaje>findMensajeE(String nombre_usuario);
    public List<Mensaje>findMensajeR(String nombre_usuario);


}
