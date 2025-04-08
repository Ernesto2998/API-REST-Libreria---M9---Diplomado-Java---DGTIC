package mx.unam.dgtic.libreria_rest.services.v2.interfaces;

import mx.unam.dgtic.libreria_rest.dtos.NacionalidadDto;

import java.util.List;

public interface NacionalidadDtoService {
    public abstract List<NacionalidadDto> findAllAlumnos();

    public abstract NacionalidadDto findById(Integer id);

    public abstract NacionalidadDto saveNacionalidad(NacionalidadDto nacionalidadDto);

    public abstract NacionalidadDto updateNacionalidad(Integer id, NacionalidadDto nacionalidadDto);

    public abstract NacionalidadDto deleteNacionalidad(Integer id);
}
