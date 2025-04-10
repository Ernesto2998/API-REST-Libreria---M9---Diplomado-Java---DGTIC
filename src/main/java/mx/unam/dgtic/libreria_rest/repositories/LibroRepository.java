package mx.unam.dgtic.libreria_rest.repositories;

import mx.unam.dgtic.libreria_rest.models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Integer> {
}
