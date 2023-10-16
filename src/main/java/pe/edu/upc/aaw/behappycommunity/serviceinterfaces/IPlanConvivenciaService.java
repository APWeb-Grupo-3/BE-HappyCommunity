package pe.edu.upc.aaw.behappycommunity.serviceinterfaces;

import pe.edu.upc.aaw.behappycommunity.entities.PlanConvivencia;

import java.util.List;

public interface IPlanConvivenciaService {
    public void insert(PlanConvivencia planConvivencia);
    public List<PlanConvivencia> list();

    public PlanConvivencia listarId(int IdPlanConvivencia);
}
