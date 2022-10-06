//Student: Evan Bezuidenhout
//Level: 2
//Task: 7
//Compulsory Task: 2
//File: Restaurant.java

public class Restaurant extends Main {
	String city;

	// Restaurant constructor
	public Restaurant(String city) {
		this.city = city;

		// Create a new FindDriver object (empty)
		FindDriver findDriver = new FindDriver(null, null, null);
		findDriver.ReadDoc(); // call readDoc method
		findDriver.CalculateDriver(city); // call calculateDriver with restaurant city as argument
	}
}
