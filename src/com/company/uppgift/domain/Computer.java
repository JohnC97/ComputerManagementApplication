package com.company.uppgift.domain;

public class Computer {
	
	// I'M TESTING 


		private int id;
		private String computerName;
		private String computerType;
		private String computerSpec;
		private int computerPrice;
		private String computerImgSrc;
		
//		Kr�vs av JPA
		public Computer(){}
		
		public Computer(int id, String computerName, String computerType, String computerSpec, int computerPrice,
		String computerImgSrc) {
			super();
			this.id = id;
			this.computerName = computerName;
			this.computerType = computerType;
			this.computerSpec = computerSpec;
			this.computerPrice = computerPrice;
			this.computerImgSrc = computerImgSrc;
}


		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getComputerName() {
			return computerName;
		}

		public void setComputerName(String computerName) {
			this.computerName = computerName;
		}

		public String getComputerType() {
			return computerType;
		}

		public void setComputerType(String computerType) {
			this.computerType = computerType;
		}

		public String getComputerSpec() {
			return computerSpec;
		}

		public void setComputerSpec(String computerSpec) {
			this.computerSpec = computerSpec;
		}

		public int getComputerPrice() {
			return computerPrice;
		}

		public void setComputerPrice(int computerPrice) {
			this.computerPrice = computerPrice;
		}

		public String getComputerImgSrc() {
			return computerImgSrc;
		}

		public void setComputerImgSrc(String computerImgSrc) {
			this.computerImgSrc = computerImgSrc;
		}

		public String toString(){
			return "Computer: " + computerName;
		}
		
		
		
		
		
		
	}

