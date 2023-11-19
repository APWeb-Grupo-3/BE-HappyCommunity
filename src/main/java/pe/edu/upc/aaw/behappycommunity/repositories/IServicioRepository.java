package pe.edu.upc.aaw.behappycommunity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.behappycommunity.entities.Servicio;

import java.util.List;

@Repository
public interface IServicioRepository extends JpaRepository<Servicio, Integer> {

    @Query(value="select \n" +
            " s.id_servicio,\n" +
            " s.descripcion_servicio,\n" +
            " s.id_tipo_Servicio\n" +
            " from servicio s \n" +
            " inner join tipo_servicio tp\n" +
            " on tp.id_tipo_servicio=s.id_tipo_servicio\n" +
            " where tp.administrador=:administrador",nativeQuery = true)
    public List<Servicio>findServicioA(@Param("administrador") String administrador);




}
