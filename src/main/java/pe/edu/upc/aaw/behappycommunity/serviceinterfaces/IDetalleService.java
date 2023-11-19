package pe.edu.upc.aaw.behappycommunity.serviceinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.aaw.behappycommunity.entities.Detalle;

import java.util.List;

public interface IDetalleService {



    void insert(Detalle detalle);
    List<Detalle> list();
    void delete(int idDetalle);

    public Detalle listarId(int idDetalle);

    public List<Detalle>findDetalleDoc(int id_documento_pago);
    public List<Detalle>findDetalleAR(String nombre_usuario);



}
