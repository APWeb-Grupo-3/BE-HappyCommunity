package pe.edu.upc.aaw.behappycommunity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.behappycommunity.entities.Servicio;

@Repository
public interface IServicioRepository extends JpaRepository<Servicio, Integer> {






}
