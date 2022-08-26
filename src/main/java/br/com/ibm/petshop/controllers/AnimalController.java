package br.com.ibm.petshop.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ibm.petshop.dtos.AnimalDto;
import br.com.ibm.petshop.models.Animal;
import br.com.ibm.petshop.repositories.AnimalRepository;

@RestController
@RequestMapping("/animais")
public class AnimalController {

	@Autowired
	private AnimalRepository animalRepository;

	@GetMapping("/all")
	public ResponseEntity<List<Animal>> getAll () {
		return ResponseEntity.ok(animalRepository.findAll());
	}
	
	@PostMapping()
	public ResponseEntity<Object> post(@RequestBody AnimalDto animalDto) {
	var animal = new Animal();
	BeanUtils.copyProperties(animalDto, animal);
	var saveAnimal = animalRepository.save(animal);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveAnimal);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteProdutos(@PathVariable Long id) {
		return animalRepository.findById(id).map(resposta -> {
			animalRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}).orElse(ResponseEntity.notFound().build());

	}
	
	
}
