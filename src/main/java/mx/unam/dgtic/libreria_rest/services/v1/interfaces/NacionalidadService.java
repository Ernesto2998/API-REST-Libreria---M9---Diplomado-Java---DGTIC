package mx.unam.dgtic.libreria_rest.services.v1.interfaces;

import mx.unam.dgtic.libreria_rest.models.Nacionalidad;

import java.util.List;

public interface NacionalidadService {
    public abstract List<Nacionalidad> findAllNacionalidades();
    public abstract Nacionalidad findById(Integer id);
    public abstract Nacionalidad saveNacionalidad(Nacionalidad nacionalidad);
    public abstract Nacionalidad updateNacionalidad(Integer id, Nacionalidad nacionalidad);
    public abstract Nacionalidad deleteNacionalidad(Integer id);
}
