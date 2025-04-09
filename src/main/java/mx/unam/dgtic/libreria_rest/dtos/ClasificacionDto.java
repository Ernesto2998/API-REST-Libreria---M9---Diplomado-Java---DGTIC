package mx.unam.dgtic.libreria_rest.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ClasificacionDto {

    private Integer id;

    @NotNull(message = "La clasificación debe de proporcionarse")
    @NotBlank(message = "La clasificación no puede estar vacía")
    private String tipoClasificacion;
}
