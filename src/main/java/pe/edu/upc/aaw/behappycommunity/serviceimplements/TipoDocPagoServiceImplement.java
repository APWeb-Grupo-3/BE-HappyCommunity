package pe.edu.upc.aaw.behappycommunity.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.behappycommunity.entities.TipoDocPago;
import pe.edu.upc.aaw.behappycommunity.repositories.ITipoDocPagoRepository;
import pe.edu.upc.aaw.behappycommunity.serviceinterfaces.ITipoDocPagoService;

import java.util.List;

@Service
public class TipoDocPagoServiceImplement implements ITipoDocPagoService {
    @Autowired
    private ITipoDocPagoRepository tR;
    //HU27: Registrar tipo de documento de pago
    @Override
    public void insert(TipoDocPago tipoDocPago) {
        tR.save(tipoDocPago);
    }

    @Override
    public List<TipoDocPago> list() {
        return tR.findAll();
    }

    @Override
    public void delete(int idTipoDocPago) {
        tR.deleteById(idTipoDocPago);
    }
}
