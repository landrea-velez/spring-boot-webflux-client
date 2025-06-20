package com.landreavelez.springboot.webflux.client.app.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.landreavelez.springboot.webflux.client.app.models.Producto;
import com.landreavelez.springboot.webflux.client.app.models.services.ProductoService;

import reactor.core.publisher.Mono;

@Component
public class ProductoHandler {
	
	@Autowired
	private ProductoService service;

	public Mono<ServerResponse> listar(ServerRequest request){
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(service.findAll(), Producto.class);
	}
	
	public Mono<ServerResponse> ver(ServerRequest request){
		String id = request.pathVariable("id");
		
		return service.findById(id).flatMap(p -> ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.bodyValue(p))
				.switchIfEmpty(ServerResponse.notFound().build())
				.onErrorResume(error -> {
					WebClientResponseException responseError = (WebClientResponseException) error;
					if(responseError.getStatusCode() == HttpStatus.NOT_FOUND) {
						return ServerResponse.notFound().build();
					}
					return Mono.error(responseError);
				});
	}

}
