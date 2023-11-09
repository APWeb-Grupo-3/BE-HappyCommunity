package pe.edu.upc.aaw.behappycommunity.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.behappycommunity.dtos.MensajeDTO;
import pe.edu.upc.aaw.behappycommunity.entities.Mensaje;
import pe.edu.upc.aaw.behappycommunity.serviceinterfaces.IMensajeService;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/mensajes")
public class MensajeController {

    @Autowired
    private IMensajeService mS;

    @PreAuthorize("hasAuthority('ADMINISTRADOR') or hasAuthority('VECINO') or hasAuthority('INVITADO')")
    @PostMapping
    public void registrar(@RequestBody MensajeDTO dto){
        ModelMapper m = new ModelMapper();
        Mensaje e = m.map(dto, Mensaje.class);
        mS.insert(e);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR') or hasAuthority('VECINO') or hasAuthority('INVITADO')")
    @GetMapping
    public List<MensajeDTO> listar(){
        return mS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,MensajeDTO.class);

        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('ADMINISTRADOR') or hasAuthority('VECINO') or hasAuthority('INVITADO')")
    @DeleteMapping("/{id}")
    public  void  eliminar(@PathVariable("id")Integer id){
        mS.delete(id);
    }
    @PreAuthorize("hasAuthority('ADMINISTRADOR') or hasAuthority('VECINO') or hasAuthority('INVITADO')")
    @PutMapping
    public void modificar(@RequestBody MensajeDTO dto) {
        ModelMapper m = new ModelMapper();
        Mensaje e = m.map(dto, Mensaje.class);
        mS.insert(e);
    }
    @PreAuthorize("hasAuthority('ADMINISTRADOR') or hasAuthority('VECINO') or hasAuthority('INVITADO')")

    @GetMapping("/{id}")
    public MensajeDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        MensajeDTO dto=m.map(mS.listarId(id),MensajeDTO.class);
        return dto;
    }


}
