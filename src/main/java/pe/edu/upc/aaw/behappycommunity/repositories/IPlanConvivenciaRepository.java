package pe.edu.upc.aaw.behappycommunity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.behappycommunity.entities.PlanConvivencia;

import java.util.List;

@Repository
public interface IPlanConvivenciaRepository extends JpaRepository<PlanConvivencia, Integer> {
    @Query(value="select \n" +
            " *\n" +
            " from plan_convivencia\n" +
            " where id_condominio=:id_condominio",nativeQuery = true)
    public List<PlanConvivencia> findPlanC(@Param("id_condominio") Long id_condominio);
}
