package pe.edu.upc.aaw.behappycommunity.repositories;

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


}
