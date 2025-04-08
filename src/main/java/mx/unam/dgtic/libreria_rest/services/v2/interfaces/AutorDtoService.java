package mx.unam.dgtic.libreria_rest.services.v2.interfaces;

import mx.unam.dgtic.libreria_rest.dtos.AutorDto;

import java.util.List;

public interface AutorDtoService {

    public abstract List<AutorDto> findAllAutores();

    public abstract AutorDto findById(Integer id);

    public abstract AutorDto saveAutor(AutorDto autorDto);

    public abstract AutorDto updateAutor(Integer id, AutorDto autorDto);

    public abstract AutorDto deleteAutor(Integer id);
}
