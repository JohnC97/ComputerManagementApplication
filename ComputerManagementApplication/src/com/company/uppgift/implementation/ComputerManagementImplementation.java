package com.company.uppgift.implementation;

import java.util.List;

import com.company.uppgift.dataaccess.ComputerDataAccess;
import com.company.uppgift.domain.Computer;

public class ComputerManagementImplementation implements ComputerManagementService {

	
	private ComputerDataAccess cda;
	
	@Override
	public void registerComputer(Computer computer) {
		cda.registerComputer(computer);
	}

	@Override
	public List<Computer> getAllComputers() {
		return null;
	}

	@Override
	public List<Computer> searchByComputerName(String computerName) {
		return null;
	}

	@Override
	public List<Computer> searchByPriceRange(int start, int end) {
		return null;
	}

	@Override
	public Computer searchById(int id) {
		return null;
	}

	@Override
	public void removeById(int id) {
	}

}
