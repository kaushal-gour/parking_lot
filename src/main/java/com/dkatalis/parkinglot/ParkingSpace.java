package com.dkatalis.parkinglot;

import java.util.HashMap;
import java.util.Set;

public class ParkingSpace  {
	
	HashMap<Vehicle, ParkingSlot> vehicleMap = null;
	HashMap<Integer, Boolean> parkingSlotMap = null;

	private int totalSpace = 0;

	public ParkingSpace(int totalSpace) {
		this.totalSpace = totalSpace;
		this.vehicleMap = new HashMap<>();
		this.parkingSlotMap = new HashMap<>();
	}

	public int getTotalSpace() {
		return totalSpace;
	}

	public void parkVehicle(Vehicle vehicle) {
		if (vehicleMap.size() >= totalSpace) {
			System.out.println("Sorry, parking lot is full");
			return;
		}
		ParkingSlot slot = null;

		if (parkingSlotMap.size() == totalSpace) {
			 slot = getAvailableSlot();
			 parkingSlotMap.put(slot.getSlotNumber(), true);
		} else {
			slot = new ParkingSlot(vehicleMap.size() + 1);
			parkingSlotMap.put(slot.getSlotNumber(), true);
		}

		vehicleMap.put(vehicle, slot);
		System.out.println("Allocated slot number: " + slot.getSlotNumber());
	}

	public void leaveParking(Vehicle vehicle, int parkingPeriod) {
		if(!vehicleMap.containsKey(vehicle)) {
			System.out.println("Registration number "+ vehicle.getVehicleNumber() +" not found");
			return;
		}
		System.out.println("Registration number "+ vehicle.getVehicleNumber() +" with Slot Number "+ vehicleMap.get(vehicle).getSlotNumber() +" is free with Charge "+ calculateParkingAmount(parkingPeriod));
		if(parkingSlotMap.containsKey(vehicleMap.get(vehicle).getSlotNumber())) {
			parkingSlotMap.put(vehicleMap.get(vehicle).getSlotNumber(), false);
		}
		vehicleMap.remove(vehicle);
		
	}
	
	public void status() {
		
		System.out.println("Slot No. Registration No.");
		Set<Vehicle> vehicleSet = vehicleMap.keySet();
		for(Vehicle v : vehicleSet) {
			System.out.println(vehicleMap.get(v).getSlotNumber() +" "+ v.getVehicleNumber());
		}
	}

	private int calculateParkingAmount(int parkingPeriod) {
		if (parkingPeriod <= 0) {
			return 0;
		}
		if (parkingPeriod <= 2) {
			return 10;
		}
		int restParkingPeriod = parkingPeriod - 2;
		return 10 + (restParkingPeriod * 10);
	}

	private ParkingSlot getAvailableSlot() {
		Set<Integer> keySet = parkingSlotMap.keySet();
		for(Integer key: keySet) {
			if(!parkingSlotMap.get(key)) {
				return new ParkingSlot(key);
			}
		}
		return null;
	}
	
	

}
