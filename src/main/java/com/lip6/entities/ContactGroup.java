package com.lip6.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class ContactGroup {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int groupId;
	private String groupName;
	@ManyToMany(cascade=CascadeType.PERSIST)
	private Set<ContactGroup> contactGroups=new HashSet<>();
	
	public ContactGroup(){
	}
}
