package mx.unam.dgtic.libreria_rest.services.v2.interfaces;

import mx.unam.dgtic.libreria_rest.dtos.ClasificacionDto;

import java.util.List;

public interface ClasificacionDtoService {
    public abstract List<ClasificacionDto> findAllClasificaciones();

    public abstract ClasificacionDto findById(Integer id);

    public abstract ClasificacionDto saveClasificacion(ClasificacionDto clasificacionDto);

    public abstract ClasificacionDto updateClasificacion(Integer id, ClasificacionDto clasificacionDto);

    public abstract ClasificacionDto deleteClasificacion(Integer id);
}
