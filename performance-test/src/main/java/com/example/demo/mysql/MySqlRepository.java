package com.example.demo.mysql;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Component
public interface MySqlRepository extends CrudRepository<Person, Long>
{
	@Query(value = "SELECT * FROM person",nativeQuery = true)
	List<Person> getAll();

	@Query(value = "SELECT * FROM person WHERE id = ?1", nativeQuery = true)
	Optional<Person> getById(Long id);

	@Query(value = "SELECT * FROM person WHERE nachname = ?1", nativeQuery = true)
	List<Person> getByNachname(String nachname);

	@Transactional
	@Modifying
	@Query("DELETE FROM person WHERE id = ?1")
	void removeById(Long id);

	@Transactional
	@Modifying
	@Query(value="INSERT INTO person (vorname, nachname, age) VALUES (?1, ?2, ?3)",nativeQuery = true)
	void createPerson(String vorname, String nachname, Integer age);

	@Transactional
	@Modifying
	@Query(value="UPDATE person SET vorname = ?1, nachname=?2, age=?3 WHERE id = ?4",nativeQuery = true)
	void updatePerson(String vorname, String nachname, Integer age, Long id);
}
