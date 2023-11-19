package pe.edu.upc.aaw.behappycommunity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.behappycommunity.entities.SolicitudAcceso;
import pe.edu.upc.aaw.behappycommunity.entities.Usuario;

import java.util.List;

@Repository
public interface ISolicitudAccesoRepository extends JpaRepository<SolicitudAcceso, Integer> {
    @Query(value="select \n" +
            " s.id_solicitud_acceso,\n" +
            " s.estado,\n" +
            " s.id_condominio,\n" +
            " s.id_usuario\n" +
            " from condominio c\n" +
            " inner join solicitud_acceso s\n" +
            " on s.id_condominio=c.id_condominio\n" +
            " inner join usuario u\n" +
            " on u.id_usuario=s.id_usuario\n" +
            " where u.nombre_usuario=:nombre_usuario",nativeQuery = true)
    public List<SolicitudAcceso> findSolicitudVE(@Param("nombre_usuario") String nombre_usuario);


    @Query(value = "select \n" +
            " sa.id_solicitud_acceso,\n" +
            " sa.estado,\n" +
            " sa.id_condominio,\n" +
            " sa.id_usuario\n" +
            " from solicitud_acceso sa\n" +
            " inner join condominio c\n" +
            " on c.id_condominio=sa.id_condominio\n" +
            " where c.administrador=:administrador",nativeQuery = true)
    public List<SolicitudAcceso>findSolicitudAR(@Param("administrador") String administrador);
}
