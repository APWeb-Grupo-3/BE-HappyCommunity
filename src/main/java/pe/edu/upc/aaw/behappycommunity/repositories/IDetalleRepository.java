package pe.edu.upc.aaw.behappycommunity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.behappycommunity.entities.Detalle;

import java.util.List;

@Repository
public interface IDetalleRepository extends JpaRepository<Detalle, Integer> {
    @Query(value="select\n" +
            " de.id_detalle,\n" +
            " de.subtotal_detalle,\n" +
            " de.id_documento_pago,\n" +
            " de.id_servicio\n" +
            " from detalle de\n" +
            " inner join documento_pago dp\n" +
            " on de.id_documento_pago=dp.id_documento_pago\n" +
            " where dp.id_documento_pago=:id_documento_pago",nativeQuery = true)
    public List<Detalle>findDetalleDoc(@Param("id_documento_pago") int id_documento_pago);

    @Query(value="select\n" +
            " de.id_detalle,\n" +
            " de.subtotal_detalle,\n" +
            " de.id_documento_pago,\n" +
            " de.id_servicio\n" +
            " from detalle de\n" +
            " inner join documento_pago dp\n" +
            " on de.id_documento_pago=dp.id_documento_pago\n" +
            " inner join usuario u\n" +
            " on dp.id_usuario=u.id_usuario\n" +
            " where u.nombre_usuario=:nombre_usuario",nativeQuery = true)
    public List<Detalle>findDetalleAR(@Param("nombre_usuario") String nombre_usuario);
}
