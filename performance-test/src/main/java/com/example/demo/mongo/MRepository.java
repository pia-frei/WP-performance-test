package com.example.demo.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;


@Component
public interface MRepository extends MongoRepository<Person, BigInteger>
{
	List<Person> findPersonByNachname(String nachname);
}
