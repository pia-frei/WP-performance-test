package com.example.demo.neo4j;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;



@Component
public interface Neo4JPersonRepository extends Neo4jRepository<Person, Long>
{
	List<Person> findByNachname(@Param("nachname") String nachname);
}
