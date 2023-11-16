package pe.edu.upc.aaw.behappycommunity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.behappycommunity.entities.DocumentoPago;

import java.util.List;

@Repository
public interface IDocumentoPagoRepository extends JpaRepository<DocumentoPago,Integer> {
    //HU44	Visualizar el mes con mayor deuda
    @Query(value = "    select to_char(fecha_vencimeinto, 'Month') as mes, sum(CASE WHEN moneda = 'Dolares' THEN total * 3.7 ELSE total END) as sumatotal\n" +
            "   from documento_pago\n" +
            "   where estado = 'Vencido' and extract(year from fecha_vencimeinto) = extract(year from current_date)\n" +
            "   group by mes\n" +
            "   having sum(CASE WHEN moneda = 'Dolares' THEN total * 3.7 ELSE total END) = (\n" +
            "       select max(max_sumatotal)\n" +
            "       from (\n" +
            "           select to_char(fecha_vencimeinto, 'Month') as mes, sum(CASE WHEN moneda = 'Dolares' THEN total * 3.7 ELSE total END) as max_sumatotal\n" +
            "           from documento_pago\n" +
            "           where estado = 'Vencido' and extract(year from fecha_vencimeinto) = extract(year from current_date)\n" +
            "           group by mes\n" +
            "       ) as temporal\n" +
            "   );\n", nativeQuery = true)
    List<Object[]> MesMayorDeuda();


    @Query(value = "select to_char(fecha_vencimeinto, 'Month')  mes, sum(CASE WHEN moneda = 'Dolares' THEN total * 3.7 ELSE total END)  sumames\n" +
            "        from documento_pago\n" +
            "        where estado = 'Vencido' and extract(year from fecha_vencimeinto) = extract(year from current_date)\n" +
            "        group by mes", nativeQuery = true)
    List<Object[]>DeudaMes();

}
