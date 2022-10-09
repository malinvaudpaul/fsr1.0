package com.fsr.services;

import com.fsr.daos.DAOContactGroup;
import com.fsr.entities.ContactGroup;
import java.util.List;

public class ServiceContactGroup implements IService<ContactGroup> {

  @Override
  public void create(ContactGroup entity) {
    // TODO Auto-generated method stub

  }

  public void create(String fname, String lname, String email) {

    DAOContactGroup daoc = new DAOContactGroup();
    boolean success = daoc.addContactGroup(fname, lname, email);
    if (success) System.out.println("ContactGroup ajout�!");
    else System.out.println("ContactGroup non ajout�!");
  }

  @Override
  public ContactGroup read(int id) {
    DAOContactGroup daoc = new DAOContactGroup();
    return daoc.getContactGroup(id);
  }

  @Override
  public List<ContactGroup> readAll() {
    DAOContactGroup daoc = new DAOContactGroup();
    return daoc.getAllContactGroup();
  }

  public void update(long id, String fname, String lname, String email) {

    DAOContactGroup daoc = new DAOContactGroup();
    boolean ok = daoc.update(id, fname, lname, email);
    if (ok) System.out.println("ContactGroup modifi�!");
    else System.out.println("ContactGroup non modifi�!");
  }

  @Override
  public void delete(int id) {
    DAOContactGroup daoc = new DAOContactGroup();
    boolean success = daoc.delete(id);
    if (!success) System.out.println("ContactGroup non supprim�!");
    else System.out.println("ContactGroup supprim�!");
  }

  @Override
  public void update(int id, ContactGroup entity) {
    // TODO Auto-generated method stub

  }
}
