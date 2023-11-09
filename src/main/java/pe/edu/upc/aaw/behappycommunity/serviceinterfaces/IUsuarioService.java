package pe.edu.upc.aaw.behappycommunity.serviceinterfaces;

import pe.edu.upc.aaw.behappycommunity.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public void insert(Usuario usuario);
    public List<Usuario>list();
    public void delete(Long idUsuario);
    public Usuario listarId(long idUsuario);


    public List<String[]>findVecinosWithoutDebt();

    public List<String[]>findVecinosWithDebt();

}
