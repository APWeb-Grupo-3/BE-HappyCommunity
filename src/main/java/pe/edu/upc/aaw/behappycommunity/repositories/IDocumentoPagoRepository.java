package pe.edu.upc.aaw.behappycommunity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.behappycommunity.entities.DocumentoPago;

import java.util.List;

@Repository
public interface IDocumentoPagoRepository extends JpaRepository<DocumentoPago,Integer> {
    //HU44	Visualizar el mes con mayor deuda de cada condominio
    @Query(value = "select\n" +
            "    to_char(fecha_vencimeinto, 'Month') as mes,\n" +
            "    sum(case when moneda = 'Dolares' then total * 3.7 else total end) as sumatotal\n" +
            "from\n" +
            "     (\n" +
            "    select\n" +
            "        c.id_condominio,\n" +
            "        s.id_solicitud_acceso,\n" +
            "        u.id_usuario,\n" +
            "        d.id_documento_pago,\n" +
            "        d.fecha_vencimeinto,\n" +
            "        d.total,\n" +
            "        d.estado,\n" +
            "        d.moneda\n" +
            "    from\n" +
            "        condominio c\n" +
            "    inner join\n" +
            "        solicitud_acceso s on c.id_condominio = s.id_condominio\n" +
            "    inner join\n" +
            "        usuario u on s.id_usuario = u.id_usuario\n" +
            "    inner join \n" +
            "        documento_pago d on u.id_usuario = d.id_receptor\n" +
            "    where\n" +
            "        c.id_condominio = :condominio\n" +
            ") as tempo\n" +
            "where\n" +
            "    estado = 'Vencido' and extract(year from fecha_vencimeinto) = extract(year from current_date)\n" +
            "group by\n" +
            "    mes\n" +
            "having\n" +
            "    sum(case when moneda = 'Dolares' then total * 3.7 else total end) = (\n" +
            "        select\n" +
            "            max(max_sumatotal)\n" +
            "        from\n" +
            "            (\n" +
            "                select\n" +
            "                    to_char(fecha_vencimeinto, 'Month') as mes,\n" +
            "                    sum(case when moneda = 'Dolares' then total * 3.7 else total end) as max_sumatotal\n" +
            "                from (\n" +
            "                    select\n" +
            "                        c.id_condominio,\n" +
            "                        s.id_solicitud_acceso,\n" +
            "                        u.id_usuario,\n" +
            "                        d.id_documento_pago,\n" +
            "                        d.fecha_vencimeinto,\n" +
            "                        d.total,\n" +
            "                        d.estado,\n" +
            "                        d.moneda\n" +
            "                    from\n" +
            "                        condominio c\n" +
            "                    inner join\n" +
            "                        solicitud_acceso s on c.id_condominio = s.id_condominio\n" +
            "                    inner join\n" +
            "                        usuario u on s.id_usuario = u.id_usuario\n" +
            "                    inner join \n" +
            "                        documento_pago d on u.id_usuario = d.id_receptor\n" +
            "                    where\n" +
            "                        c.id_condominio = :condominio\n" +
            "                ) as tempo\n" +
            "                where\n" +
            "                    estado = 'Vencido' and extract(year from fecha_vencimeinto) = extract(year from current_date)\n" +
            "                group by\n" +
            "                    mes\n" +
            "            ) as temporal\n" +
            "    );\n", nativeQuery = true)
    List<Object[]> MesMayorDeuda( @Param("condominio")int condominio);


    @Query(value = "SELECT\n" +
            "    TO_CHAR(fecha_vencimeinto, 'Month') AS mes,\n" +
            "    SUM(CASE WHEN moneda = 'Dolares' THEN total * 3.7 ELSE total END) AS sumames\n" +
            "FROM (\n" +
            "    SELECT\n" +
            "        c.id_condominio,\n" +
            "        s.id_solicitud_acceso,\n" +
            "        u.id_usuario,\n" +
            "        d.id_documento_pago,\n" +
            "        d.fecha_vencimeinto,\n" +
            "        d.total,\n" +
            "        d.estado,\n" +
            "        d.moneda\n" +
            "    FROM\n" +
            "        condominio c\n" +
            "    INNER JOIN\n" +
            "        solicitud_acceso s ON c.id_condominio = s.id_condominio\n" +
            "    INNER JOIN\n" +
            "        usuario u ON s.id_usuario = u.id_usuario\n" +
            "    INNER JOIN \n" +
            "        documento_pago d ON u.id_usuario = d.id_receptor\n" +
            "    WHERE\n" +
            "        c.id_condominio = :condominio\n" +
            ") AS tempo\n" +
            "WHERE\n" +
            "    estado = 'Vencido' AND EXTRACT(YEAR FROM fecha_vencimeinto) = EXTRACT(YEAR FROM CURRENT_DATE)\n" +
            "GROUP BY\n" +
            "    mes;", nativeQuery = true)
    List<Object[]>DeudaMes( @Param("condominio")int condominio);

}
