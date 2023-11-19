package pe.edu.upc.aaw.behappycommunity.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.behappycommunity.entities.Servicio;
import pe.edu.upc.aaw.behappycommunity.repositories.IServicioRepository;
import pe.edu.upc.aaw.behappycommunity.repositories.ITipoServicioRepository;
import pe.edu.upc.aaw.behappycommunity.serviceinterfaces.IServicioService;

import java.util.List;

@Service
public class ServicioServiceImplement implements IServicioService {


    @Autowired
    private IServicioRepository serR;

    @Override
    public void insert(Servicio servicio) {
        serR.save(servicio);
    }

    @Override
    public List<Servicio> list() {
        return serR.findAll();
    }

    @Override
    public void delete(int idTipoServicio) {
        serR.deleteById(idTipoServicio);
    }

    @Override
    public Servicio listarId(int idServicio) {
        return serR.findById(idServicio).orElse(new Servicio());
    }

    @Override
    public List<Servicio> findServicioA(String administrador) {
        return serR.findServicioA(administrador);
    }

}
