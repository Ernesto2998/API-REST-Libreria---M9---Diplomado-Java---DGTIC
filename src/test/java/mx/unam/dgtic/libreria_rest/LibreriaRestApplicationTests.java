package mx.unam.dgtic.libreria_rest;

import mx.unam.dgtic.libreria_rest.models.Nacionalidad;
import mx.unam.dgtic.libreria_rest.repositories.NacionalidadRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LibreriaRestApplicationTests {


	@Autowired
	NacionalidadRepository nacionalidadRepository;

	@Test
	void findAllNacionalidadesTest() {
		List<Nacionalidad> nacionalidades = nacionalidadRepository.findAll();
		nacionalidades.forEach(System.out::println);
	}

}
