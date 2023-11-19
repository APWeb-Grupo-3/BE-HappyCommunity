package pe.edu.upc.aaw.behappycommunity.serviceinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.aaw.behappycommunity.entities.TipoDocPago;

import java.util.List;

public interface ITipoDocPagoService {
    public void insert(TipoDocPago tipoDocPago);
    public List<TipoDocPago>list();
    public void delete(int idTipoDocPago);
    public TipoDocPago listarId(int idTipoDocPago);
    public List<TipoDocPago>findTipoDR(String administrador);


}
