package com.company.uppgift.implementation;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.company.uppgift.dataaccess.ComputerDataAccess;
import com.company.uppgift.dataaccess.IDNotFoundException;
import com.company.uppgift.domain.Computer;

@Stateless
public class ComputerManagementImplementation implements ComputerManagementService {

	@Inject
	private ComputerDataAccess cda;
	
	@Override
	public void registerComputer(Computer computer) {
		cda.registerComputer(computer);
	}

	@Override
	public List<Computer> getAllComputers() {
		return cda.findAll();
	}

	@Override
	public List<Computer> searchByComputerName(String computerName) {
		return cda.findByComputerName(computerName);
	}

	@Override
	public List<Computer> searchByPriceRange(int start, int end) {
		return cda.findByPriceRange(start, end);
	}

	@Override
	public Computer searchById(int id) throws IDNotFoundException {
		return cda.findById(id);
	}

	@Override
	public void removeById(int id) {
		cda.removeById(id);	
	}

}
