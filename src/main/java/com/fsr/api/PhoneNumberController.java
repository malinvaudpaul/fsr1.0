package com.fsr.api;

import com.fsr.daos.DAOPhoneNumber;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path = "/phoneNumbers")
public class phoneNumberController {

  @Autowired private DAOPhoneNumber phoneNumberDao;

  @GetMapping(path = "/", produces = "application/json")
  public phoneNumbers getphoneNumbers() {
    return phoneNumberDao.getAllphoneNumbers();
  }

  @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Object> addphoneNumber(@RequestBody phoneNumber phoneNumber) {
    Integer id = phoneNumberDao.getAllphoneNumbers().getphoneNumberList().size() + 1;

    phoneNumber.setId(id);

    phoneNumberDao.addphoneNumber(phoneNumber);

    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(phoneNumber.getId())
            .toUri();

    return ResponseEntity.created(location).build();
  }
}
