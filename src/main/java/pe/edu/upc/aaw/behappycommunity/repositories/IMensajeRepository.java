package pe.edu.upc.aaw.behappycommunity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.behappycommunity.entities.Mensaje;

import java.util.List;

@Repository
public interface IMensajeRepository extends JpaRepository<Mensaje, Integer> {
    @Query(value="select \n" +
            " m.id_mensaje,\n" +
            " m.titulo,\n" +
            " m.descripcion,\n" +
            " m.id_usuario,\n" +
            " m.id_receptor\n" +
            " from mensaje m\n" +
            " inner join usuario u\n" +
            " on m.id_usuario=u.id_usuario\n" +
            " where u.nombre_usuario=:nombre_usuario",nativeQuery = true)
    public List<Mensaje>findMensajeE(@Param("nombre_usuario") String nombre_usuario);

    @Query(value="select\n" +
            " m.id_mensaje,\n" +
            " m.titulo,\n" +
            " m.descripcion,\n" +
            " m.id_usuario,\n" +
            " m.id_receptor\n" +
            " from mensaje m\n" +
            " inner join usuario u\n" +
            " on m.id_receptor=u.id_usuario\n" +
            " where u.nombre_usuario=:nombre_usuario",nativeQuery = true)
    public List<Mensaje>findMensajeR(@Param("nombre_usuario") String nombre_usuario);
}
