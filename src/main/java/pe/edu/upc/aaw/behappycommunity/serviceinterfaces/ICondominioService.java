package pe.edu.upc.aaw.behappycommunity.serviceinterfaces;

import pe.edu.upc.aaw.behappycommunity.entities.Condominio;

import java.util.List;

public interface ICondominioService {

    public void insert(Condominio condominio);
    public List<Condominio> list();
    public void delete(int idCondominio);
    public Condominio listarId(int IdCondominio);

}
