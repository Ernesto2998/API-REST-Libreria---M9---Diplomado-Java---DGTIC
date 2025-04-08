package mx.unam.dgtic.libreria_rest.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Autor")
public class Autor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_autor")
    private Integer id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El apellido uno no puede estar vacío")
    @Column(name = "apellido_1")
    private String apellidoUno;

    @NotBlank(message = "El apellido dos no puede estar vacío")
    @Column(name = "apellido_2")
    private String apellidoDos;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_nacionalidad")
    //@JsonManagedReference
    ////@JsonBackReference
    private Nacionalidad nacionalidad;

//    @ManyToMany(mappedBy = "autores", fetch = FetchType.LAZY)
//    private List<Libro> libros;

}
