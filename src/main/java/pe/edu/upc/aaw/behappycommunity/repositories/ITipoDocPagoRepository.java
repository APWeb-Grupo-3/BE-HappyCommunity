package pe.edu.upc.aaw.behappycommunity.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.behappycommunity.entities.TipoDocPago;

import java.util.List;

@Repository
public interface ITipoDocPagoRepository extends JpaRepository<TipoDocPago,Integer> {
    @Query(value="select\n" +
            " *\n" +
            " from tipo_doc_pago\n" +
            " where administrador=:administrador",nativeQuery = true)
    public List<TipoDocPago>findTipoDR(@Param("administrador") String administrador);
}
