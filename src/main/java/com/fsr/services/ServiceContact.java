package com.fsr.services;

import com.fsr.daos.DAOContact;
import com.fsr.entities.Contact;
import java.util.List;

public class ServiceContact implements IService<Contact> {

  @Override
  public void create(Contact entity) {
    // TODO Auto-generated method stub

  }

  public void create(String fname, String lname, String email) {

    DAOContact daoc = new DAOContact();
    boolean success = daoc.addContact(fname, lname, email);
    if (success) System.out.println("Contact ajout�!");
    else System.out.println("Contact non ajout�!");
  }

  @Override
  public Contact read(int id) {
    DAOContact daoc = new DAOContact();
    return daoc.getContact(id);
  }

  @Override
  public List<Contact> readAll() {
    DAOContact daoc = new DAOContact();
    return daoc.getAllContact();
  }

  public void update(long id, String fname, String lname, String email) {

    DAOContact daoc = new DAOContact();
    boolean ok = daoc.modifyContact(id, fname, lname, email);
    if (ok) System.out.println("Contact modifi�!");
    else System.out.println("Contact non modifi�!");
  }

  @Override
  public void delete(int id) {
    DAOContact daoc = new DAOContact();
    boolean success = daoc.deleteContact(id);
    if (!success) System.out.println("Contact non supprim�!");
    else System.out.println("Contact supprim�!");
  }
}
