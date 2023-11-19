package pe.edu.upc.aaw.behappycommunity.serviceinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.aaw.behappycommunity.entities.Servicio;

import java.util.List;

public interface IServicioService {


    void insert(Servicio servicio);
    List<Servicio> list();
    void delete(int idServicio);
    public Servicio listarId(int idServicio);

    public List<Servicio>findServicioA(String administrador);

}
