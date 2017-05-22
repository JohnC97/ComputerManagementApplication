package com.company.uppgift.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.company.uppgift.dataaccess.IDNotFoundException;
import com.company.uppgift.domain.Computer;
import com.company.uppgift.implementation.ComputerManagementServiceLocal;

@Stateless
@Path("/computers")
public class ComputerResource {
	
	@Inject
	public ComputerManagementServiceLocal service;
	
	
	
//	// ALL COMPUTERS
//	@GET
//	@Produces("application/JSON")
//	public List<Computer> getAllComputers() {
//		return service.getAllComputers();
//	}
	
	// ALL COMPUTERS or Price Range
	@GET
	@Produces("application/JSON")
	public Response getComputersByPriceRange(@DefaultValue ("0") @QueryParam("start") Integer start, @QueryParam("end") Integer end) {
		
		if (start == null || end == null){
			return Response.ok(service.getAllComputers()).build();
		}
		
		if(start != null && end != null){
			return Response.ok(service.searchByPriceRange(start, end)).build();
		}
		
		else{
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
			return Response.ok(comp).build();
		} catch (IDNotFoundException e) {
			return Response.status(404).build();
		}
	}
	
	// SEARCH BY computerName
	@GET
	@Produces("application/JSON")
	@Path("/name/{computerName}")
	public List<Computer> getComputersByName(@PathParam("computerName") String computerName, @Context HttpHeaders headers) {		
		return service.searchByComputerName(computerName);
	}
	
	
	
	@POST
	@Produces("application/JSON")
	@Consumes({"application/JSON", "application/XML"})
	public Response createComputerPost(Computer computer) {
		return null;
	}

}
