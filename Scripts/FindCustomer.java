//Student: Evan Bezuidenhout
//Level: 2
//Task: 7
//Compulsory Task: 2
//File: FindCustomer.java

import java.io.BufferedWriter;
import java.io.FileWriter;

public class FindCustomer {
	/*
	 * The determine location method checks if the driver value is empty, if not
	 * check that the driver's city matches with the customer's city if they match,
	 * call the export method, if they do not match write to the invoice
	 */
	static void DetermineLocation() {
		if (FindDriver.Driver == null) {
			System.out.println("Try entering a city you live in or check your spelling, if your spelling and city is correct, we may not currently be supporting your city for deliviries.");
		} else if (FindDriver.Driver.getCity().equalsIgnoreCase(Customer.city)) {
			Export(); // call export method
		} else {
			try {
				// File writer
				BufferedWriter bw = new BufferedWriter(new FileWriter("invoice.txt"));
				bw.write("Sorry! Our drivers are too far away from you to be able to deliver to your location.");
				bw.close();
			} catch (Exception ex) {
				System.out.println("ERROR: Unable to export due to an unexpected error.");
			}
		}
	}

	public static void Export() {
		try {
			// File writer
			BufferedWriter bw = new BufferedWriter(new FileWriter("invoice.txt"));
			bw.write("\nOrder Number: 1234" + "\n" + "Customer: " + Customer.name + "\n" + "Email: " + Customer.eMail
					+ "\n" + "Phone Number: " + Customer.tel + "\n" + "Location: " + FindDriver.Driver.getCity() + "\n"
					+ "Special Request: " + Customer.specialReq + "\n\n" + "Your delivery driver will be "
					+ FindDriver.Driver.getName() + "." + "\n\n"
					+ "If you need to contact the restaurant dial 098 025 3365.");
			bw.close();
		} catch (Exception ex) {
			System.out.println("ERROR: Unable to export due to an unexpected error.");
		}
	}
}
