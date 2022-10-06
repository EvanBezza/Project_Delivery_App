//Student: Evan Bezuidenhout
//Level: 2
//Task: 11
//Compulsory Task: 
//File: Driver.java

import java.util.Scanner; // Import the scanner class
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	static String customerName;
	static String tel;
	static String eMail;
	static String specialReq;
	static String customerCity;
	static boolean bName = false;
	static boolean bPhone = false;
	static boolean bMail = false;
	static boolean bCity = false;

	public static void main(String[] args) {
		// Gather restaurant constructor arguments
		Scanner restaurantLocation = new Scanner(System.in);
		System.out.println("Please enter the city the restaurant you'd like to order from is in.");
		new Restaurant(restaurantLocation.nextLine().toLowerCase().replaceAll(" ", ""));

		// Gather customer constructor arguments
		Scanner customerNameSC = new Scanner(System.in);
		System.out.println("Please enter your name: ");
		customerName = customerNameSC.nextLine();
		checkName();

		Scanner customerTelSC = new Scanner(System.in);
		System.out.println("Please enter your Telephone: ");
		tel = customerTelSC.nextLine().replaceAll(" ", "");
		checkNumber();

		Scanner customerMailSC = new Scanner(System.in);
		System.out.println("Please enter your E-Mail Adress: ");
		eMail = customerMailSC.nextLine();
		checkMail();

		Scanner customerReqSC = new Scanner(System.in);
		System.out.println("Please enter a special request if needed: ");
		specialReq = customerReqSC.nextLine();

		Scanner customerCitySC = new Scanner(System.in);
		System.out.println("Please enter the city you are in: ");
		customerCity = customerCitySC.nextLine().toLowerCase().replaceAll("	", "");
		checkCity();

		// close all scanners
		restaurantLocation.close();
		customerNameSC.close();
		customerTelSC.close();
		customerMailSC.close();
		customerReqSC.close();
		customerCitySC.close();

		// check if all fields have been filled in
		if (bName == true && bPhone == true && bMail == true && bCity == true) {
			// create a new customer object using the validated input
			new Customer(customerName, tel, eMail, specialReq, customerCity);
		} else {
			System.out.println("ERROR: A field is missing input");
			System.exit(0);
		}
	}

	// each of these methods are used to validate the user input.
	public static void checkName() {
		if (customerName == null || customerName == "") {
			System.out.println("ERROR: Please enter a name.");
			System.exit(0);
		} else {
			bName = true;
		}
	}

	public static void checkNumber() {
		if (tel == null || tel == "") {
			System.out.println("ERROR: Please enter your telephone number.");
			System.exit(0);
		} else if (!tel.matches("[0-9.]+")) {
			System.out.println(
					"ERROR: Please enter a valid telephone number consisting of only numeric values eg. 071 219 3168.");
			System.exit(0);
		} else if (tel.length() != 10) {
			System.out.println("ERROR: Please enter a valid telephone number eg. 071 219 3168.");
			System.exit(0);
		} else {
			bPhone = true;
		}
	}

	// Checks if the email address added is a valid email address judging from format
	public static void checkMail() {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(eMail);
		if (eMail == null || eMail == "") {
			System.out.println("ERROR: Please enter your E-Mail Address.");
			System.exit(0);
		} else if (!matcher.matches()) {
			System.out.println("ERROR: Please enter a valid E-Mail Address.");
			System.exit(0);
		} else {
			bMail = true;
		}
	}

	public static void checkCity() {
		if (customerCity == null || customerCity == "") {
			System.out.println("ERROR: Please enter your City you live in.");
			System.exit(0);
		} else {
			bCity = true;
		}
	}
}

//=== References ===
//JavaTPoint. (unknown). Java Email Validation. https://www.javatpoint.com/java-email-validation. (Date Accessed: 27/09/2022)