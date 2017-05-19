package com.company.uppgift.implementation;

import java.util.List;

import javax.ejb.Remote;

import com.company.uppgift.domain.Computer;

	@Remote
	public interface ComputerManagementService {

		public void registerComputer();
		public List<Computer> getAllComputers();
		public List<Computer> searchByComputerName(String computerName);		
		public Computer searchById(int id);
		public void removeById(int id);
	}

