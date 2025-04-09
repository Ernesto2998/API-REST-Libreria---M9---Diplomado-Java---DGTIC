package mx.unam.dgtic.libreria_rest.services.v2.interfaces;

import mx.unam.dgtic.libreria_rest.dtos.EditorialDto;

import java.util.List;

public interface EditorialDtoService {
    public abstract List<EditorialDto> findAllEditoriales();

    public abstract EditorialDto findById(Integer id);

    public abstract EditorialDto saveEditorial(EditorialDto editorialDto);

    public abstract EditorialDto updateEditorial(Integer id, EditorialDto editorialDto);

    public abstract EditorialDto deleteEditorial(Integer id);
}
