package com.company.uppgift.dataaccess;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.company.uppgift.domain.Computer;

public class ComputerDataAccessProductionImplementation implements ComputerDataAccess{

	public ComputerDataAccessProductionImplementation() {}
	
	
	
	@PersistenceContext
	private EntityManager em;
	
	private Query q;
	
	
	
	@Override
	public void registerComputer(Computer computer) {
		em.persist(computer);
	}

	@Override
	public List<Computer> findAll() {
		q = em.createQuery("SELECT computer FROM Computer computer");
		List<Computer> computers = q.getResultList();
		return computers;
	}

	@Override
	public List<Computer> findByComputerName(String computerName) {
		q = em.createQuery("SELECT computer FROM Computer computer WHERE computer.computerName = :computerName");
		q.setParameter("computerName", computerName);
		List<Computer> computers = q.getResultList();
		return computers;
	}

	@Override
	public List<Computer> findByPriceRange(int start, int end) {
		return null;
	}

	@Override
	public Computer findById(int id) throws IDNotFoundException {
		return null;
	}

	@Override
	public void removeById(int id) {
		
	}

}
