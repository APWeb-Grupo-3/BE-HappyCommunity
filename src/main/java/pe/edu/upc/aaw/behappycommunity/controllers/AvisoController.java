package pe.edu.upc.aaw.behappycommunity.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.behappycommunity.dtos.AvisoDTO;
import pe.edu.upc.aaw.behappycommunity.dtos.Reporte2DTO;
import pe.edu.upc.aaw.behappycommunity.entities.Aviso;
import pe.edu.upc.aaw.behappycommunity.serviceinterfaces.IAvisoService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/avisos")
public class AvisoController {

    @Autowired
    private IAvisoService aS;
    @PreAuthorize("hasAuthority('ADMINISTRADOR') or hasAuthority('VECINO') or hasAuthority('INVITADO')")
    @PostMapping
    public void registrar(@RequestBody AvisoDTO dto){
        ModelMapper m = new ModelMapper();
        Aviso d = m.map(dto, Aviso.class);
        aS.insert(d);
    }
    @PreAuthorize("hasAuthority('ADMINISTRADOR') or hasAuthority('VECINO') or hasAuthority('INVITADO')")
    @GetMapping
    public List<AvisoDTO> listar(){
        return aS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,AvisoDTO.class);

        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('ADMINISTRADOR') or hasAuthority('VECINO') or hasAuthority('INVITADO')")
    @DeleteMapping("/{id}")
    public  void  eliminar(@PathVariable("id")Integer id){
        aS.delete(id);
    }
    @PreAuthorize("hasAuthority('ADMINISTRADOR') or hasAuthority('VECINO') or hasAuthority('INVITADO')")
    @PutMapping
    public void modificar(@RequestBody AvisoDTO dto) {
        ModelMapper m = new ModelMapper();
        Aviso a = m.map(dto, Aviso.class);
        aS.insert(a);
    }
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @GetMapping("/reporte2")
    public List<Reporte2DTO>VisualizarCantidadAvisosPorMes(){
        List<String[]>lista=aS.quantityAnnouncementPerMonth();
        List<Reporte2DTO>listaDTO= new ArrayList<>();
        for(String[] data:lista){
            Reporte2DTO dto=new Reporte2DTO();
            dto.setAnio(Integer.parseInt(data[0]));
            dto.setMes(data[1]);
            dto.setCantidad_de_avisos(Integer.parseInt(data[2]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @GetMapping("/{id}")
    public AvisoDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        AvisoDTO dto=m.map(aS.listarId(id),AvisoDTO.class);
        return dto;
    }
}
