package pe.edu.upc.aaw.behappycommunity.serviceinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.aaw.behappycommunity.entities.Condominio;
import pe.edu.upc.aaw.behappycommunity.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public void insert(Usuario usuario);
    public List<Usuario>list();
    public void delete(Long idUsuario);
    public Usuario listarId(long idUsuario);


    public List<String[]>findVecinosWithoutDebt(String administrador);

    public List<String[]>findVecinosWithDebt(String administrador);
    public List<Usuario> findUser(String nombre_usuario);
    public List<Usuario>findUsersC(Long id_condominio);


}
