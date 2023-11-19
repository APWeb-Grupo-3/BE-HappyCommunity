package pe.edu.upc.aaw.behappycommunity.repositories;

import org.hibernate.annotations.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.aaw.behappycommunity.entities.Usuario;

import java.util.List;


@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Long> {
    public Usuario findByNombreUsuario(String nombreUsuario);

    //BUSCAR POR NOMBRE
    @Query("select count(u.nombreUsuario) from Usuario u where u.nombreUsuario =:nombreUsuario")
    public int buscarUsername(@Param("nombreUsuario") String nombre);


    //INSERTAR ROLES
    @Transactional
    @Modifying
    @Query(value = "insert into roles (rol, usuario_id) VALUES (:rol, :usuario_id)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("usuario_id") Long usuario_id);



    //HU30: Visualizar vecinos con pagos al día
    @Query(value="SELECT \n" +
            "   distinct(m.id_usuario),\n" +
            "   m.apellidos,\n" +
            "   m.nombres,\n" +
            "   m.nombre_usuario\n" +
            " FROM\n" +
            "   (\n" +
            "     SELECT \n" +
            "       u.*\n" +
            "     FROM \n" +
            "       usuario u\n" +
            "       INNER JOIN solicitud_acceso sa ON u.id_usuario = sa.id_usuario\n" +
            "       INNER JOIN condominio c ON c.id_condominio = sa.id_condominio\n" +
            "     WHERE \n" +
            "       sa.estado = 'Aprobado'\n" +
            "       AND c.administrador = :administrador\n" +
            "   ) AS m\n" +
            " inner join documento_pago dp\n" +
            " on dp.id_receptor=m.id_usuario\n" +
            " where m.id_usuario not in (\n" +
            " \tSELECT\n" +
            "       dp.id_receptor\n" +
            "     FROM\n" +
            "       documento_pago dp\n" +
            "     WHERE\n" +
            "       dp.estado = 'Vencido' or dp.estado='Pendiente'\n" +
            " )",nativeQuery = true)
    public List<String[]> findVecinosWithoutDebt(@Param("administrador")String administrador);

    @Query(value ="SELECT apellidos, nombres, CASE\n" +
            " WHEN estado = 'Deuda' THEN 'Vecino con deuda'\n" +
            " END AS \"Estado\" FROM\n" +
            " (\n" +
            " SELECT DISTINCT u.id_usuario,u.apellidos,\n" +
            " u.nombres,dp.estado\n" +
            " FROM documento_pago dp\n" +
            " INNER JOIN usuario u\n" +
            " ON dp.id_receptor = u.id_usuario\n" +
            " WHERE dp.estado = 'Deuda'\n" +
            " ) AS Tabla ", nativeQuery = true)
    public List<String[]>findVecinosWithDebt();

    @Query(value = "select * \n" +
            " from usuario\n" +
            " where nombre_usuario=:nombre_usuario",nativeQuery = true)
    public List<Usuario> findUser(@Param("nombre_usuario") String nombre_usuario);


    @Query(value="select \n" +
            " u.id_usuario,\n" +
            " u.nombre_usuario,\n" +
            " u.clave,\n" +
            " u.habilitado,\n" +
            " u.id_rol_usuario,\n" +
            " u.nombres,\n" +
            " u.apellidos,\n" +
            " u.correo,\n" +
            " u.edad,\n" +
            " u.telefono,\n" +
            " u.genero\n" +
            " from usuario u\n" +
            " inner join solicitud_acceso sa\n" +
            " on sa.id_usuario=u.id_usuario\n" +
            " where sa.id_condominio=:id_condominio and sa.estado='Aprobado'",nativeQuery = true)
    public List<Usuario>findUsersC(@Param("id_condominio") Long id_condominio);


}
