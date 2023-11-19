package pe.edu.upc.aaw.behappycommunity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.behappycommunity.entities.DocumentoPago;

import javax.print.Doc;
import java.util.List;

@Repository
public interface IDocumentoPagoRepository extends JpaRepository<DocumentoPago,Integer> {
    //HU44	Visualizar el mes con mayor deuda de cada condominio
    @Query(value = "\n" +
            "SELECT\n" +
            "    MAX(mes) AS mes,\n" +
            "    MAX(sumatotalmes) AS max_sumatotalmes\n" +
            "FROM (\n" +
            "    SELECT\n" +
            "        TO_CHAR(fecha_vencimeinto, 'Month') AS mes,\n" +
            "        SUM(CASE WHEN moneda = 'Dolares' THEN total * 3.7 ELSE total END) AS sumatotalmes\n" +
            "    FROM (\n" +
            "        SELECT\n" +
            "            dp.id_documento_pago,\n" +
            "            dp.id_receptor,\n" +
            "            dp.fecha_emision,\n" +
            "            dp.fecha_vencimeinto, \n" +
            "            dp.moneda,\n" +
            "            SUM(de.subtotal_detalle) AS total,\n" +
            "            dp.estado,\n" +
            "            o.id_usuario,\n" +
            "            dp.id_tipo_doc_pago,\n" +
            "            u.nombre_usuario AS nombre_usuario_receptor,\n" +
            "            o.nombre_usuario AS nombre_usuario_emisor\n" +
            "        FROM\n" +
            "            documento_pago dp\n" +
            "        INNER JOIN\n" +
            "            usuario u ON dp.id_receptor = u.id_usuario\n" +
            "        INNER JOIN\n" +
            "            detalle de ON dp.id_documento_pago = de.id_documento_pago\n" +
            "        INNER JOIN\n" +
            "            usuario o ON dp.id_usuario = o.id_usuario\n" +
            "        WHERE\n" +
            "            o.nombre_usuario = :nombreusuario\n" +
            "        GROUP BY\n" +
            "            dp.id_documento_pago, dp.fecha_emision, dp.fecha_vencimeinto,  \n" +
            "            dp.moneda, dp.estado, o.id_usuario, dp.id_tipo_doc_pago, u.nombre_usuario, o.nombre_usuario\n" +
            "    ) temps\n" +
            "    WHERE\n" +
            "        estado = 'Vencido' AND EXTRACT(YEAR FROM fecha_vencimeinto) = EXTRACT(YEAR FROM CURRENT_DATE)\n" +
            "    GROUP BY\n" +
            "        mes\n" +
            ")temporal;\n", nativeQuery = true)
    List<Object[]> MesMayorDeuda( @Param("nombreusuario") String nombreusuario);


    @Query(value = "SELECT\n" +
            "    TO_CHAR(fecha_vencimeinto, 'Month') AS mes,\n" +
            "    SUM(CASE WHEN moneda = 'Dolares' THEN total * 3.7 ELSE total END) AS sumames\n" +
            "FROM (\n" +
            "    SELECT\n" +
            "        dp.id_documento_pago,\n" +
            "        dp.id_receptor,\n" +
            "        dp.fecha_emision,\n" +
            "        dp.fecha_vencimeinto, \n" +
            "        dp.moneda,\n" +
            "        SUM(de.subtotal_detalle) AS total,\n" +
            "        dp.estado,\n" +
            "        o.id_usuario,\n" +
            "        dp.id_tipo_doc_pago,\n" +
            "        u.nombre_usuario AS nombre_usuario_receptor,\n" +
            "        o.nombre_usuario AS nombre_usuario_emisor\n" +
            "    FROM\n" +
            "        documento_pago dp\n" +
            "    INNER JOIN\n" +
            "        usuario u ON dp.id_receptor = u.id_usuario\n" +
            "    INNER JOIN\n" +
            "        detalle de ON dp.id_documento_pago = de.id_documento_pago\n" +
            "    INNER JOIN\n" +
            "        usuario o ON dp.id_usuario = o.id_usuario\n" +
            "\twhere o.nombre_usuario = :nombreusuario\n" +
            "    GROUP BY\n" +
            "        dp.id_documento_pago, dp.fecha_emision, dp.fecha_vencimeinto,  \n" +
            "        dp.moneda, dp.estado, o.id_usuario, dp.id_tipo_doc_pago, u.nombre_usuario, o.nombre_usuario\n" +
            ") temps\n" +
            "WHERE\n" +
            "    estado = 'Vencido' AND EXTRACT(YEAR FROM fecha_vencimeinto) = EXTRACT(YEAR FROM CURRENT_DATE)\n" +
            "GROUP BY\n" +
            "    mes;\n" +
            "\n", nativeQuery = true)
    List<Object[]>DeudaMes( @Param("nombreusuario") String nombreusuario);



    @Query(value="select\n" +
            " dp.id_documento_pago,\n" +
            " dp.id_receptor,\n" +
            " dp.fecha_emision,\n" +
            " dp.fecha_vencimeinto,\n" +
            " dp.moneda,\n" +
            " sum(de.subtotal_detalle) as total,\n" +
            " dp.estado,\n" +
            " dp.id_usuario,\n" +
            " dp.id_tipo_doc_pago\n" +
            " from documento_pago dp\n" +
            " inner join usuario u\n" +
            " on dp.id_usuario=u.id_usuario\n" +
            " inner join detalle de\n" +
            " on dp.id_documento_pago=de.id_documento_pago\n" +
            " group by dp.id_documento_pago,total,u.nombre_usuario\n" +
            " having u.nombre_usuario=:nombre_usuario\n"+
            " order by dp.id_documento_pago asc\n",nativeQuery = true)
    public List<DocumentoPago>findDocumentoAR(@Param("nombre_usuario") String nombre_usuario);

    @Query(value="select\n" +
            " dp.id_documento_pago,\n" +
            " dp.id_receptor,\n" +
            " dp.fecha_emision,\n" +
            " dp.fecha_vencimeinto,\n" +
            " dp.moneda,\n" +
            " sum(de.subtotal_detalle) as total,\n" +
            " dp.estado,\n" +
            " dp.id_usuario,\n" +
            " dp.id_tipo_doc_pago\n" +
            " from documento_pago dp\n" +
            " inner join usuario u\n" +
            " on dp.id_receptor=u.id_usuario\n" +
            " inner join detalle de\n" +
            " on dp.id_documento_pago=de.id_documento_pago\n" +
            " group by dp.id_documento_pago,total,u.nombre_usuario\n" +
            " having u.nombre_usuario=:nombre_usuario\n" +
            " order by dp.id_documento_pago asc",nativeQuery = true)
    public List<DocumentoPago>findDocumentoR(@Param("nombre_usuario") String nombre_usuario);

    @Query(value="select\n" +
            " dp.id_documento_pago,\n" +
            " dp.id_receptor,\n" +
            " dp.fecha_emision,\n" +
            " dp.fecha_vencimeinto,\n" +
            " dp.moneda,\n" +
            " dp.total,\n" +
            " dp.estado,\n" +
            " dp.id_usuario,\n" +
            " dp.id_tipo_doc_pago\n" +
            " from documento_pago dp\n" +
            " inner join usuario u\n" +
            " on dp.id_usuario=u.id_usuario\n" +
            " where u.nombre_usuario=:nombre_usuario",nativeQuery = true)
    public List<DocumentoPago>findDocumentoRD(@Param("nombre_usuario") String nombre_usuario);
}
