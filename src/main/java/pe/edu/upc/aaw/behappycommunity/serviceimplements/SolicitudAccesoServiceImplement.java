package pe.edu.upc.aaw.behappycommunity.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.behappycommunity.entities.SolicitudAcceso;
import pe.edu.upc.aaw.behappycommunity.repositories.ISolicitudAccesoRepository;
import pe.edu.upc.aaw.behappycommunity.serviceinterfaces.ISolicitudAccesoSevice;

import java.util.List;

@Service
public class SolicitudAccesoServiceImplement implements ISolicitudAccesoSevice {
    @Autowired

    private ISolicitudAccesoRepository sR;
    @Override
    public void insert(SolicitudAcceso solicitudAcceso){
        sR.save(solicitudAcceso);
    }
    @Override
    public List<SolicitudAcceso> list(){
        return sR.findAll();
    }

    @Override
    public void delete(int idSolicitudAcceso) {
        sR.deleteById(idSolicitudAcceso);
    }

    @Override
    public SolicitudAcceso listarId(int IdSolicitudAcceso) {
        return sR.findById(IdSolicitudAcceso).orElse(new SolicitudAcceso() );
    }
}
