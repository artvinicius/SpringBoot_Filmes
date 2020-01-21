package com.arthurvinicius.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Filme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomefilme;

	
	@JsonManagedReference
	@ManyToMany(mappedBy = "filmes")
	private List<SalaCinema> filmes = new ArrayList<>();
	
	public Filme() {

	}

	public Filme(Integer id, String nomefilme) {
		super();
		this.id = id;
		this.nomefilme = nomefilme;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomefilme() {
		return nomefilme;
	}

	public void setNomefilme(String nomefilme) {
		this.nomefilme = nomefilme;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public List<SalaCinema> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<SalaCinema> filmes) {
		this.filmes = filmes;
	}
}
