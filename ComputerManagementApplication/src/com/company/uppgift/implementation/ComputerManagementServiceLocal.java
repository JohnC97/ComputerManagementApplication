package com.company.uppgift.implementation;

import java.util.List;

import javax.ejb.Local;

import com.company.uppgift.dataaccess.IDNotFoundException;
import com.company.uppgift.domain.Computer;

@Local
public interface ComputerManagementServiceLocal {
	public void registerComputer(Computer computer);
	public List<Computer> getAllComputers();
	public List<Computer> searchByComputerName(String computerName);
	public List<Computer> searchByPriceRange(int start, int end);   // delete this and become a dick, dickhead.
	public Computer searchById(int id) throws IDNotFoundException;
	public void removeById(int id);
	void updateComputer(int id, int computerPrice, String computerSpec) throws ComputerNotFoundException;
}
