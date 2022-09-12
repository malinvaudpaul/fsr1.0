package com.lip6.services;

import com.lip6.daos.DAOContact;
import com.lip6.daos.IDAOContact;
import com.lip6.entities.Contact;

public class ServiceContact {
	
	public void createContact(String fname, String lname, String email) {
		
		IDAOContact daoc=new DAOContact();
		boolean success = daoc.addContact(fname, lname, email);
		if (success) 
			System.out.println("Contact ajouté!");
		
		else 
			System.out.println("Contact non ajouté!");
		}
	
	public void deleteContact(long id) {
		
		IDAOContact daoc=new DAOContact();
		int success=daoc.deleteContact(id);
		if (success == 0)
			System.out.println("Contact non supprimé!");
		else
			System.out.println("Contact supprimé!");
		
	}
	
	public void modifyContact(long id, String fname, String lname, String email) {
		
		IDAOContact daoc=new DAOContact();
		boolean ok=daoc.modifyContact(id, fname, lname, email);
		if (ok)
			System.out.println("Contact modifié!");
		else
			System.out.println("Contact non modifié!");
		
	}
	
	public void getContact(long id) {
		
		IDAOContact daoc=new DAOContact();
	    Contact c = daoc.getContact(id);
	    System.out.println(c.getIdContact() + c.getFirstName() + c.getLastName() + c.getEmail());
	    
	}

}
