package com.example.demo.redis;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface RedisRepository extends CrudRepository<Person, String>
{
	List<Person> findPersonByNachname(String nachname);
}
