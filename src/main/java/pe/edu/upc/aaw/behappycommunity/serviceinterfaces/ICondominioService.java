package pe.edu.upc.aaw.behappycommunity.serviceinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.aaw.behappycommunity.entities.Condominio;

import java.util.List;

public interface ICondominioService {

    public void insert(Condominio condominio);
    public List<Condominio> list();
    public void delete(int idCondominio);
    public Condominio listarId(int IdCondominio);
    public List<Condominio>findCondominioAR(String administrador);

    public List<Condominio>findCondominioVA(String nombre_usuario);


}
