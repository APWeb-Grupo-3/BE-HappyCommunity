package pe.edu.upc.aaw.behappycommunity.serviceinterfaces;

import pe.edu.upc.aaw.behappycommunity.entities.TipoServicio;

import java.util.List;

public interface ITipoServicioService {



    void insert(TipoServicio tipoServicio );
    List<TipoServicio> list();
    void delete(int idTipoServicio);
    public TipoServicio listarId(int idTipoServicio);




}
