package com.pizza.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PizzaEndToEndTest {

    @LocalServerPort
    private int port;

    /*@Test
    void getPizzaById() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:" + port + "/pizza/3")).build();

        var response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).join();

        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.body())
                .isEqualTo(
                        "{\"id\":3,\"name\":\"green pizza\",\"ingredient\":\"tomatsås, veg ost, ananas\",\"price\":\"95\"}");
    }

     */

}
