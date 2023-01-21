package com.example.demo.cassandra;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigInteger;




@Table
public class Person
{
	private String vorname;
	private String nachname;
	private BigInteger age;
	@Id
	@PrimaryKey
	@PrimaryKeyColumn(name = "person_id",type = PrimaryKeyType.PARTITIONED)
	private BigInteger person_id;

	public void setPerson_id(BigInteger person_id)
	{
		this.person_id = person_id;
	}

	public BigInteger getPerson_id()
	{
		return person_id;
	}

	public String getVorname()
	{
		return vorname;
	}

	public void setVorname(String vorname)
	{
		this.vorname = vorname;
	}

	public String getNachname()
	{
		return nachname;
	}

	public void setNachname(String nachname)
	{
		this.nachname = nachname;
	}

	public BigInteger getAge()
	{
		return age;
	}

	public void setAge(BigInteger alter)
	{
		this.age = alter;
	}
}
