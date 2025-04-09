package mx.unam.dgtic.libreria_rest.repositories;

import mx.unam.dgtic.libreria_rest.models.Clasificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClasificacionRepository extends JpaRepository<Clasificacion, Integer> {
}
