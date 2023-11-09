package pe.edu.upc.aaw.behappycommunity.serviceinterfaces;

import pe.edu.upc.aaw.behappycommunity.entities.RolUsuario;

import java.util.List;

public interface IRolUsuarioService {
    public void insert(RolUsuario rolUsuario);
    public List<RolUsuario> list();
    public void delete(Long idRolUsuario);
    public RolUsuario listarId(long idRolUsuario);

}

