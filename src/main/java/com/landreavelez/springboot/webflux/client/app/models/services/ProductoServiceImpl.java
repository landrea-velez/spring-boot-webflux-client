package com.landreavelez.springboot.webflux.client.app.models.services;

import org.springframework.http.codec.multipart.FilePart;

import org.springframework.stereotype.Service;

import com.landreavelez.springboot.webflux.client.app.models.Producto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Override
	public Flux<Producto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Producto> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Producto> save(Producto producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Producto> update(Producto producto, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Producto> upload(FilePart file, String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
