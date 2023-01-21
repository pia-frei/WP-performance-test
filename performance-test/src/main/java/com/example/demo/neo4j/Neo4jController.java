package com.example.demo.neo4j;

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
@RequestMapping(path = "/neo4j")
public class Neo4jController
{
	@Resource
	Neo4JPersonRepository repo;

	@GetMapping
	public List<Person> getAllPersons(){
		return (List<Person>) repo.findAll();
	}

	@GetMapping("/by")
	public List<Person> findByNachname(@RequestParam(name = "nachname") String nachname){
		return repo.findByNachname(nachname);
	}

	@GetMapping("/{id}")
	public Optional<Person> findById(@PathVariable Long id){
		return repo.findById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id){
		repo.deleteById(id);
	}

	@PostMapping
	public Long createPerson(@RequestBody Person person){
		repo.save(person);
		return person.getId();
	}

	@PostMapping(path = "/all")
	public void createListOfPersons(@RequestBody List<Person> person){
		repo.saveAll(person);
	}

	@PutMapping(path = "/{personId}")
	public void updatePerson(@PathVariable Long personId, @RequestBody Person person){
		person.setId(personId);
		repo.save(person);
	}
}
