package mx.unam.dgtic.libreria_rest.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EditorialDto {

    private Integer id;

    @NotNull(message = "La editorial debe de proporcionarse")
    @NotBlank(message = "La editorial no puede estar vacía")
    private String editorialName;
}
