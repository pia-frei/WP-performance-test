package com.example.demo.mongo;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigInteger;


@Document
public class Person
{
	private String vorname;
	private String nachname;
	private Integer age;
	private BigInteger id;

	public void setId(BigInteger id)
	{
		this.id = id;
	}

	@Id
	@GeneratedValue
	public BigInteger getId()
	{
		return id;
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

	public Integer getAge()
	{
		return age;
	}

	public void setAge(Integer alter)
	{
		this.age = alter;
	}
}
