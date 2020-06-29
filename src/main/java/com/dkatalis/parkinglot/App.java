package com.dkatalis.parkinglot;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

	ParkingSpace parkingSpace = null;

	public static void main(String[] args) {

		App app = new App();

		String fName = "config/file_input.txt";

		app.fileStreamUsingFiles(fName);

	}

	private void fileStreamUsingFiles(String fileName) {

		Stream<String> lines = null;
		try {

			lines = Files.lines(Paths.get(fileName));
			List<String> list = lines.collect(Collectors.toList());
			for (String input : list) {
				String[] arr = input.split(" ");

				switch (arr[0]) {
				case "create_parking_lot":
					createParkingSpace(arr[1]);
					break;
				case "park":
					park(arr[1]);
					break;
				case "leave":
					leave(arr[1], arr[2]);
					break;
				case "status":
					parkingSpace.status();
					break;
				default:
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("Invalid input");
		} finally {
			lines.close();
		}
	}

	public void createParkingSpace(String input) {
		Integer totalParkingSpace = Integer.parseInt(input);
		parkingSpace = new ParkingSpace(totalParkingSpace);
	}

	public void park(String input) {
		parkingSpace.parkVehicle(new Vehicle(input));

	}

	public void status() {
		parkingSpace.status();
	}

	public void leave(String input1, String input2) {
		Integer parkingPeriod = Integer.parseInt(input2);
		parkingSpace.leaveParking(new Vehicle(input1), parkingPeriod);

	}

}