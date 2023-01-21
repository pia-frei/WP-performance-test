package com.example.demo.mysql;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/mysql")
public class MySqlController
{
	@Resource
	MySqlRepository repo;

	@GetMapping
	public List<Person> getAllPerson(){
		return repo.getAll();
	}

	@GetMapping("/{id}")
	public Optional<Person> findById(@PathVariable Long id){
		return repo.getById(id);
	}

	@GetMapping("/by")
	public List<Person> findByNachname(@RequestParam(name = "nachname") String nachname){
		return repo.getByNachname(nachname);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id){
		repo.removeById(id);
	}

	@PostMapping
	public void createPerson(@RequestBody Person person){
		repo.createPerson(person.getVorname(), person.getNachname(), person.getAge());
	}

	@PostMapping(path = "/all")
	public void createListOfPersons(@RequestBody List<Person> person){
		repo.saveAll(person);
	}

	@PutMapping(path = "/{personId}")
	public void updatePerson(@PathVariable Long personId, @RequestBody Person person){
		repo.updatePerson(person.getVorname(), person.getNachname(), person.getAge(), personId);
	}
}
