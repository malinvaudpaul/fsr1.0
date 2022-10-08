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

// Import the above-defined classes
// to use the properties of those
// classes
import com.lip6.entities.ContactGroup;
import com.lip6.daos.DAOContatcGroup;;

@RestController
@RequestMapping(path = "/contactGroups")
public class ContactGroupController {

    @Autowired
    private ContactGroupDAO contactGroupDao;


    @GetMapping(
        path = "/",
        produces = "application/json")

    public ContactGroups getContactGroups()
    {
        return contactGroupDao
            .getAllContactGroups();
    }


    @PostMapping(
        path = "/",
        consumes = "application/json",
        produces = "application/json")

    public ResponseEntity<Object> addContactGroup(
        @RequestBody ContactGroup contactGroup)
    {
        Integer id
            = contactGroupDao
                  .getAllContactGroups()
                  .getContactGroupList()
                  .size()
              + 1;

        contactGroup.setId(id);

        contactGroupDao
            .addContactGroup(contactGroup);

        URI location
            = ServletUriComponentsBuilder
                  .fromCurrentRequest()
                  .path("/{id}")
                  .buildAndExpand(
                      contactGroup.getId())
                  .toUri();

               return ResponseEntity
            .created(location)
            .build();
    }
}
