package pe.edu.upc.aaw.behappycommunity.serviceinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.aaw.behappycommunity.entities.PlanConvivencia;

import java.util.List;

public interface IPlanConvivenciaService {
    public void insert(PlanConvivencia planConvivencia);
    public List<PlanConvivencia> list();
    public void delete(int idPlanConvivencia);

    public PlanConvivencia listarId(int IdPlanConvivencia);
    public List<PlanConvivencia> findPlanC(Long id_condominio);

}
