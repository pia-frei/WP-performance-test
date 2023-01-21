package com.example.demo.cassandra;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/cassandra")
public class CassandraController
{
	@Resource
	CRepository repo;

	@GetMapping
	public List<Person> getAllPerson(){
		return (List<Person>) repo.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Person> findById(@PathVariable BigInteger id){
		return repo.findById(id);
	}

	@GetMapping("/by")
	public List<Person> findByNachname(@RequestParam(name = "nachname") String nachname){
		return repo.findPersonByNachname(nachname);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable BigInteger id){
		repo.deleteById(id);
	}

	@PostMapping
	public BigInteger createPerson(@RequestBody Person person){
		UUID uuid = UUID.randomUUID();
		BigInteger person_id = BigInteger.valueOf(uuid.hashCode());
		person.setPerson_id(person_id);
		repo.insert(person);
		return person_id;
	}

	@PostMapping(path = "/all")
	public void createListOfPersons(@RequestBody List<Person> person){
		repo.insert(person);
	}

	@PutMapping(path = "/{personId}")
	public void updatePerson(@PathVariable BigInteger personId, @RequestBody Person person){
		person.setPerson_id(personId);
		repo.save(person);
	}

	@PatchMapping(path = "/{personId}")
	public void insertPerson(@PathVariable BigInteger personId, @RequestBody Person person){
		person.setPerson_id(personId);
		repo.insert(person);
	}
}
