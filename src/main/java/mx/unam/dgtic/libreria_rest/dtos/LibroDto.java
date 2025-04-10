package mx.unam.dgtic.libreria_rest.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
public class LibroDto {
    private Integer id;

    @NotNull(message = "El título debe de proporcionarse")
    @NotBlank(message = "El título no puede estar vacío")
    private String titulo;

    @NotNull(message = "El tipo de pasta debe de proporcionarse")
    @NotBlank(message = "El tipo de pasta no puede estar vacío")
    private String tipoPasta;

    @NotNull(message = "La sinopsis debe de proporcionarse")
    @NotBlank(message = "La sinopsis no puede estar vacía")
    private String sinopsis;

    @DecimalMin(value = "0.0", inclusive = false, message = "El precio no puede ser menor de $0.0")
    private Float precio;

    @Min(value = 0, message = "El descuento NO puede ser menor de 0%")
    @Max(value = 100, message = "El descuento NO puede superar el 100%")
    private Integer descuento;

    @NotNull(message = "La editorial debe de proporcionarse")
    private EditorialDto editorial;
    @NotNull(message = "Las clasificaciones deben de proporcionarse")
    private List<ClasificacionDto> clasificaciones;
    @NotNull(message = "Los autores deben de proporcionarse")
    private List<AutorDto> autores;
}
