package pe.edu.upc.aaw.behappycommunity.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.behappycommunity.dtos.PlanConvivenciaDTO;
import pe.edu.upc.aaw.behappycommunity.entities.PlanConvivencia;
import pe.edu.upc.aaw.behappycommunity.serviceinterfaces.IPlanConvivenciaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/planconvivencia")
public class PlanConvivenciaController {
    @Autowired
    private IPlanConvivenciaService pS;

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @PostMapping
    public void registrar(@RequestBody PlanConvivenciaDTO dto){
        ModelMapper m=new ModelMapper();
        PlanConvivencia u=m.map(dto,PlanConvivencia.class);
        pS.insert(u);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @GetMapping
    public List<PlanConvivenciaDTO> listar(){
        return pS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,PlanConvivenciaDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR') ")
    @PutMapping
    public void modificar(@RequestBody PlanConvivenciaDTO dto){
        ModelMapper m=new ModelMapper();
        PlanConvivencia u=m.map(dto,PlanConvivencia.class);
        pS.insert(u);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR') or hasAuthority('VECINO')")
    @GetMapping("/{id}")
    public PlanConvivenciaDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        PlanConvivenciaDTO dto=m.map(pS.listarId(id),PlanConvivenciaDTO.class);
        return dto;
    }
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @DeleteMapping("/{id}")
    public  void  eliminar(@PathVariable("id")Integer id){
        pS.delete(id);
    }

}
