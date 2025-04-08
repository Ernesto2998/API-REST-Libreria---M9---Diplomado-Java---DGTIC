package mx.unam.dgtic.libreria_rest.services.v2;

import mx.unam.dgtic.libreria_rest.dtos.AutorDto;
import mx.unam.dgtic.libreria_rest.exceptions.NoExisteAutorException;
import mx.unam.dgtic.libreria_rest.models.Autor;
import mx.unam.dgtic.libreria_rest.repositories.AutorRepository;
import mx.unam.dgtic.libreria_rest.repositories.NacionalidadRepository;
import mx.unam.dgtic.libreria_rest.services.v2.interfaces.AutorDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutorDtoServiceImpl implements AutorDtoService {
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private NacionalidadRepository nacionalidadRepository;

    @Override
    public List<AutorDto> findAllAutores() {
        return autorRepository.findAll().stream().map(this::converToDto).collect(Collectors.toList());
    }

    @Override
    public AutorDto findById(Integer id) {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new NoExisteAutorException("Autor no encontrado en Get DTO", id)
        );
        return converToDto(autor);
    }

    @Override
    public AutorDto saveAutor(AutorDto autorDto) {
        Autor autor = convertToEntity(autorDto);
        Autor autorSaved = autorRepository.save(autor);
        return converToDto(autorSaved);
    }

    @Override
    public AutorDto updateAutor(Integer id, AutorDto autorDto) {
        Autor autorExist = autorRepository.findById(id)
                .orElseThrow(() -> new NoExisteAutorException("Autor no encontrado en Update Dto", id));
        updateAutorFromDto(autorDto, autorExist);
        return converToDto(autorRepository.save(autorExist));
    }

    @Override
    public AutorDto deleteAutor(Integer id) {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new NoExisteAutorException("Autor no encontrado en Delete Dto", id));
        autorRepository.deleteById(id);
        return converToDto(autor);
    }



    private AutorDto converToDto(Autor autor) {
        AutorDto autorDto = new AutorDto();
        autorDto.setId(autor.getId());
        autorDto.setNombre(autor.getNombre());
        autorDto.setApellidoUno(autor.getApellidoUno());
        autorDto.setApellidoDos(autor.getApellidoDos());
        autorDto.setNacionalidadId(autor.getNacionalidad().getId());
        autorDto.setNacionalidad(autor.getNacionalidad().getNacionalidadName());
        return autorDto;
    }

    private Autor convertToEntity(AutorDto autorDto) {
        Autor autor = new Autor();
        autor.setId(autorDto.getId());
        autor.setNombre(autorDto.getNombre());
        autor.setApellidoUno(autorDto.getApellidoUno());
        autor.setApellidoDos(autorDto.getApellidoDos());
        autor.setNacionalidad(
                nacionalidadRepository.findById(autorDto.getNacionalidadId())
                        .orElseThrow(
                                () -> new NoExisteAutorException("Autor DTO no encontrado - Convert to Entity", autorDto.getNacionalidadId())
                        )
        );
        return autor;
    }

    private void updateAutorFromDto(AutorDto autorDto, Autor autor) {
        autor.setNombre(autorDto.getNombre());
        autor.setApellidoUno(autorDto.getApellidoUno());
        autor.setApellidoDos(autorDto.getApellidoDos());
        autor.setNacionalidad(
                nacionalidadRepository.findById(autorDto.getNacionalidadId())
                        .orElseThrow(
                                () -> new NoExisteAutorException("Autor DTO no encontrado - Update from DTO", autorDto.getNacionalidadId())
                        )
        );
    }
}
