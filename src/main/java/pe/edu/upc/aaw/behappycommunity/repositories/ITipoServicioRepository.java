package pe.edu.upc.aaw.behappycommunity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.behappycommunity.entities.TipoServicio;

import java.util.List;

@Repository
public interface ITipoServicioRepository extends JpaRepository<TipoServicio, Integer> {

    @Query(value="select\n" +
            " *\n" +
            " from tipo_servicio\n" +
            " where administrador=:administrador",nativeQuery = true)
    public List<TipoServicio> findTipoSA(@Param("administrador") String administrador);

}
