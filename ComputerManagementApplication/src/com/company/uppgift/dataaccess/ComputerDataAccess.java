package com.company.uppgift.dataaccess;

import java.util.List;

import com.company.uppgift.domain.Computer;

public interface ComputerDataAccess {
	public abstract void registerComputer(Computer computer);
	public abstract List<Computer> findAll();
	public abstract List<Computer> findByComputerName(String computerName);
	public abstract List<Computer> findByPriceRange(int start, int end);
	public abstract Computer findById(int id);
	public abstract void removeById(int id);
}
