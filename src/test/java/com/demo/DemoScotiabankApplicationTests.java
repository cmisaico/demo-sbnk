package com.demo;

import com.demo.dto.AlumnoRequest;
import com.demo.dto.AlumnoResponse;
import com.demo.dto.Estado;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.List;

@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class DemoScotiabankApplicationTests {

	@Autowired
	private WebTestClient client;

	@Value("${config.base.endpoint}")
	private String url;


	@Test
	@Order(1)
	public void listarActivoTest() {

		AlumnoRequest alumnoRequest = AlumnoRequest.builder().id(2L)
				.nombre("Pablo").apellido("Gonzales Prado").estado(Estado.ACTIVO).edad(21)
				.build();

		client.post().uri(url + "/guardar")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.body(Mono.just(alumnoRequest), AlumnoRequest.class)
				.exchange()
				.expectStatus().isCreated();

		client.get()
				.uri(url + "/listar/ACTIVO")
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.exchange()
				.expectStatus().isOk()
				.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
				.expectBodyList(AlumnoResponse.class)
				.consumeWith(response -> {
					List<AlumnoResponse> productos = response.getResponseBody();
					productos.forEach(p -> {
						System.out.println(p.getNombre());
						System.out.println(p.getApellido());
						System.out.println(p.getEdad());
						System.out.println(p.getEstado());
					});

					Assertions.assertThat(productos.size()>0).isTrue();
				});
	}

	@Test
	@Order(2)
	public void guardarTest() {

		AlumnoRequest alumnoRequest = AlumnoRequest.builder().id(3L)
				.nombre("Pablo").apellido("Gonzales Prado").estado(Estado.ACTIVO).edad(21)
				.build();

		client.post().uri(url + "/guardar")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.body(Mono.just(alumnoRequest), AlumnoRequest.class)
				.exchange()
				.expectStatus().isCreated();
	}

	@Test
	@Order(3)
	public void listarTodoTest() {

		client.get()
				.uri(url + "/listar")
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.exchange()
				.expectStatus().isOk()
				.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
				.expectBodyList(AlumnoResponse.class)
				.consumeWith(response -> {
					List<AlumnoResponse> productos = response.getResponseBody();
					productos.forEach(p -> {
						System.out.println(p.getNombre());
						System.out.println(p.getApellido());
						System.out.println(p.getEdad());
						System.out.println(p.getEstado());
					});

					Assertions.assertThat(productos.size()>0).isTrue();
				});
	}


}
