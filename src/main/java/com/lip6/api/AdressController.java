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
import com.lip6.entities.Address;
import com.lip6.services.ServiceAddress;

@RestController
@RequestMapping(path = "/addresses")
public class AddressController {

    private ServiceAddress serviceAddress;


    @GetMapping(
        path = "/",
        produces = "application/json")

    public Addresss getAddresses()
    {
        return serviceAddress.readAll();
    }


    @PostMapping(
        path = "/",
        consumes = "application/json",
        produces = "application/json")

    public ResponseEntity<Object> addAddress(
        @RequestBody Address address)
    {
        Integer id
            = addressDao
                  .getAllAddresss()
                  .getAddressList()
                  .size()
              + 1;

        address.setId(id);

        addressDao
            .addAddress(address);

        URI location
            = ServletUriComponentsBuilder
                  .fromCurrentRequest()
                  .path("/{id}")
                  .buildAndExpand(
                      address.getId())
                  .toUri();

               return ResponseEntity
            .created(location)
            .build();
    }
}
