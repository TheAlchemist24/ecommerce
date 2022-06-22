package com.azienda.ecommerce.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ecommerce");
		EntityManager em = emf.createEntityManager();
		

	}

}
