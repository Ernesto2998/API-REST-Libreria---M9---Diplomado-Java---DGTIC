package mx.unam.dgtic.libreria_rest.services.v2;

import mx.unam.dgtic.libreria_rest.dtos.EditorialDto;
import mx.unam.dgtic.libreria_rest.exceptions.NoExisteEditorialException;
import mx.unam.dgtic.libreria_rest.models.Editorial;
import mx.unam.dgtic.libreria_rest.repositories.EditorialRepository;
import mx.unam.dgtic.libreria_rest.services.v2.interfaces.EditorialDtoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EditorialDtoServiceImpl implements EditorialDtoService {

    @Autowired
    private EditorialRepository editorialRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<EditorialDto> findAllEditoriales() {
        return editorialRepository.findAll().stream()
                .map(this::converToDto)
                .collect(Collectors.toList());
    }

    @Override
    public EditorialDto findById(Integer id) {
        Editorial editorial = editorialRepository.findById(id)
                .orElseThrow(
                        () -> new NoExisteEditorialException("Editorial DTO no encontrada - Find by id", id)
                );
        return converToDto(editorial);
    }

    @Override
    public EditorialDto saveEditorial(EditorialDto editorialDto) {
        Editorial editorial = convertToEntity(editorialDto);
        Editorial editorialSaved = editorialRepository.save(editorial);
        return converToDto(editorialSaved);
    }

    @Override
    public EditorialDto updateEditorial(Integer id, EditorialDto editorialDto) {
        Editorial editorialExistente = editorialRepository.findById(id)
                .orElseThrow(
                        () -> new NoExisteEditorialException("Editorial DTO no encontrada - UPDATE", id)
                );
        updateEditorialFromDto(editorialDto, editorialExistente);
        return converToDto(editorialRepository.save(editorialExistente));
    }

    @Override
    public EditorialDto deleteEditorial(Integer id) {
        Editorial editorial = editorialRepository.findById(id)
                .orElseThrow(
                        () -> new NoExisteEditorialException("Editorial DTO no encontrada - DELETE", id)
                );
        editorialRepository.deleteById(id);
        return converToDto(editorial);
    }


    private EditorialDto converToDto(Editorial editorial){
        return modelMapper.map(editorial, EditorialDto.class);
    }

    private Editorial convertToEntity(EditorialDto editorialDto){
        return modelMapper.map(editorialDto, Editorial.class);
    }

    private void updateEditorialFromDto(EditorialDto editorialDto, Editorial editorial){
        editorial.setEditorialName(editorialDto.getEditorialName());
    }
}
