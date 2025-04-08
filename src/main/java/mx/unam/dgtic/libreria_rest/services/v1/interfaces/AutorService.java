package mx.unam.dgtic.libreria_rest.services.v1.interfaces;

import mx.unam.dgtic.libreria_rest.models.Autor;

import java.util.List;

public interface AutorService {
    public abstract List<Autor> findAllAutores();
    public abstract Autor findById(Integer id);
    public abstract Autor saveAutor(Autor autor);
    public abstract Autor updateAutor(Integer id, Autor autor);
    public abstract Autor deleteAutor(Integer id);
}
