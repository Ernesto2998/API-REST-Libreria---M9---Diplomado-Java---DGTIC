package mx.unam.dgtic.libreria_rest.services.v2;

import mx.unam.dgtic.libreria_rest.dtos.LibroDto;
import mx.unam.dgtic.libreria_rest.exceptions.NoExisteAutorException;
import mx.unam.dgtic.libreria_rest.exceptions.NoExisteClasificacionException;
import mx.unam.dgtic.libreria_rest.exceptions.NoExisteEditorialException;
import mx.unam.dgtic.libreria_rest.exceptions.NoExisteLibroException;
import mx.unam.dgtic.libreria_rest.models.Autor;
import mx.unam.dgtic.libreria_rest.models.Clasificacion;
import mx.unam.dgtic.libreria_rest.models.Editorial;
import mx.unam.dgtic.libreria_rest.models.Libro;
import mx.unam.dgtic.libreria_rest.repositories.AutorRepository;
import mx.unam.dgtic.libreria_rest.repositories.ClasificacionRepository;
import mx.unam.dgtic.libreria_rest.repositories.EditorialRepository;
import mx.unam.dgtic.libreria_rest.repositories.LibroRepository;
import mx.unam.dgtic.libreria_rest.services.v2.interfaces.LibroDtoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroDtoServiceImpl implements LibroDtoService {

    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EditorialRepository editorialRepository;
    @Autowired
    private ClasificacionRepository clasificacionRepository;
    @Autowired
    private AutorRepository autorRepository;

    @Override
    public List<LibroDto> findAllLibros() {
        return libroRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public LibroDto findById(Integer id) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(
                        () -> new NoExisteLibroException("Libro DTO no encontrado - Find by id", id)
                );
        return convertToDto(libro);
    }

    @Override
    public LibroDto saveLibro(LibroDto libroDto) {
        Libro libro = convertToEntity(libroDto);
        Libro libroSaved = libroRepository.save(libro);
        return convertToDto(libroSaved);
    }

    @Override
    public LibroDto updateLibro(Integer id, LibroDto libroDto) {
        Libro libroExistente = libroRepository.findById(id)
                .orElseThrow(() -> new NoExisteLibroException("Libro no encontrado", id));

        // Actualizar campos simples
        libroExistente.setTitulo(libroDto.getTitulo());
        libroExistente.setTipoPasta(libroDto.getTipoPasta());
        libroExistente.setSinopsis(libroDto.getSinopsis());
        libroExistente.setPrecio(libroDto.getPrecio());
        libroExistente.setDescuento(libroDto.getDescuento());

        // Actualizar editorial (opcional: validar que exista)
        if (libroDto.getEditorial() != null) {
            Editorial editorial = editorialRepository.findById(libroDto.getEditorial().getId())
                    .orElseThrow(() -> new NoExisteEditorialException("Editorial no encontrada", libroDto.getEditorial().getId()));
            libroExistente.setEditorial(editorial);
        }

        // Actualizar clasificaciones
        if (libroDto.getClasificaciones() != null) {
            List<Clasificacion> clasificaciones = libroDto.getClasificaciones().stream()
                    .map(dto -> clasificacionRepository.findById(dto.getId())
                            .orElseThrow(() -> new NoExisteClasificacionException("Clasificación no encontrada", dto.getId())))
                    .collect(Collectors.toList());
            libroExistente.setClasificaciones(clasificaciones);
        }

        // Actualizar autores
        if (libroDto.getAutores() != null) {
            List<Autor> autores = libroDto.getAutores().stream()
                    .map(dto -> autorRepository.findById(dto.getId())
                            .orElseThrow(() -> new NoExisteAutorException("Autor no encontrado", dto.getId())))
                    .collect(Collectors.toList());
            libroExistente.setAutores(autores);
        }

        // Guardar libro actualizado
        Libro libroActualizado = libroRepository.save(libroExistente);
        return convertToDto(libroActualizado);
    }

    @Override
    public LibroDto deleteLibro(Integer id) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(
                        () -> new NoExisteLibroException("Libro DTO no encontrado - DELETE", id)
                );
        libroRepository.deleteById(id);
        return convertToDto(libro);
    }

    public LibroDto convertToDto(Libro libro) {
        return modelMapper.map(libro, LibroDto.class);
    }

    public Libro convertToEntity(LibroDto dto) {
        return modelMapper.map(dto, Libro.class);
    }
}
