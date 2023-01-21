package com.example.demo.mysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity(name = "person")
public class Person
{
	private String vorname;
	private String nachname;
	private Integer age;
	@Id
	@GeneratedValue
	private Long id;

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getId()
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
