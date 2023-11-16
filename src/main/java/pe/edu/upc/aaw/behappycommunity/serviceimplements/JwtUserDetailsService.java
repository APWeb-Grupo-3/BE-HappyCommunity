package pe.edu.upc.aaw.behappycommunity.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.behappycommunity.entities.RolUsuario;
import pe.edu.upc.aaw.behappycommunity.entities.Usuario;
import pe.edu.upc.aaw.behappycommunity.repositories.IUsuarioRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private IUsuarioRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = repo.findByNombreUsuario(username);

        if(user == null) {
            throw new UsernameNotFoundException(String.format("User not exists", username));
        }

        List<GrantedAuthority> roles = new ArrayList<>();

        RolUsuario rol=user.getRol();

        roles.add(new SimpleGrantedAuthority(rol.getRol()));


        /*
        user.getRol().forEach(rol -> {
            roles.add(new SimpleGrantedAuthority(rol.getRol()));
        });

         */

        UserDetails ud = new org.springframework.security.core.userdetails.User(user.getNombreUsuario(), user.getClave(), user.getHabilitado(),true, true, true, roles);

        return ud;
    }
}
