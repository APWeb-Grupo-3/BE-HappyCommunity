package pe.edu.upc.aaw.behappycommunity.serviceinterfaces;

import pe.edu.upc.aaw.behappycommunity.entities.TipoDocPago;

import java.util.List;

public interface ITipoDocPagoService {
    public void insert(TipoDocPago tipoDocPago);
    public List<TipoDocPago>list();
    public void delete(int idTipoDocPago);
}
