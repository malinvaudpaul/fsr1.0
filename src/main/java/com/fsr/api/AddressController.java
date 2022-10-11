package com.fsr.api;

import com.fsr.entities.Address;
import com.fsr.services.ServiceAddress;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

@Path("/adresses")
public class AddressController {

  private ServiceAddress serviceAddress;

  @Context UriInfo uriInfo;

  @Context Request request;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  public void createAdress(Address address) {
    serviceAddress.create(address);
  }

  // Return the list of Articles to the user in the browser
  @GET
  @Produces(MediaType.TEXT_XML)
  public List<Address> getAdressesBrowser() {
    return serviceAddress.readAll();
  }

  // Return the list of Articles for applications
  @GET
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public List<Address> getAdresses() {
    return serviceAddress.readAll();
  }

  @Path("{article}")
  public Address getAddress(@PathParam("article") int id) {
    return serviceAddress.read(id);
  }
}
