package com.example.demo.neo4j;


import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;


@Node
public class Movie {

	@Id
	@GeneratedValue
	Long id;

	private String title;

	private int released;

	private String tagline;

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public int getReleased()
	{
		return released;
	}

	public void setReleased(int released)
	{
		this.released = released;
	}

	public String getTagline()
	{
		return tagline;
	}

	public void setTagline(String tagline)
	{
		this.tagline = tagline;
	}

	// standard constructor, getters and setters
}