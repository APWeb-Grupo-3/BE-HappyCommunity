package pe.edu.upc.aaw.behappycommunity.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.behappycommunity.dtos.RolUsuarioDTO;
import pe.edu.upc.aaw.behappycommunity.entities.RolUsuario;
import pe.edu.upc.aaw.behappycommunity.serviceinterfaces.IRolUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rolusuarios")
public class RolUsuarioController {
    @Autowired
    private IRolUsuarioService ruS;
    @PostMapping
    public void registrar(@RequestBody RolUsuarioDTO dto){
        ModelMapper m=new ModelMapper();
        RolUsuario tu=m.map(dto, RolUsuario.class);
        ruS.insert(tu);
    }
    @GetMapping("/getroles")
    public List<RolUsuarioDTO>listar(){
        return ruS.list().stream().map(x->{
                ModelMapper m=new ModelMapper();
                return m.map(x, RolUsuarioDTO.class);
            }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('ADMINISTRADOR') or hasAuthority('VECINO') or hasAuthority('INVITADO')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id){
        ruS.delete(id);
    }
    @PreAuthorize("hasAuthority('ADMINISTRADOR') or hasAuthority('VECINO') or hasAuthority('INVITADO')")
    @PutMapping
    public void modificar(@RequestBody RolUsuarioDTO dto){
        ModelMapper m=new ModelMapper();
        RolUsuario tu=m.map(dto, RolUsuario.class);
        ruS.insert(tu);
    }
    @PreAuthorize("hasAuthority('ADMINISTRADOR') or hasAuthority('VECINO') or hasAuthority('INVITADO')")
    @GetMapping("/{id}")
    public RolUsuarioDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        RolUsuarioDTO dto=m.map(ruS.listarId(id),RolUsuarioDTO.class);
        return dto;
    }
}
