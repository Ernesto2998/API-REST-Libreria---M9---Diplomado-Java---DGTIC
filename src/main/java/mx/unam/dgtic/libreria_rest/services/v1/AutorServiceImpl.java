package mx.unam.dgtic.libreria_rest.services.v1;

import mx.unam.dgtic.libreria_rest.models.Autor;
import mx.unam.dgtic.libreria_rest.repositories.AutorRepository;
import mx.unam.dgtic.libreria_rest.services.v1.interfaces.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public List<Autor> findAllAutores() {
        return autorRepository.findAll();
    }

    @Override
    public Autor findById(Integer id) {
        return autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor no encontrado en Find by ID"));
    }

    @Override
    public Autor saveAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public Autor updateAutor(Integer id, Autor autor) {
        return autorRepository.findById(id)
                .map(autorExistente -> {
                    autorExistente.setNombre(autor.getNombre());
                    autorExistente.setApellidoUno(autor.getApellidoUno());
                    autorExistente.setApellidoDos(autor.getApellidoDos());
                    autorExistente.setNacionalidad(autor.getNacionalidad());
                    return autorRepository.save(autorExistente);
                }).orElseThrow(() -> new RuntimeException("Autor con encontrado en el UPDATE con ID: " + id));
    }

    @Override
    public Autor deleteAutor(Integer id) {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("El Autor no se encuentra en el DELETE"));
        autorRepository.deleteById(id);
        return autor;
    }
}
