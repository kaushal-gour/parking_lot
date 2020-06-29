package com.dkatalis.parkinglot;

public class Vehicle {
	
	private String vehicleNumber;
	
	public Vehicle(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vehicleNumber == null) ? 0 : vehicleNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (vehicleNumber == null) {
			if (other.vehicleNumber != null)
				return false;
		} else if (!vehicleNumber.equals(other.vehicleNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleNumber=" + vehicleNumber + "]";
	}
	

}
