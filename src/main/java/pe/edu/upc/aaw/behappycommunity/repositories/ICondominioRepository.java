package pe.edu.upc.aaw.behappycommunity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.behappycommunity.entities.Condominio;

import java.util.List;

@Repository
public interface ICondominioRepository extends JpaRepository<Condominio, Integer> {

    @Query(value = "select \n" +
            " *\n" +
            " from condominio c\n" +
            " where c.administrador=:administrador",nativeQuery = true)
    public List<Condominio>findCondominioAR(@Param("administrador") String administrador);

    @Query(value="select \n" +
            " c.id_condominio,\n" +
            " c.nombre,\n" +
            " c.departamento,\n" +
            " c.distrito,\n" +
            " c.direccion,\n" +
            " c.administrador\n" +
            " from condominio c\n" +
            " inner join solicitud_acceso sa\n" +
            " on sa.id_condominio=c.id_condominio\n" +
            " inner join usuario u\n" +
            " on u.id_usuario=sa.id_usuario\n" +
            " where u.nombre_usuario=:nombre_usuario and sa.estado='Aprobado'",nativeQuery = true)
    public List<Condominio>findCondominioVA(@Param("nombre_usuario") String nombre_usuario);

}