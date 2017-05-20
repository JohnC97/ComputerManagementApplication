package com.company.uppgift.implementation;

import java.util.List;

import com.company.uppgift.domain.Computer;

public interface ComputerManagementServiceLocal {
	public void registerComputer(Computer computer);
	public List<Computer> getAllComputers();
	public List<Computer> searchByComputerName(String computerName);
	public List<Computer> searchByPriceRange(int start, int end);   // delete this and become a dick, dickhead.
	public Computer searchById(int id);
	public void removeById(int id);
}
