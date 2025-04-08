package mx.unam.dgtic.libreria_rest.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "nacionalidad")
public class Nacionalidad {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_nacionalidad")
    private Integer id;

    @NotNull(message = "El nombre debe de proporcionarse")
    @NotBlank(message = "El campo nacionalidad no puede estar vacío")
    @Column(nullable = false, name = "nacionalidad")
    private String nacionalidadName;

    @OneToMany(mappedBy = "nacionalidad", fetch = FetchType.LAZY)
//    //@JsonBackReference
//    @JsonManagedReference
    private List<Autor> autores;

}
