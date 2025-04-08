package mx.unam.dgtic.libreria_rest.services.v2;

import mx.unam.dgtic.libreria_rest.dtos.NacionalidadDto;
import mx.unam.dgtic.libreria_rest.exceptions.NoExisteNacionalidadException;
import mx.unam.dgtic.libreria_rest.models.Nacionalidad;
import mx.unam.dgtic.libreria_rest.repositories.NacionalidadRepository;
import mx.unam.dgtic.libreria_rest.services.v2.interfaces.NacionalidadDtoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NacionalidadDtoServiceImpl implements NacionalidadDtoService {

    @Autowired
    private NacionalidadRepository nacionalidadRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<NacionalidadDto> findAllAlumnos() {
        return nacionalidadRepository.findAll().stream()
                .map(this::converToDto)
                .collect(Collectors.toList());
    }

    @Override
    public NacionalidadDto findById(Integer id) {
        Nacionalidad nacionalidad = nacionalidadRepository.findById(id)
                .orElseThrow(
                        () -> new NoExisteNacionalidadException("Nacionalidad DTO no encontrada - Find by id", id)
                );
        return converToDto(nacionalidad);
    }

    @Override
    public NacionalidadDto saveNacionalidad(NacionalidadDto nacionalidadDto) {
        Nacionalidad nacionalidad = convertToEntity(nacionalidadDto);
        Nacionalidad nacionalidadSaved = nacionalidadRepository.save(nacionalidad);
        return converToDto(nacionalidadSaved);
    }

    @Override
    public NacionalidadDto updateNacionalidad(Integer id, NacionalidadDto nacionalidadDto) {
        Nacionalidad nacionalidadExistente = nacionalidadRepository.findById(id)
                .orElseThrow(
                        () -> new NoExisteNacionalidadException("Nacionalidad DTO no encontrada - UPDATE", id)
                );
        updateNacionalidadFromDto(nacionalidadDto, nacionalidadExistente);
        return converToDto(nacionalidadRepository.save(nacionalidadExistente));
    }

    @Override
    public NacionalidadDto deleteNacionalidad(Integer id) {
        Nacionalidad nacionalidad = nacionalidadRepository.findById(id)
                .orElseThrow(
                        () -> new NoExisteNacionalidadException("Nacionalidad DTO no encontrada - DELETE", id)
                );
        nacionalidadRepository.deleteById(id);
        return converToDto(nacionalidad);
    }



    private NacionalidadDto converToDto(Nacionalidad nacionalidad) {
        return modelMapper.map(nacionalidad, NacionalidadDto.class);
    }

    private Nacionalidad convertToEntity(NacionalidadDto nacionalidadDto) {
        return modelMapper.map(nacionalidadDto, Nacionalidad.class);
    }

    private void updateNacionalidadFromDto(NacionalidadDto nacionalidadDto, Nacionalidad nacionalidad) {
        nacionalidad.setNacionalidadName(nacionalidadDto.getNacionalidadName());
    }
}
