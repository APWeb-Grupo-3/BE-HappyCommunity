package pe.edu.upc.aaw.behappycommunity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.behappycommunity.entities.Aviso;

import java.util.List;
@Repository
public interface IAvisoRepository extends JpaRepository<Aviso, Integer> {
    //Cantidad de avisos por mes
    //HU31: Visualizar la cantidad de avisos publicados por mes
    /*
    @Query(value ="SELECT\n" +
            " EXTRACT(YEAR FROM fecha_publicacion) AS anio,\n" +
            " CASE EXTRACT(MONTH FROM fecha_publicacion)\n" +
            " WHEN 1 THEN 'Enero'\n" +
            " WHEN 2 THEN 'Febrero'\n" +
            " WHEN 3 THEN 'Marzo'\n" +
            " WHEN 4 THEN 'Abril'\n" +
            " WHEN 5 THEN 'Mayo'\n" +
            " WHEN 6 THEN 'Junio'\n" +
            " WHEN 7 THEN 'Julio'\n" +
            " WHEN 8 THEN 'Agosto'\n" +
            " WHEN 9 THEN 'Setiembre'\n" +
            " WHEN 10 THEN 'Octubre'\n" +
            " WHEN 11 THEN 'Noviembre'\n" +
            " WHEN 12 THEN 'Diciembre'\n" +
            " END AS mes,\n" +
            " \tCOUNT(*) AS cantidad_de_avisos\n" +
            " FROM\n" +
            " aviso\n" +
            " GROUP BY\n" +
            " anio, mes",nativeQuery = true)
    public List<String[]> quantityAnnouncementPerMonth();

     */

    @Query(value="select mes,cantidad_de_avisos\n" +
            " from\n" +
            " (SELECT\n" +
            "  EXTRACT(YEAR FROM fecha_publicacion) AS anio,\n" +
            "  CASE EXTRACT(MONTH FROM fecha_publicacion)\n" +
            "    WHEN 1 THEN 'Enero'\n" +
            "    WHEN 2 THEN 'Febrero'\n" +
            "    WHEN 3 THEN 'Marzo'\n" +
            "    WHEN 4 THEN 'Abril'\n" +
            "    WHEN 5 THEN 'Mayo'\n" +
            "    WHEN 6 THEN 'Junio'\n" +
            "    WHEN 7 THEN 'Julio'\n" +
            "    WHEN 8 THEN 'Agosto'\n" +
            "    WHEN 9 THEN 'Setiembre'\n" +
            "    WHEN 10 THEN 'Octubre'\n" +
            "    WHEN 11 THEN 'Noviembre'\n" +
            "    WHEN 12 THEN 'Diciembre'\n" +
            "  END AS mes,\n" +
            "  COUNT(*) AS cantidad_de_avisos\n" +
            " FROM\n" +
            "  aviso\n" +
            " GROUP BY\n" +
            "  anio, mes\n" +
            " ) reporte\n" +
            " where anio=:anio",nativeQuery = true)
    public List<String[]> quantityAnnouncementPerMonth(@Param("anio") int anio);

    @Query(value = "select *\n" +
            "from aviso\n" +
            "where id_condominio=:id_condominio",nativeQuery = true)
    public List<Aviso>listAvisosByCondominio(@Param("id_condominio")Long id_condominio);
}
