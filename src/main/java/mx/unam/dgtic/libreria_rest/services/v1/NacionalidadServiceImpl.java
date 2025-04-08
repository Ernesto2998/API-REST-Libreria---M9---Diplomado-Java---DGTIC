package mx.unam.dgtic.libreria_rest.services.v1;

import mx.unam.dgtic.libreria_rest.exceptions.NoExisteNacionalidadException;
import mx.unam.dgtic.libreria_rest.models.Nacionalidad;
import mx.unam.dgtic.libreria_rest.repositories.NacionalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.unam.dgtic.libreria_rest.services.v1.interfaces.NacionalidadService;

import java.util.List;

@Service
public class NacionalidadServiceImpl implements NacionalidadService {
    @Autowired
    private NacionalidadRepository nacionalidadRepository;

    @Override
    public List<Nacionalidad> findAllNacionalidades() {
        return nacionalidadRepository.findAll();
    }

    @Override
    public Nacionalidad findById(Integer id) {
        return nacionalidadRepository.findById(id)
                .orElseThrow(() -> new NoExisteNacionalidadException("No se encontró la nacionalidad en Find by Id", id));
    }

    @Override
    public Nacionalidad saveNacionalidad(Nacionalidad nacionalidad) {
        return nacionalidadRepository.save(nacionalidad);
    }

    @Override
    public Nacionalidad updateNacionalidad(Integer id, Nacionalidad nacionalidad) {
        return nacionalidadRepository.findById(id)
                .map(nacionalidadExistente -> {
                    nacionalidadExistente.setNacionalidadName(nacionalidad.getNacionalidadName());
                    return nacionalidadRepository.save(nacionalidadExistente);
                }).orElseThrow(() -> new NoExisteNacionalidadException("Nacionalidad no encontrada para hacer UPDATE", id));
    }

    @Override
    public Nacionalidad deleteNacionalidad(Integer id) {
        Nacionalidad nacionalidad = nacionalidadRepository.findById(id)
                .orElseThrow(() -> new NoExisteNacionalidadException("Nacionalidad no encontrada en DELETE", id));
        nacionalidadRepository.deleteById(id);
        return nacionalidad;
    }
}
