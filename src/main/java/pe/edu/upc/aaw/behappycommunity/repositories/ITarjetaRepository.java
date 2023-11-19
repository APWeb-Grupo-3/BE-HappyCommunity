package pe.edu.upc.aaw.behappycommunity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import pe.edu.upc.aaw.behappycommunity.entities.Tarjeta;

import java.util.List;

@Repository
public interface ITarjetaRepository extends JpaRepository<Tarjeta, Integer> {
    @Query(value="select \n" +
            " t.id_tarjeta,\n" +
            " t.tipo_tarjeta,\n" +
            " t.numero_tarjeta,\n" +
            " t.fecha_vencimiento,\n" +
            " t.codigo_seguridad\n" +
            " from tarjeta t\n" +
            " inner join usuario u\n" +
            " on t.id_usuario=u.id_usuario\n" +
            " where u.nombre_usuario=:nombre_usuario",nativeQuery = true)
    public List<Tarjeta>findTarjetaR(@Param("nombre_usuario") String nombre_usuario);
}
