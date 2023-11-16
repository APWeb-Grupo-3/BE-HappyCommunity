package pe.edu.upc.aaw.behappycommunity.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.behappycommunity.entities.Usuario;
import pe.edu.upc.aaw.behappycommunity.repositories.IUsuarioRepository;
import pe.edu.upc.aaw.behappycommunity.serviceinterfaces.IUsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService {
    @Autowired
    private IUsuarioRepository uR;

    @Override
    public void insert(Usuario usuario) {
        uR.save(usuario);
    }

    @Override
    public List<Usuario> list() {
        return uR.findAll();
    }

    @Override
    public void delete(Long idUsuario) {
        uR.deleteById(idUsuario);
    }
    @Override
    public List<String[]> findVecinosWithoutDebt() {
        return uR.findVecinosWithoutDebt();
    }

    @Override
    public List<String[]> findVecinosWithDebt() {
        return uR.findVecinosWithDebt();
    }

    @Override
    public Usuario listarId(long idUsuario) {
        return uR.findById(idUsuario).orElse(new Usuario());
    }
    @Override
    public List<Usuario> findUser(String nombre_usuario) {
        return uR.findUser(nombre_usuario);
    }
}
