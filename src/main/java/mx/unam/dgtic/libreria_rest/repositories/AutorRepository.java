package mx.unam.dgtic.libreria_rest.repositories;

import mx.unam.dgtic.libreria_rest.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
}
