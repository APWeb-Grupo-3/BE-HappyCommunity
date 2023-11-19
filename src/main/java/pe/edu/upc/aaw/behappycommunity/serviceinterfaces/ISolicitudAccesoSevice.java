package pe.edu.upc.aaw.behappycommunity.serviceinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.aaw.behappycommunity.entities.SolicitudAcceso;
import pe.edu.upc.aaw.behappycommunity.entities.Usuario;

import java.util.List;

public interface ISolicitudAccesoSevice {
    public void insert(SolicitudAcceso solicitudAcceso);
    public List<SolicitudAcceso> list();
    public void delete(int idSolicitudAcceso);

    public SolicitudAcceso listarId(int IdSolicitudAcceso);
    public List<SolicitudAcceso>findSolicitudVE(String nombre_usuario);

    public List<SolicitudAcceso>findSolicitudAR(String administrador);


}
