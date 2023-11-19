package pe.edu.upc.aaw.behappycommunity.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.behappycommunity.dtos.SolicitudAccesoDTO;
import pe.edu.upc.aaw.behappycommunity.dtos.UsuarioDTO;
import pe.edu.upc.aaw.behappycommunity.entities.SolicitudAcceso;
import pe.edu.upc.aaw.behappycommunity.serviceinterfaces.ISolicitudAccesoSevice;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/solicitudacceso")
public class SolicitudAccesoController {
    @Autowired
    private ISolicitudAccesoSevice sS;
    @PreAuthorize("hasAuthority('ADMINISTRADOR') or hasAuthority('VECINO') ")

    @PostMapping
    public void registrar(@RequestBody SolicitudAccesoDTO dto){
        ModelMapper m= new ModelMapper();
        SolicitudAcceso s= m.map(dto, SolicitudAcceso.class);
        sS.insert(s);
    }
    @PreAuthorize("hasAuthority('ADMINISTRADOR') or hasAuthority('VECINO') ")
    @GetMapping
    public List<SolicitudAccesoDTO> listar(){
        return  sS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,SolicitudAccesoDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public  void  eliminar(@PathVariable("id")Integer id){
        sS.delete(id);
    }
    @PreAuthorize("hasAuthority('ADMINISTRADOR') or hasAuthority('VECINO') ")
    @PutMapping
    public void modificar(@RequestBody SolicitudAccesoDTO dto) {
        ModelMapper m = new ModelMapper();
        SolicitudAcceso s = m.map(dto, SolicitudAcceso.class);
        sS.insert(s);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR') or hasAuthority('VECINO')")

    @GetMapping("/{id}")
    public SolicitudAccesoDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        SolicitudAccesoDTO dto=m.map(sS.listarId(id),SolicitudAccesoDTO.class);
        return dto;
    }
    @GetMapping("/listarsve/{nombre_usuario}")
    public List<SolicitudAccesoDTO> listarSolicitudVenviados(@PathVariable("nombre_usuario") String nombre_usuario) {
        return sS.findSolicitudVE(nombre_usuario).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,SolicitudAccesoDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/listarsar/{administrador}")
    public List<SolicitudAccesoDTO> listarSolicitudArecibidos(@PathVariable("administrador") String administrador) {
        return sS.findSolicitudAR(administrador).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,SolicitudAccesoDTO.class);
        }).collect(Collectors.toList());
    }
}
