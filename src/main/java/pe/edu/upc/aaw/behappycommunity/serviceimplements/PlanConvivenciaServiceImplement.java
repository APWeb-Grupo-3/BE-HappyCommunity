package pe.edu.upc.aaw.behappycommunity.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.behappycommunity.entities.PlanConvivencia;
import pe.edu.upc.aaw.behappycommunity.repositories.IPlanConvivenciaRepository;
import pe.edu.upc.aaw.behappycommunity.serviceinterfaces.IPlanConvivenciaService;

import java.util.List;

@Service
public class PlanConvivenciaServiceImplement implements IPlanConvivenciaService {
    @Autowired

    private IPlanConvivenciaRepository pR;
    @Override
    public void insert(PlanConvivencia planConvivencia){
        pR.save(planConvivencia);
    }
    @Override
    public List<PlanConvivencia> list(){
        return pR.findAll();
    }

    @Override
    public void delete(int idPlanConvivencia) {
        pR.deleteById(idPlanConvivencia);
    }


    @Override
    public PlanConvivencia listarId(int IdPlanConvivencia) {
        return pR.findById(IdPlanConvivencia).orElse(new PlanConvivencia());
    }

    @Override
    public List<PlanConvivencia> findPlanC(Long id_condominio) {
        return pR.findPlanC(id_condominio);
    }

    @Override
    public List<PlanConvivencia> findPlanR(String administrador) {
        return pR.findPlanR(administrador);
    }
}
