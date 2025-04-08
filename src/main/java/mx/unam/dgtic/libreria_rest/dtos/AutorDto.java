package mx.unam.dgtic.libreria_rest.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AutorDto {

    private Integer id;

    @NotNull(message = "El nombre debe de proporcionarse")
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotNull(message = "El nombre debe de proporcionarse")
    @NotBlank(message = "El apellido uno no puede estar vacío")
    private String apellidoUno;

    @NotNull(message = "El nombre debe de proporcionarse")
    @NotBlank(message = "El apellido dos no puede estar vacío")
    private String apellidoDos;

    private Integer nacionalidadId;
    private String nacionalidad;
}
