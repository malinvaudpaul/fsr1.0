package com.lip6.api;

import java.net.URI;
import java.util.List;

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

import com.lip6.entities.Address;
import com.lip6.services.ServiceAddress;

@RestController
@RequestMapping(path = "/addresses")
public class AddressController {

    private ServiceAddress serviceAddress;


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

    @GetMapping(
        path = "/{id}",
        produces = "application/json")

    public Address getAddresseById(@PathVariable("id") int id)
    {
        return serviceAddress.read(id);
    }

    @GetMapping(
        path = "/",
        produces = "application/json")

    public List<Address> getAddresses()
    {
        return serviceAddress.readAll();
    }

    @UpdateMapping(
        path = "/{id}",
        consumes = "application/json",
        produces = "application/json")
    
    public Addresss updateAddress(
        @PathVariable("id") int id,
        @RequestBody Address address)
    {
        address.setId(id);
        return serviceAddress.update(address);
    }

    @DeleteMapping(
        path = "/{id}",
        produces = "application/json")

    public void deleteAddress(@PathVariable("id") int id)
    {
        serviceAddress.delete(id);
    }
}
