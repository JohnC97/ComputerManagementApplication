package com.company.uppgift.rest;

import java.net.URI;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.ServiceUnavailableException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.company.uppgift.dataaccess.IDNotFoundException;
import com.company.uppgift.domain.Computer;
import com.company.uppgift.implementation.ComputerManagementServiceLocal;
import com.company.uppgift.implementation.ComputerNotFoundException;

@Stateless
@Path("/computers")
public class ComputerResource {
	
	@Inject
	public ComputerManagementServiceLocal service;
	
//	@OPTIONS
//	@Path("*")
//	public Response getOptions(@Context HttpHeaders headers) {
//		headers.getAcceptableMediaTypes();
//		return Response.ok()
//				.header("Access-Control-Allow-Methods", "GET,HEAD,PUT,PATCH,POST,DELETE")
//				.header("Access-Control-Allow-Origin", "*")
//				.header("Allow", "GET,HEAD,PUT,PATCH,POST,DELETE")
//				.build();
//	}
	
	
	
	
	@GET
	@Produces("application/JSON")
	public Response getComputersByPriceRange(@DefaultValue ("0") @QueryParam("start") Integer start, @QueryParam("end") Integer end) {
		
		if (start == null || end == null) {
			System.out.println("\n\n\n\tstart is null\n\n\n");
			return Response.ok(service.getAllComputers())
					.header("Access-Control-Allow-Methods", "GET,HEAD,PUT,PATCH,POST,DELETE")
					.header("Access-Control-Allow-Origin", "*")
					.header("Allow", "GET,HEAD,PUT,PATCH,POST,DELETE")
					.build();
		}
		
		if(start != null && end != null) {
			System.out.println("start is not null");
			System.out.println("start: " + start + "\nend: " + end);
			return Response.ok(service.searchByPriceRange(start, end))
					.header("Access-Control-Allow-Methods", "*")
					.header("Access-Control-Allow-Origin", "*")
					.header("Allow", "*")
					.build();
		}
		
		else {
			return Response.status(400).build();
		}
	}
	
	// SEARCH BY ID
	@GET
	@Produces("application/JSON")
	@Path("/id/{computerId}")
	public Response findComputerById(@PathParam("computerId") int id, @Context HttpHeaders headers) {
		try {
			Computer comp = service.searchById(id);
			return Response.ok(comp)
					.header("Access-Control-Allow-Methods", "*")
					.header("Access-Control-Allow-Origin", "*")
					.header("Allow", "*")
					.build();
		} catch (IDNotFoundException e) {
			return Response.status(404).build();
		}
	}
	
	// SEARCH BY computerName
//	@GET
//	@Produces("application/JSON")
//	@Path("/name/{computerName}")
//	public List<Computer> getComputersByName(@PathParam("computerName") String computerName, @Context HttpHeaders headers) {		
//		return service.searchByComputerName(computerName);
//	}
	@GET
	@Produces("application/JSON")
	@Path("/name/{computerName}")
	public Response getComputersByName(@PathParam("computerName") String computerName, @Context HttpHeaders headers) {		
		try {
			return Response.ok(service.searchByComputerName(computerName))
					.header("Access-Control-Allow-Methods", "*")
					.header("Access-Control-Allow-Origin", "*")
					.header("Allow", "*")
					.build();
		} catch (Exception e) {
			return Response.status(404).build();
		}
	}
	
	
	
	@POST
	@Produces("application/JSON")
	@Consumes({"application/JSON", "application/XML"})
	public Response createComputerPost(Computer computer) {
		try{
            service.registerComputer(computer);
            URI uri = null;
            
            try{
            uri = new URI("/computer/1");
            }catch(Exception e){}
            
            return Response.created(uri).build();
        }catch(ServiceUnavailableException e){
            
            return Response.status(503).build();
        }
	}
	
	
	
	//för att ändra värden/namn för en dator
	@PUT
	@Path("{computerNo}")
	@Produces({"application/JSON", "application/XML"})
	@Consumes({"application/JSON"})
	public Response updateComputer(@PathParam("computerNo") int id, Computer c) throws IDNotFoundException {
		try {
			service.updateComputer(id, c.getComputerPrice(), c.getComputerSpec());
			return Response.ok(service.searchById(id)).build();
		} catch (ComputerNotFoundException e1) {
			return Response.status(404).build();
		}
}
	
	

}
