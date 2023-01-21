package com.example.demo.neo4j;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Person
{
	private String vorname;
	private String nachname;
	private String alter;
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

	public String getAlter()
	{
		return alter;
	}

	public void setAlter(String alter)
	{
		this.alter = alter;
	}
}
