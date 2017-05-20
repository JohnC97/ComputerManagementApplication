package com.company.uppgift.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
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
	ComputerManagementServiceLocal service;
	
	
	
	// ALL COMPUTERS
	@GET
	@Produces("application/JSON")
	@Path("{all}")
	public List<Computer> getAllComputers() {
		return service.getAllComputers();
	}
	
	// SEARCH BY ID
	@GET
	@Produces("application/JSON")
	@Path("{searchById}")
	public Response findComputerById(@PathParam("computerId") int id, @Context HttpHeaders headers) {
		try {
			Computer comp = service.searchById(id);
			return Response.ok().build();
		} catch (IDNotFoundException e) {
			return Response.status(404).build();
		}
	}
	
	
	@GET
	@Produces("application/JSON")
	@Path("{priceRange}")
	public List<Computer> getComputersByPriceRange(@QueryParam("start") int start, @QueryParam("end") int end) {
		return service.searchByPriceRange(start, end);
	}
	
	
	
	
	@POST
	@Produces("application/JSON")
	@Consumes({"application/JSON", "application/XML"})
	public Response createComputerPost(Computer computer) {
		return null;
	}

}
