package pe.edu.upc.aaw.behappycommunity.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.behappycommunity.entities.Detalle;
import pe.edu.upc.aaw.behappycommunity.repositories.IDetalleRepository;
import pe.edu.upc.aaw.behappycommunity.serviceinterfaces.IDetalleService;

import java.util.List;

@Service

public class DetalleServiceInterface implements IDetalleService {


    @Autowired
    private IDetalleRepository detR;

    @Override
    public void insert(Detalle detalle) {
        detR.save(detalle);
    }

    @Override
    public List<Detalle> list() {
        return detR.findAll();
    }

    @Override
    public void delete(int idDetalle) {
        detR.deleteById(idDetalle);
    }

    @Override
    public Detalle listarId(int idDetalle) {
        return detR.findById(idDetalle).orElse( new Detalle());
    }

    @Override
    public List<Detalle> findDetalleDoc(int id_documento_pago) {
        return detR.findDetalleDoc(id_documento_pago);
    }

    @Override
    public List<Detalle> findDetalleAR(String nombre_usuario) {
        return detR.findDetalleAR(nombre_usuario);
    }

}
