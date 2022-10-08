package com.lip6.api;

import java.net.URI;
import org.springframework.beans
    .factory.annotation.Autowired;
import org.springframework.http
    .ResponseEntity;
import org.springframework.web.bind
    .annotation.GetMapping;
import org.springframework.web.bind
    .annotation.PostMapping;
import org.springframework.web.bind
    .annotation.RequestBody;
import org.springframework.web.bind
    .annotation.RequestMapping;
import org.springframework.web.bind
    .annotation.RestController;
import org.springframework.web.servlet
    .support.ServletUriComponentsBuilder;

import com.lip6.entities.Contact;
import com.lip6.daos.DAOContact;

@RestController
@RequestMapping(path = "/contacts")
public class ContactController {

    @Autowired
    private ContactDAO contactDao;


    @GetMapping(
        path = "/",
        produces = "application/json")

    public Contact getContact()
    {
        return contactDao
            .getAllContact();
    }


    @PostMapping(
        path = "/",
        consumes = "application/json",
        produces = "application/json")

    public ResponseEntity<Object> addContact(
        @RequestBody Contact contact)
    {
        Integer id
            = contactDao
                  .getAllContact()
                  .getContactList()
                  .size()
              + 1;

        contact.setId(id);

        contactDao
            .addContact(contact);

        URI location
            = ServletUriComponentsBuilder
                  .fromCurrentRequest()
                  .path("/{id}")
                  .buildAndExpand(
                      contact.getId())
                  .toUri();

               return ResponseEntity
            .created(location)
            .build();
    }
}
