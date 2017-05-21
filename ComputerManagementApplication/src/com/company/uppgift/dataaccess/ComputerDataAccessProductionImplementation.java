package com.company.uppgift.dataaccess;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.company.uppgift.domain.Computer;

@Stateless
@Default
@ProductionDao
public class ComputerDataAccessProductionImplementation implements ComputerDataAccess {

	
	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public void registerComputer(Computer newComputer) {
		em.persist(newComputer);
	}

	@Override
	public List<Computer> findAll() {
		Query q = em.createQuery("SELECT computer FROM Computer computer");
		List<Computer> computers = q.getResultList();
		return computers;
	}

	@Override
	public List<Computer> findByComputerName(String computerName) {
		
//		If the string contains space: should we make an 'AND'?
//		EX: 
//		SELECT * FROM Computer 
//		WHERE computerSpec LIKE '%Celeron%' 
//		AND computerSpec LIKE '%Quad Core%'
//		-- 'Celeron' and 'Quad Core' are not together in the computerSpec
		
		Query q = em.createQuery("SELECT computer FROM Computer computer "
						 	   + "WHERE computer.computerName LIKE :computerName");
		q.setParameter("computerName", "%" + computerName + "%");
		List<Computer> computers = q.getResultList();
		return computers;
	}

	@Override
	public List<Computer> findByPriceRange(int start, int end) {
		Query q = em.createQuery("SELECT computer FROM Computer computer "
						 + "WHERE computer.ID >= :start "
						 + "AND computer.ID <= :end");
		q.setParameter("start", start);
		q.setParameter("end", end);
		List<Computer> computers = q.getResultList();
		return computers;
	}

	@Override
	public Computer findById(int id) throws IDNotFoundException {
		Query q = em.createQuery("SELECT computer FROM Computer computer WHERE computer.id = :id");
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
			Query q = em.createQuery("DELETE FROM Computer computer "
							 + "WHERE computer.ID = :id");
			q.setParameter("id", id);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public ComputerDataAccessProductionImplementation() {}
}
