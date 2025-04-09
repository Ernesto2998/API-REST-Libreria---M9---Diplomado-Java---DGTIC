package mx.unam.dgtic.libreria_rest.services.v2;

import mx.unam.dgtic.libreria_rest.dtos.ClasificacionDto;
import mx.unam.dgtic.libreria_rest.exceptions.NoExisteClasificacionException;
import mx.unam.dgtic.libreria_rest.models.Clasificacion;
import mx.unam.dgtic.libreria_rest.repositories.ClasificacionRepository;
import mx.unam.dgtic.libreria_rest.services.v2.interfaces.ClasificacionDtoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClasificacionDtoServiceImpl implements ClasificacionDtoService {

    @Autowired
    private ClasificacionRepository clasificacionRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ClasificacionDto> findAllClasificaciones() {
        return clasificacionRepository.findAll().stream()
                .map(this::converToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClasificacionDto findById(Integer id) {
        Clasificacion clasificacion = clasificacionRepository.findById(id)
                .orElseThrow(
                        () -> new NoExisteClasificacionException("Clasificación DTO no encontrada - Find by id", id)
                );
        return converToDto(clasificacion);
    }

    @Override
    public ClasificacionDto saveClasificacion(ClasificacionDto clasificacionDto) {
        Clasificacion clasificacion = convertToEntity(clasificacionDto);
        Clasificacion clasificacionSaved = clasificacionRepository.save(clasificacion);
        return converToDto(clasificacionSaved);
    }

    @Override
    public ClasificacionDto updateClasificacion(Integer id, ClasificacionDto clasificacionDto) {
        Clasificacion clasificacionExistente = clasificacionRepository.findById(id)
                .orElseThrow(
                        () -> new NoExisteClasificacionException("Clasificación DTO no encontrada - UPDATE", id)
                );
        updateClasificacionFromDto(clasificacionDto, clasificacionExistente);
        return converToDto(clasificacionRepository.save(clasificacionExistente));
    }

    @Override
    public ClasificacionDto deleteClasificacion(Integer id) {
        Clasificacion clasificacion = clasificacionRepository.findById(id)
                .orElseThrow(
                        () -> new NoExisteClasificacionException("Clasificación DTO no encontrada - DELETE", id)
                );
        clasificacionRepository.deleteById(id);
        return converToDto(clasificacion);
    }



    private ClasificacionDto converToDto(Clasificacion clasificacion){
        return modelMapper.map(clasificacion, ClasificacionDto.class);
    }

    private Clasificacion convertToEntity(ClasificacionDto clasificacionDto){
        return modelMapper.map(clasificacionDto, Clasificacion.class);
    }

    private void updateClasificacionFromDto(ClasificacionDto clasificacionDto, Clasificacion clasificacion){
        clasificacion.setTipoClasificacion(clasificacionDto.getTipoClasificacion());
    }
}
