package mx.unam.dgtic.libreria_rest.services.v2.interfaces;

import mx.unam.dgtic.libreria_rest.dtos.LibroDto;

import java.util.List;

public interface LibroDtoService {
    public abstract List<LibroDto> findAllLibros();

    public abstract LibroDto findById(Integer id);

    public abstract LibroDto saveLibro(LibroDto libroDto);

    public abstract LibroDto updateLibro(Integer id, LibroDto libroDto);

    public abstract LibroDto deleteLibro(Integer id);
}
