package com.fsr.api;

import com.fsr.entities.ContactGroup;
import com.fsr.services.ServiceContactGroup;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path = "/contactGroups")
public class ContactGroupController {

  @Autowired private ServiceContactGroup serviceContactGroup;

  // CREATE CONTROLLER
  @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Object> addContactGroup(@RequestBody ContactGroup contactGroup) {
    /*Integer id = serviceContactGroup.readAll().size() + 1;

    contactGroup.setGroupId(id);*/

    serviceContactGroup.create(contactGroup);

    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(contactGroup.getGroupId())
            .toUri();

    return ResponseEntity.created(location).build();
  }

  // READ CONTROLLERS
  @GetMapping(path = "/", produces = "application/json")
  public List<ContactGroup> getContactGroups() {
    return serviceContactGroup.readAll();
  }

  @GetMapping(path = "/{id}", produces = "application/json")
  public ContactGroup getContactGroupById(@PathVariable("id") int id) {
    return serviceContactGroup.read(id);
  }

  // UPDATE CONTROLLER
  @PatchMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Object> updateContactGroup(
      @PathVariable("id") int id, @RequestBody ContactGroup contactGroup) {
    serviceContactGroup.update(id, contactGroup);

    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(contactGroup.getGroupId())
            .toUri();

    return ResponseEntity.created(location).build();
  }

  // DELETE CONTROLLER
  @DeleteMapping(path = "/{id}", produces = "application/json")
  public void deleteContactGroup(@PathVariable("id") int id) {
    serviceContactGroup.delete(id);
  }
}
