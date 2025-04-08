package mx.unam.dgtic.libreria_rest.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NacionalidadDto {

    private Integer id;

    @NotNull(message = "El nombre debe de proporcionarse")
    @NotBlank(message = "El campo nacionalidad no puede estar vacío")
    @Column(nullable = false, name = "nacionalidad")
    private String nacionalidadName;
}
