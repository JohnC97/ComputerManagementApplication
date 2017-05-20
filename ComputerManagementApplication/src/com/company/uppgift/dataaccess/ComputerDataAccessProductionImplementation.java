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
		q = em.createQuery("SELECT computer FROM Computer computer "
						 + "WHERE computer.ID >= :start "
						 + "AND computer.ID <= :end");
		q.setParameter("start", start);
		q.setParameter("end", end);
		List<Computer> computers = q.getResultList();
		return computers;
	}

	@Override
	public Computer findById(int id) throws IDNotFoundException {
		q = em.createQuery("SELECT computer FROM Computer computer "
						 + "WHERE computer.ID = :id");
		q.setParameter("id", id);
		try {
			return (Computer) q.getSingleResult();
		} catch (Exception e) {
			throw new IDNotFoundException();
		}
	}

	@Override
	public void removeById(int id) {
		try {
			q = em.createQuery("DELETE FROM Computer computer "
							 + "WHERE computer.ID = :id");
			q.setParameter("id", id);
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
