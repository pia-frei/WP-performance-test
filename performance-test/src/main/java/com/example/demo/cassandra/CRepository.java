package com.example.demo.cassandra;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;


@Component
public interface CRepository extends CassandraRepository<Person, BigInteger>
{
	@AllowFiltering
	List<Person> findPersonByNachname(String nachname);
}
