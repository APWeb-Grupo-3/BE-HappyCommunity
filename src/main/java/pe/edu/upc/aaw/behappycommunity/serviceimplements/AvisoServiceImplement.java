package pe.edu.upc.aaw.behappycommunity.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.behappycommunity.entities.Aviso;
import pe.edu.upc.aaw.behappycommunity.repositories.IAvisoRepository;
import pe.edu.upc.aaw.behappycommunity.serviceinterfaces.IAvisoService;

import java.util.List;
@Service
public class AvisoServiceImplement implements IAvisoService {

    @Autowired
    private IAvisoRepository aR;

    @Override
    public void insert(Aviso aviso) {
        aR.save(aviso);
    }

    @Override
    public List<Aviso> list() {
        return aR.findAll();
    }

    @Override
    public void delete(int idAviso) {
        aR.deleteById(idAviso);
    }

    @Override
    public List<String[]> quantityAnnouncementPerMonth(int anio) {
        return aR.quantityAnnouncementPerMonth(anio);
    }
    @Override
    public Aviso listarId(int idAviso) {
        return aR.findById(idAviso).orElse( new Aviso());
    }

    @Override
    public List<Aviso> listAvisosByCondominio(Long id_condominio) {
        return aR.listAvisosByCondominio(id_condominio);
    }

    @Override
    public List<Aviso> findAvisosR(String nombre_usuario) {
        return aR.findAvisosR(nombre_usuario);
    }
}
