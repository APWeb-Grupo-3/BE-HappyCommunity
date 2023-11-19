package pe.edu.upc.aaw.behappycommunity.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.behappycommunity.dtos.ServicioDTO;
import pe.edu.upc.aaw.behappycommunity.entities.Servicio;
import pe.edu.upc.aaw.behappycommunity.serviceinterfaces.IServicioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/servicios")
public class ServicioController {



    @Autowired
    private IServicioService serR;
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @PostMapping
    public void registrar(@RequestBody ServicioDTO dto){
        ModelMapper m=new ModelMapper();
        Servicio t=m.map(dto,Servicio.class);
        serR.insert(t);
    }
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @GetMapping
    public List<ServicioDTO> listar(){
        return serR.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,ServicioDTO.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")Integer id){
        serR.delete(id);
    }
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @PutMapping
    public void modificar(@RequestBody ServicioDTO dto) {
        ModelMapper m = new ModelMapper();
        Servicio t = m.map(dto, Servicio.class);
        serR.insert(t);
    }
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @GetMapping("/{id}")
    public ServicioDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        ServicioDTO dto=m.map(serR.listarId(id),ServicioDTO.class);
        return dto;
    }
    @GetMapping("/listarsa/{administrador}")
    public List<ServicioDTO> listarServiciosA(@PathVariable("administrador") String administrador){
        return serR.findServicioA(administrador).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,ServicioDTO.class);
        }).collect(Collectors.toList());
    }

}
