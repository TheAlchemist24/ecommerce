package com.azienda.ecommerce.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.azienda.ecommerce.model.Prodotto;
import com.azienda.ecommerce.model.Utente;

public class ProdottoDaoImpl implements DaoInterface<Prodotto>{
	private EntityManager eManager;
	
	public ProdottoDaoImpl(EntityManager eManager) {
		this.eManager = eManager;
	}

	@Override
	public Prodotto create(Prodotto obj) {
		eManager.persist(obj);
		return obj;
	}
	
	@Override 
	public List<Prodotto> retrive(){
		return eManager.createQuery("SELECT p FROM Prodotto p", Prodotto.class).getResultList();
	}

	@Override 
	public Prodotto update(Prodotto obj) {
		eManager.persist(obj);
		return obj;
	}

	@Override
	public void delete(Prodotto obj) {
		eManager.remove(obj);
	}
	/*		
		
		una ricerca per nome di tipo like e per prezzo minore di

	 * */
	public Prodotto findById(Integer id) {
		return eManager.createQuery("select p form Prodotto p where p.id =:parid", Prodotto.class)
				.setParameter("parid",id).getSingleResult();
	}
	
	//una ricerca per nome di tipo like
	public List<Prodotto> findByNomeLike(String nome) {//chiedere
		return eManager.createQuery("select p form Prodotto p where p.nome like %:parnome% ", Prodotto.class)
				.setParameter("parnome",nome)
			.getResultList();
	}
	//una ricerca per nome esatto
	public Prodotto findByNome(String nome) {
		return eManager.createQuery("select p form Prodotto p where p.nome=:parnome", Prodotto.class)
				.setParameter("parnome",nome)
			.getSingleResult();
	}
	//una ricerca per prezzo minore di 
	public List<Prodotto> findByPrezzoMax(Float prezzo) {//chiedere
		return eManager.createQuery("select p form Prodotto p where p.prezzo > :parprezzo ", Prodotto.class)
				.setParameter("parprezzo",prezzo)
			.getResultList();
	}
	
}
