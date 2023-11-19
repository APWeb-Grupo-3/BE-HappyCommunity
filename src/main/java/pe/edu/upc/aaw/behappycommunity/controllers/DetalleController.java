package pe.edu.upc.aaw.behappycommunity.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.behappycommunity.dtos.DetalleDTO;
import pe.edu.upc.aaw.behappycommunity.entities.Detalle;
import pe.edu.upc.aaw.behappycommunity.serviceinterfaces.IDetalleService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/detalles")
public class DetalleController {


    @Autowired
    private IDetalleService detR;
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @PostMapping
    public void registrar(@RequestBody DetalleDTO dto) {
        ModelMapper m = new ModelMapper();
        Detalle t = m.map(dto, Detalle.class);
        detR.insert(t);
    }
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @GetMapping
    public List<DetalleDTO> listar() {
        return detR.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DetalleDTO.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        detR.delete(id);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @PutMapping
    public void modificar(@RequestBody DetalleDTO dto) {
        ModelMapper m = new ModelMapper();
        Detalle t = m.map(dto, Detalle.class);
        detR.insert(t);
    }
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @GetMapping("/{id}")
    public DetalleDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        DetalleDTO dto=m.map(detR.listarId(id),DetalleDTO.class);
        return dto;
    }
    @GetMapping("/listarddoc/{id_documento_pago}")
    public List<DetalleDTO> listarDodc(@PathVariable("id_documento_pago") int id_documento_pago) {
        return detR.findDetalleDoc(id_documento_pago).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DetalleDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/listardear/{nombre_usuario}")
    public List<DetalleDTO> listarDodc(@PathVariable("nombre_usuario") String nombre_usuario) {
        return detR.findDetalleAR(nombre_usuario).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DetalleDTO.class);
        }).collect(Collectors.toList());
    }
}