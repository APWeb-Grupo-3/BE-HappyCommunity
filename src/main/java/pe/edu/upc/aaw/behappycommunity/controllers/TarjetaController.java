package pe.edu.upc.aaw.behappycommunity.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.behappycommunity.dtos.TarjetaDTO;
import pe.edu.upc.aaw.behappycommunity.entities.Tarjeta;
import pe.edu.upc.aaw.behappycommunity.serviceinterfaces.ITarjetaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tarjetas")
public class TarjetaController {

    @Autowired
    private ITarjetaService tS;
    @PreAuthorize("hasAuthority('VECINO')") /* HU39*/
    @PostMapping
    public void registrar(@RequestBody TarjetaDTO dto){
        ModelMapper m = new ModelMapper();
        Tarjeta t = m.map(dto, Tarjeta.class);
        tS.insert(t);
    }
    @PreAuthorize("hasAuthority('VECINO')") /* HU56*/
    @GetMapping
    public List<TarjetaDTO> listar(){
        return tS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,TarjetaDTO.class);

        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('VECINO')") /* HU55*/
    @DeleteMapping("/{id}")
    public  void  eliminar(@PathVariable("id")Integer id){
        tS.delete(id);
    }
    @PreAuthorize("hasAuthority('VECINO')") /* HU54*/
    @PutMapping
    public void modificar(@RequestBody TarjetaDTO dto){
        ModelMapper m = new ModelMapper();
        Tarjeta t = m.map(dto, Tarjeta.class);
        tS.insert(t);
    }
    @GetMapping("/{id}")
    public TarjetaDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        TarjetaDTO dto=m.map(tS.listarId(id),TarjetaDTO.class);
        return dto;
    }
    @GetMapping("/listartr/{nombre_usuario}")
    public List<TarjetaDTO> listarTR(@PathVariable("nombre_usuario") String nombre_usuario){
        return tS.findTarjetaR(nombre_usuario).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,TarjetaDTO.class);

        }).collect(Collectors.toList());
    }
}
