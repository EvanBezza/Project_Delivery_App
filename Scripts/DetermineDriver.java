//Student: Evan Bezuidenhout
//Level: 2
//Task: 11
//Compulsory Task: 
//File: FindDriver.java

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class DetermineDriver extends Main {

	// ==================================
	// Variables for the FindDriver class
	// ==================================
	String name;
	String driverCity;
	String driverLoad;
	int min = 200;
	int count = 0;
	DetermineDriver[] driverArr = new DetermineDriver[31];
	static DetermineDriver Driver;

	// ============================
	// Getters for FindDriver Class
	// ============================
	public String getCity() {
		return driverCity;
	}

	public String getLoad() {
		return driverLoad;
	}

	public String getName() {
		return name;
	}

	// ===============================
	// Constructor of FindDriver class
	// ===============================
	public DetermineDriver(String name, String driverCity, String driverLoad) {
		this.name = name;
		this.driverCity = driverCity;
		this.driverLoad = driverLoad;
	}

	// ReadDoc method reads through the drivers.txt file and splits each line by the
	// commas, after each split the variables name, driverCity, driverLoad are
	// assigned the values of the line with the txt doc.
	// after the values are split into separate data sets a new FindDriver object is
	// constructed with the extracted info and added to an object array called
	// driverArr.
	void readDoc() {
		if (driverArr.length == 31) {
			try {
				// Read through each line of the txt doc
				BufferedReader br = new BufferedReader(new FileReader("deliveryDrivers.txt"));
				try (Scanner sc = new Scanner(br)) {
					// wile the txt doc has a next line
					while (sc.hasNextLine()) {
						count++;
						String[] values = sc.nextLine().split(","); // split each line into their own values by comma

						// Add each data value to a variable
						name = values[0].replaceAll(" ", "");
						driverCity = values[1].replaceAll(" ", "");

						// check if the drivers load is empty and set it to 0
						if (values[2].replaceAll(" ", "").equals("")) {
							driverLoad = "0";
						} else {
							driverLoad = values[2].replaceAll(" ", "");
						}

						// Create new object and add to object array
						driverArr[count] = new DetermineDriver(name, driverCity, driverLoad);
					}
				}
			} catch (FileNotFoundException e) {
				System.out.println("The deliveryDrivers.txt.txt file is not avaialble, make sure to place it in the same folder as the script.");
			}
		} else {
			System.out.println("Please increase or decrease the amount of drivers in your txt file to 31 users.");
		}
	}

	/*
	 * The calculateDriver method determines which driver is best suited by
	 * factoring in the location of the created restaurant and calculating which
	 * driver of the same location has the least load by looping through the created
	 * object array. If the load is the least and the location of the driver and
	 * restaurant are ideal set the variable 'driver' to the value of that driver
	 * object
	 */
	void calculateDriver(String restaurantLocation) {
		if (driverArr.length == 31) {
			// Loop through array of read objects
			for (int i = 1; i < driverArr.length; i++) {
				// if the driver city matches the restaurant
				if (driverArr[i].getCity().equalsIgnoreCase(restaurantLocation)) {
					int num = Integer.parseInt(driverArr[i].getLoad());
					// Calculate the min load
					if (num < min) {
						min = num;
					}
				}
			}
			// loop through Arr and see if the location of driver and restaurant match up
			// along with the lowest load.
			for (int j = 1; j < driverArr.length; j++) {
				if (driverArr[j].getCity().equalsIgnoreCase(restaurantLocation) && driverArr[j].getLoad().equals(String.valueOf(min))) {
					Driver = driverArr[j]; // set driver to value of object
				}
			}
		} else {
			// exit the program
			System.exit(0);
		}
	}
}

// === References ===
// YouTube. 20/10/2020. Array of Objects in Java Tutorial - How To Make An Array of Objects. https://www.youtube.com/watch?v=1hUUsuDfmSw. (Date Accessed: 14.08.2022)
// YouTube. 08/05/2019. Create objects from text file data. https://www.youtube.com/watch?v=93PBjHHvHaY. (Date Accessed: 14.08.2022)
// GeeksForGeeks. 02/09/2020. How to Create Array of Objects in Java?. https://www.geeksforgeeks.org/how-to-create-array-of-objects-in-java/. (Date Accessed: 14.08.2022)
// DelftStack. 02/09/2020. Print Objects in Java. https://www.delftstack.com/howto/java/print-object-in-java/. (Date Accessed: 14.08.2022)
