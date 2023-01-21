package com.example.demo.redis;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.Id;
import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@RedisHash("Person")
public class Person implements Serializable
{
	
	private String vorname;
	private String nachname;
	private String alter;
	@Id
	@Indexed
	private String id;

	public void setId(String id)
	{
		this.id = id;
	}

	public String getId()
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

	public String getAlter()
	{
		return alter;
	}

	public void setAlter(String alter)
	{
		this.alter = alter;
	}
}
