package pe.edu.upc.aaw.behappycommunity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.behappycommunity.entities.Condominio;

@Repository
public interface ICondominioRepository extends JpaRepository<Condominio, Integer> {


}