package com.lip6.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.lip6.entities.Address;
import com.lip6.entities.PhoneNumber;
import com.lip6.util.JpaUtil;

public class DAOAddress {
	
	public boolean addAddress(String street,String city, String zip, String country) {
		boolean success = false;
		try {
			
				//A vérifier qu'il ne faut pas instancier l'entityManager autre part (il est normalement en singleton)
				//Persistence.createEntityManagerFactory("projetJPA");
				EntityManager em = JpaUtil.getEmf().createEntityManager();
				
				Address a = new Address(street, city, zip, country);
				
				EntityTransaction tx = em.getTransaction();
				tx.begin();
				
				em.persist(a);
				
				tx.commit();
				
				em.close();
				success=true;
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		return success;
	}
	
	public boolean UpdateAddress(int id, String street,String city, String zip, String country) {
		boolean success = false;
			try {
				
					//A vérifier qu'il ne faut pas instancier l'entityManager autre part (il est normalement en singleton)
					//Persistence.createEntityManagerFactory("projetJPA");
					EntityManager em = JpaUtil.getEmf().createEntityManager();
					Address a = em.find(Address.class,id);
					
					EntityTransaction tx = em.getTransaction();
					tx.begin();
					
					em.persist(a);
					a.setCity(city);
					a.setStreet(street);
					a.setZip(zip);
					a.setCountry(country);
					
					tx.commit();
					
					em.close();
					success=true;
				}
			catch(Exception e) {
				e.printStackTrace();
			}
		return success;
	}

}