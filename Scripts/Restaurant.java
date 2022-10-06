//Student: Evan Bezuidenhout
//Level: 2
//Task: 11
//Compulsory Task: 
//File: Restaurant.java

public class Restaurant extends Main {
	String city;

	// Restaurant constructor
	public Restaurant(String city) {
		if (city == null || city == "") {
			System.out.println("Please enter the city of the restaurant you'd like to order from.");
			System.exit(0);
		} else {
			this.city = city;
			// Create a new FindDriver object (empty)
			FindDriver findDriver = new FindDriver(null, null, null);
			findDriver.readDoc(); // call readDoc method
			findDriver.calculateDriver(city.replaceAll("[\\\n\\t]", " ").replaceAll(" ", ""));  // call calculateDriver
																								// with restaurant city
																								// as argument
		}
	}
}
