package com.azienda.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Prodotto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private Float prezzo;
	@Column(nullable = false)
	private Integer disponibilita;
	
	@ManyToMany(mappedBy = "prodotti")
	private List<Carrello> carrelli = new ArrayList<Carrello>();
	
	public Prodotto() {
		super();
	}

	public Prodotto(Integer id, String nome, Float prezzo, Integer disponibilita) {
		super();
		this.id = id;
		this.nome = nome;
		this.prezzo = prezzo;
		this.disponibilita = disponibilita;
	}

	public Prodotto(String nome, Float prezzo, Integer disponibilita) {
		super();
		this.nome = nome;
		this.prezzo = prezzo;
		this.disponibilita = disponibilita;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Float prezzo) {
		this.prezzo = prezzo;
	}

	public Integer getDisponibilita() {
		return disponibilita;
	}

	public void setDisponibilita(Integer disponibilita) {
		this.disponibilita = disponibilita;
	}

	@Override
	public String toString() {
		return "Prodotto [id=" + id + ", nome=" + nome + ", prezzo=" + prezzo + ", disponibilita=" + disponibilita
				+ "]";
	}
	
	
}
