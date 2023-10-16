package pe.edu.upc.aaw.behappycommunity.serviceinterfaces;

import pe.edu.upc.aaw.behappycommunity.entities.SolicitudAcceso;

import java.util.List;

public interface ISolicitudAccesoSevice {
    public void insert(SolicitudAcceso solicitudAcceso);
    public List<SolicitudAcceso> list();
    public void delete(int idSolicitudAcceso);

    public SolicitudAcceso listarId(int IdSolicitudAcceso);
}
