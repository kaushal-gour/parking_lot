package com.dkatalis.parkinglot;

public class ParkingSlot {
	
	private int slotNumber;
	
	public ParkingSlot(int slotNumber){
		this.slotNumber = slotNumber;
	}

	public int getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}

	@Override
	public String toString() {
		return "ParkingSlot [slotNumber=" + slotNumber + "]";
	}


}
