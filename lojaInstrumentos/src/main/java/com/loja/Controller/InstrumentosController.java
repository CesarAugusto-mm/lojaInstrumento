package com.loja.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja.model.Instrumentos;
import com.loja.repository.InstrumentoRepository;


@RestController
@RequestMapping("/Instrumentos")
public class InstrumentosController {
	
	
	@Autowired
	private InstrumentoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Instrumentos>> retornandoString() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Instrumentos> getBild(@PathVariable int id) {
		Optional<Instrumentos> instrumentosExist = repository.findById(id);
		
		if(instrumentosExist.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
		return ResponseEntity.ok(instrumentosExist.get());
	}
	
	@PostMapping
	public ResponseEntity<Instrumentos> post(@RequestBody Instrumentos instrumentos) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(instrumentos));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Instrumentos> put(@RequestBody Instrumentos instrumentos) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(instrumentos));
	}
	
	@DeleteMapping("/{id}")	
	public ResponseEntity<?> delete(@PathVariable int id) {
		repository.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}