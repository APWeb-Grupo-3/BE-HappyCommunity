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
    @Query(value="select apellidos,nombres,CASE estado\n" +
            " WHEN 'Pagado' THEN 'Al día'\n" +
            " END as \"Estado\" from\n" +
            " (\n" +
            " select distinct(u.id_usuario),u.apellidos,\n" +
            " u.nombres,\n" +
            " dp.estado\n" +
            " from documento_pago dp\n" +
            " inner join usuario u\n" +
            " on dp.id_receptor=u.id_usuario\n" +
            " where dp.estado='Pagado'\n" +
            " )tabla ",nativeQuery = true)
    public List<String[]> findVecinosWithoutDebt();

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
            "u.id_usuario,\n" +
            "u.nombre_usuario,\n" +
            "u.clave,\n" +
            "u.habilitado,\n" +
            "u.id_rol_usuario,\n" +
            "u.nombres,\n" +
            "u.apellidos,\n" +
            "u.correo,\n" +
            "u.edad,\n" +
            "u.telefono,\n" +
            "u.genero\n" +
            "from usuario u\n" +
            "inner join solicitud_acceso sa\n" +
            "on sa.id_usuario=u.id_usuario\n" +
            "where sa.id_condominio=:id_condominio and sa.estado='Aprobado'",nativeQuery = true)
    public List<Usuario>findUsersC(@Param("id_condominio") Long id_condominio);


}
