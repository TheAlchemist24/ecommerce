package com.azienda.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;


@Entity
public class Carrello {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne(mappedBy = "carrello")
	private Utente utente;
	
	
	@ManyToMany
	@JoinTable(
			name = "prodotto_carrello",
			joinColumns = @JoinColumn(name = "id_carrello"),
			inverseJoinColumns = @JoinColumn(name = "id_prodotto"))
	private List<Prodotto> prodotti = new ArrayList<>();

	public Carrello() {}

	public Carrello(Integer id, Utente utente, List<Prodotto> prodotti) {
		super();
		this.id = id;
		this.utente = utente;
		this.prodotti = prodotti;
	}

	public Carrello(Utente utente, List<Prodotto> prodotti) {
		super();
		this.utente = utente;
		this.prodotti = prodotti;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public List<Prodotto> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}

	@Override
	public String toString() {
		return "Carrello [id=" + id + ", utente=" + utente + "]";
	}
	
	
	
	
}
