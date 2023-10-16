package pe.edu.upc.aaw.behappycommunity.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.behappycommunity.dtos.TipoDocPagoDTO;
import pe.edu.upc.aaw.behappycommunity.entities.TipoDocPago;
import pe.edu.upc.aaw.behappycommunity.serviceinterfaces.ITipoDocPagoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tipodocumentopago")
public class TipoDocPagoController {
    @Autowired
    private ITipoDocPagoService tS;
    //HU27: Registrar tipo documento de pago
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @PostMapping
    public void registrar(@RequestBody TipoDocPagoDTO dto){
        ModelMapper m=new ModelMapper();
        TipoDocPago t=m.map(dto,TipoDocPago.class);
        tS.insert(t);
    }
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @GetMapping
    public List<TipoDocPagoDTO> listar(){
        return tS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,TipoDocPagoDTO.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")Integer id){
        tS.delete(id);
    }
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @PutMapping
    public void modificar(@RequestBody TipoDocPagoDTO dto){
        ModelMapper m=new ModelMapper();
        TipoDocPago t=m.map(dto,TipoDocPago.class);
        tS.insert(t);
    }
}
