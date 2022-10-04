package com.lip6.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import com.lip6.entities.Address;
import com.lip6.entities.Contact;
import com.lip6.entities.ContactGroup;
import com.lip6.entities.Messages;
import com.lip6.entities.PhoneNumber;
import com.lip6.util.JpaUtil;

public class DAOContact implements IDAOContact {

	/**
	 * Rajoute un contact dans la base de donnees.
	 * 
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @return renvoit le nouveau contact
	 */

	@Override
	public boolean addContact(String firstname, String lastname, String email) {
		
		boolean success = false;
		try {
			
			
			Persistence.createEntityManagerFactory("projetJPA");
			EntityManager em = JpaUtil.getEmf().createEntityManager();
			
			Contact c1 = new Contact("Xavier", "BLANC", "XavierBlanc@gmail.com");
			Contact c2 = new Contact("Jean", "PIERRE", "JeanPierre@gmail.com");

			PhoneNumber pn1 = new PhoneNumber();
			PhoneNumber pn2 = new PhoneNumber();
			PhoneNumber pn3 = new PhoneNumber();
			Address a1 = new Address();
			Address a2 = new Address();
			
			pn1.setPhoneKind("Samsung");
			pn1.setPhoneNumber("0742652475");
			
			pn2.setPhoneKind("Xiaomi");
			pn2.setPhoneNumber("0643651284");
			
			pn3.setPhoneKind("Apple");
			pn3.setPhoneNumber("0712774511");
			
			a1.setCity("Nanterre");
			a1.setCountry("France");
			a1.setStreet("19 rue des arbres");
			a1.setZip("92000");
			
			a2.setCity("Paris");
			a2.setCountry("France");
			a2.setStreet("5 avenue de l'elite");
			a2.setZip("75000");
			
			a1.setContact(c1);
			c1.setAddress(a1);
			
			a2.setContact(c2);
			c2.setAddress(a2);
			
			pn1.setContact(c1);
			pn2.setContact(c1);
			pn3.setContact(c2);
			
			c1.getPhones().add(pn1);
			c1.getPhones().add(pn2);
			c2.getPhones().add(pn3);
			
			ContactGroup contactgroup = new ContactGroup("my group");
			contactgroup.addContact(c1);
			contactgroup.addContact(c2);
			
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			
			em.persist(c1);
			em.persist(c2);
			
			tx.commit();
			
			//récupérer entité
			Contact c = em.find(Contact.class,(long)1);
			System.out.println(c.getIdContact() + " " + c.getFirstName() + " " + c.getLastName());
			
			//Supprimer une entité
			Contact pASupp = em.find(Contact.class, (long)1);
			em.remove(pASupp);
			Contact pASuppEXCEP = em.find(Contact.class, (long)1);

			
			em.close();
			success = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	/**
	 * Suppresion d'un contact a partir de son identifiant
	 * 
	 * @param id
	 * @return vrai si la suppression a bien ete effectuee
	 */
	@Override
	public int deleteContact(long id) {
		int success = 0;
		Connection con = null;
		try {
			Class.forName(Messages.getString("driver"));
			con = DriverManager.getConnection(Messages.getString("database"), Messages.getString("username"),
					Messages.getString("password"));
			Statement stmt = con.createStatement();
			String request = "DELETE FROM contact WHERE id = " + id;
			success = stmt.executeUpdate(request);
			stmt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return success;
	}

	/**
	 * Recuperation d'un contact a partir de son identifiant
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Contact getContact(long id) {
		ResultSet rec = null;
		Contact contact = null;
		Connection con = null;
		try {
			Class.forName(Messages.getString("driver"));
			con = DriverManager.getConnection(Messages.getString("database"), Messages.getString("username"),
					Messages.getString("password"));
			Statement stmt = con.createStatement();
			rec = stmt.executeQuery("SELECT * FROM contact WHERE id = " + id);

			if (rec.next() == false) {
				System.out.println("ResultSet in empty in Java");
			} else {
				do {
					contact=new Contact();
					contact.setIdContact(Long.parseLong(rec.getString("id")));
					contact.setFirstName(rec.getString("firstname"));
					contact.setLastName(rec.getString("lastname"));
					contact.setEmail(rec.getString("email"));
				} while (rec.next());
			}

			stmt.close();
			rec.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return contact;
	}

	/**
	 * Methode qui modifie les coordonees d'un contact
	 * 
	 * @param id
	 * @param firstname
	 * @param alstname
	 * @param email
	 * @return
	 */
	@Override
	public boolean modifyContact(long id, String firstname, String lastname, String email) {
		boolean success = false;
		Connection con = null;
		try {
			Class.forName(Messages.getString("driver"));
			con = DriverManager.getConnection(Messages.getString("database"), Messages.getString("username"),
					Messages.getString("password"));
			Statement stmt = con.createStatement();
			String sqlFirstName = "UPDATE contact SET firstname = " + "'" + firstname + "'" + " WHERE id = " + id;
			String sqlLastName = "UPDATE contact SET lastname = " + "'" + lastname + "'" + " WHERE id = " + id;
			String sqlEmail = "UPDATE contact SET email = " + "'" + email + "'" + " WHERE id = " + id;

			if (firstname != "")
				stmt.executeUpdate(sqlFirstName);
			if (lastname != "")
				stmt.executeUpdate(sqlLastName);
			if (email != "")
				stmt.executeUpdate(sqlEmail);

			success = true;
			stmt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	/**
	 * Renvoit la liste des contacts correspondant au prenom firrstname
	 * 
	 * @param firstname
	 * @return
	 */
	@Override
	public ArrayList<Contact> getContactByFirstName(String firstname) {

		ArrayList<Contact> contacts = new ArrayList<Contact>();

		ResultSet rec = null;
		Connection con = null;
		try {
			Class.forName(Messages.getString("driver"));
			con = DriverManager.getConnection(Messages.getString("database"), Messages.getString("username"),
					Messages.getString("password"));
			Statement stmt = con.createStatement();
			rec = stmt.executeQuery("SELECT * FROM contact WHERE firstname = " + "'" + firstname + "'");

			while (rec.next()) {
				Contact contact = new Contact();
				contact.setIdContact(Long.parseLong(rec.getString("id")));
				contact.setFirstName(rec.getString("firstname"));
				contact.setLastName(rec.getString("lastname"));
				contact.setEmail(rec.getString("email"));

				contacts.add(contact);
			}

			stmt.close();
			rec.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return contacts;
	}

	/**
	 * Renvoit la liste des contacts correspondant au nom lastname
	 * 
	 * @param lastname
	 * @return
	 */
	@Override
	public ArrayList<Contact> getContactByLastName(String lastname) {

		ArrayList<Contact> contacts = new ArrayList<Contact>();

		ResultSet rec = null;
		Connection con = null;
		try {
			Class.forName(Messages.getString("driver"));
			con = DriverManager.getConnection(Messages.getString("database"), Messages.getString("username"),
					Messages.getString("password"));
			Statement stmt = con.createStatement();
			rec = stmt.executeQuery("SELECT * FROM contact WHERE lastname = " + "'" + lastname + "'");

			while (rec.next()) {
				Contact contact = new Contact();
				contact.setIdContact(Long.parseLong(rec.getString("id")));
				contact.setFirstName(rec.getString("firstname"));
				contact.setLastName(rec.getString("lastname"));
				contact.setEmail(rec.getString("email"));
				contacts.add(contact);
			}

			stmt.close();
			rec.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return contacts;
	}

	/**
	 * Renvoit la liste des contacts correspondant a l'email email
	 * 
	 * @param email
	 * @return
	 */
	@Override
	public ArrayList<Contact> getContactByEmail(String email) {
		ArrayList<Contact> contacts = new ArrayList<Contact>();

		ResultSet rec = null;
		Connection con = null;
		try {
			Class.forName(Messages.getString("driver"));
			con = DriverManager.getConnection(Messages.getString("database"), Messages.getString("username"),
					Messages.getString("password"));
			Statement stmt = con.createStatement();
			rec = stmt.executeQuery("SELECT * FROM contact WHERE email = " + "'" + email + "'");

			while (rec.next()) {
				Contact contact = new Contact();
				contact.setIdContact(Long.parseLong(rec.getString("id")));
				contact.setFirstName(rec.getString("firstname"));
				contact.setLastName(rec.getString("lastname"));
				contact.setEmail(rec.getString("email"));
				contacts.add(contact);
			}

			stmt.close();
			rec.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return contacts;
	}

}
