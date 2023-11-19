package pe.edu.upc.aaw.behappycommunity.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.behappycommunity.entities.TipoServicio;
import pe.edu.upc.aaw.behappycommunity.repositories.ITipoServicioRepository;
import pe.edu.upc.aaw.behappycommunity.serviceinterfaces.ITipoServicioService;

import java.util.List;

@Service
public class TipoServicioServiceImplement implements ITipoServicioService {

    @Autowired
    private ITipoServicioRepository tsR;

    @Override
    public void insert(TipoServicio tipoServicio) {
        tsR.save(tipoServicio);
    }

    @Override
    public List<TipoServicio> list() {
        return tsR.findAll();
    }

    @Override
    public void delete(int idTipoServicio) {
        tsR.deleteById(idTipoServicio);
    }
    @Override
    public TipoServicio listarId(int idTipoServicio) {
        return tsR.findById(idTipoServicio).orElse(new TipoServicio());
    }

    @Override
    public List<TipoServicio> findTipoSA(String administrador) {
        return tsR.findTipoSA(administrador);
    }


}
