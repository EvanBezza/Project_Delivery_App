//Student: Evan Bezuidenhout
//Level: 2
//Task: 7
//Compulsory Task: 2
//File: Driver.java

import java.util.Scanner; // Import the scanner class

public class Main {
	static String customerName;
	static String tel;
	static String eMail;
	static String specialReq;
	static String customerCity;

	public static void main(String[] args) {
		// Gather restaurant constructor arguments
		Scanner restaurantLocation = new Scanner(System.in);
		System.out.println("Please enter the city the restaurant you'd like to order from is in.");
		Restaurant setRCity = new Restaurant(restaurantLocation.nextLine().toLowerCase().replaceAll(" ", ""));

		// Gather customer constructor arguments
		Scanner customerNameSC = new Scanner(System.in);
		System.out.println("Please enter your name: ");
		customerName = customerNameSC.nextLine();

		Scanner customerTelSC = new Scanner(System.in);
		System.out.println("Please enter your Telephone: ");
		tel = customerTelSC.nextLine();

		Scanner customerMailSC = new Scanner(System.in);
		System.out.println("Please enter your E-Mail Adress: ");
		eMail = customerMailSC.nextLine();

		Scanner customerReqSC = new Scanner(System.in);
		System.out.println("Please enter a special request if needed: ");
		specialReq = customerReqSC.nextLine();

		Scanner customerCitySC = new Scanner(System.in);
		System.out.println("Please enter the city you are in: ");
		customerCity = customerCitySC.nextLine().toLowerCase().replaceAll(" ", "");

		// Create new Customer object
		Customer newCustomer = new Customer(customerName, tel, eMail, specialReq, customerCity);
	}

}
