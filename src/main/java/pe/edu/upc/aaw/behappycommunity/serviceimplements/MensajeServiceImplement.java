package pe.edu.upc.aaw.behappycommunity.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.behappycommunity.entities.Mensaje;
import pe.edu.upc.aaw.behappycommunity.repositories.IMensajeRepository;
import pe.edu.upc.aaw.behappycommunity.serviceinterfaces.IMensajeService;

import java.util.List;

@Service
public class MensajeServiceImplement implements IMensajeService {
    @Autowired
    private IMensajeRepository mR;

    @Override
    public void insert(Mensaje mensaje) {
        mR.save(mensaje);
    }

    @Override
    public List<Mensaje> list() {
        return mR.findAll();
    }

    @Override
    public void delete(int idMensaje) {
        mR.deleteById(idMensaje);
    }
    @Override
    public Mensaje listarId(int idMensaje) {
        return mR.findById(idMensaje).orElse(new Mensaje());
    }

}
