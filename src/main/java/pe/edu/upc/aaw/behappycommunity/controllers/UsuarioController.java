package pe.edu.upc.aaw.behappycommunity.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.behappycommunity.dtos.Reporte1DTO;
import pe.edu.upc.aaw.behappycommunity.dtos.Reporte3DTO;
import pe.edu.upc.aaw.behappycommunity.dtos.UsuarioDTO;
import pe.edu.upc.aaw.behappycommunity.entities.Usuario;
import pe.edu.upc.aaw.behappycommunity.security.JwtRequest;
import pe.edu.upc.aaw.behappycommunity.security.JwtResponse;
import pe.edu.upc.aaw.behappycommunity.serviceinterfaces.IUsuarioService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private IUsuarioService uS;
    @PostMapping("/register")
    public ResponseEntity<?> registrar(@RequestBody UsuarioDTO dto){
        try {
            ModelMapper m = new ModelMapper();
            Usuario u = m.map(dto, Usuario.class);

            String claveEncriptada = BCrypt.hashpw(u.getClave(), BCrypt.gensalt(10));

            u.setClave(claveEncriptada);

            uS.insert(u);
            return ResponseEntity.ok("Usuario registrado exitosamente");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar al usuario: " + ex.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR') or hasAuthority('VECINO') or hasAuthority('INVITADO')")
    @GetMapping
    public List<UsuarioDTO>listar(){
        return uS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('ADMINISTRADOR') or hasAuthority('VECINO') or hasAuthority('INVITADO')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id){
        uS.delete(id);
    }
    @PreAuthorize("hasAuthority('ADMINISTRADOR') or hasAuthority('VECINO') or hasAuthority('INVITADO')")
    @PutMapping
    public void modificar(@RequestBody UsuarioDTO dto){
        ModelMapper m=new ModelMapper();
        Usuario u=m.map(dto,Usuario.class);
        String claveEncriptada = BCrypt.hashpw(u.getClave(), BCrypt.gensalt(10));

        u.setClave(claveEncriptada);
        uS.insert(u);
    }
    @PreAuthorize("hasAuthority('ADMINISTRADOR') or hasAuthority('VECINO') or hasAuthority('INVITADO')")
    @GetMapping("/{id}")
    public UsuarioDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        UsuarioDTO dto=m.map(uS.listarId(id),UsuarioDTO.class);
        return dto;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @GetMapping("/reporte1/{administrador}")
    public List<Reporte1DTO>visualizarVecinosPagosAlDia(@PathVariable("administrador")String administrador){
        List<String[]>lista=uS.findVecinosWithoutDebt(administrador);
        List<Reporte1DTO>listaDTO=new ArrayList<>();
        for(String[] data:lista){
            Reporte1DTO dto=new Reporte1DTO();
            dto.setIdUsuario(Long.parseLong(data[0]));
            dto.setApellidos(data[1]);
            dto.setNombres(data[2]);
            dto.setNombreUsuario(data[3]);
            listaDTO.add(dto);
        }
        return listaDTO;
    }
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @GetMapping("/reporte3")
    public List<Reporte3DTO>visualizarVecinosConDeuda(){
        List<String[]>lista=uS.findVecinosWithDebt();
        List<Reporte3DTO>listaDTO= new ArrayList<>();
        for(String[] data:lista){
            Reporte3DTO dto=new Reporte3DTO();
            dto.setApellidos(data[0]);
            dto.setNombres(data[1]);
            dto.setEstado(data[2]);
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR') or hasAuthority('VECINO') or hasAuthority('INVITADO')")
    @GetMapping("/listaru/{nombre_usuario}")
    public List<UsuarioDTO> listarUsuario(@PathVariable("nombre_usuario") String nombre_usuario) {
        return uS.findUser(nombre_usuario).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/listaruc/{id_condominio}")
    public List<UsuarioDTO> listarUsuarioC(@PathVariable("id_condominio") Long id_condominio) {
        return uS.findUsersC(id_condominio).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }
}
