package pe.edu.upc.aaw.behappycommunity.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.behappycommunity.dtos.CondominioDTO;
import pe.edu.upc.aaw.behappycommunity.entities.Condominio;
import pe.edu.upc.aaw.behappycommunity.serviceinterfaces.ICondominioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/condominios")
public class CondominioController {

    @Autowired
    private ICondominioService dS;
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @PostMapping
    public void registrar(@RequestBody CondominioDTO dto){
        ModelMapper m = new ModelMapper();
        Condominio d = m.map(dto, Condominio.class);
        dS.insert(d);
    }
   // @PreAuthorize("hasAuthority('ADMINISTRADOR') or hasAuthority('VECINO') or hasAuthority('INVITADO')")

    @PreAuthorize("hasAuthority('ADMINISTRADOR') or hasAuthority('VECINO')")
    @GetMapping
    public List<CondominioDTO> listar(){
        return dS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,CondominioDTO.class);

        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @DeleteMapping("/{id}")
    public  void  eliminar(@PathVariable("id")Integer id){
        dS.delete(id);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @PutMapping
    public void modificar(@RequestBody CondominioDTO dto) {
        ModelMapper m = new ModelMapper();
        Condominio d = m.map(dto, Condominio.class);
        dS.insert(d);
    }
    @PreAuthorize("hasAuthority('ADMINISTRADOR') or hasAuthority('VECINO')")
    @GetMapping("/{id}")
    public CondominioDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        CondominioDTO dto=m.map(dS.listarId(id),CondominioDTO.class);
        return dto;
    }
    @GetMapping("/listarcar/{administrador}")
    public List<CondominioDTO> listarCondominiosAR(@PathVariable("administrador") String administrador){
        return dS.findCondominioAR(administrador).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,CondominioDTO.class);

        }).collect(Collectors.toList());
    }
    @GetMapping("/listarcva/{nombre_usuario}")
    public List<CondominioDTO> listarCondominiosVA(@PathVariable("nombre_usuario") String nombre_usuario){
        return dS.findCondominioVA(nombre_usuario).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,CondominioDTO.class);

        }).collect(Collectors.toList());
    }
}
