package com.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@AutoConfigureWebTestClient
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class DemoScotiabankApplicationTests {

	@Autowired
	private WebTestClient client;

	@Value("${config.base.endpoint}")
	private String url;

	@Test
	public void listarTest() {
//
//		client.get()
//				.uri(url)
//				.accept(MediaType.APPLICATION_JSON_UTF8)
//				.exchange()
//				.expectStatus().isOk()
//				.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
//				.expectBodyList(Producto.class)
//				.consumeWith(response -> {
//					List<Producto> productos = response.getResponseBody();
//					productos.forEach(p -> {
//						System.out.println(p.getNombre());
//					});
//
//					Assertions.assertThat(productos.size()>0).isTrue();
//				});
		//.hasSize(9);
	}


}
