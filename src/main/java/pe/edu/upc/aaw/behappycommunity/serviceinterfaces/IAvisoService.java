package pe.edu.upc.aaw.behappycommunity.serviceinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.aaw.behappycommunity.entities.Aviso;

import java.util.List;

public interface IAvisoService {

    public void insert(Aviso aviso);
    public List<Aviso> list();
    public void delete(int idAviso);
    public List<String[]> quantityAnnouncementPerMonth(int anio);
    public Aviso listarId(int idAviso);
    public List<Aviso>listAvisosByCondominio(Long id_condominio);

}
