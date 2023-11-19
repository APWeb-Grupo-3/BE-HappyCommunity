package pe.edu.upc.aaw.behappycommunity.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.behappycommunity.entities.Condominio;
import pe.edu.upc.aaw.behappycommunity.repositories.ICondominioRepository;
import pe.edu.upc.aaw.behappycommunity.serviceinterfaces.ICondominioService;

import java.util.List;

@Service
public class CondominioServiceImplement implements ICondominioService {
    @Autowired
    private ICondominioRepository dR;

    @Override
    public void insert(Condominio condominio) {
        dR.save(condominio);
    }

    @Override
    public List<Condominio> list() {
        return     dR.findAll();
    }

    @Override
    public void delete(int idCondominio) {
        dR.deleteById(idCondominio);
    }


    @Override
    public Condominio listarId(int IdCondominio) {
        return dR.findById(IdCondominio).orElse(new Condominio());
    }

    @Override
    public List<Condominio> findCondominioAR(String administrador) {
        return dR.findCondominioAR(administrador);
    }

    @Override
    public List<Condominio> findCondominioVA(String nombre_usuario) {
        return dR.findCondominioVA(nombre_usuario);
    }
}
