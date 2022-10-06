//Student: Evan Bezuidenhout
//Level: 2
//Task: 11
//Compulsory Task: 
//File: FindCustomer.java

import java.io.BufferedWriter;
import java.io.FileWriter;

public class ExportInvoice {
	/*
	 * The determine location method checks if the driver value is empty, if not
	 * check that the driver's city matches with the customer's city if they match,
	 * call the export method, if they do not match write to the invoice
	 */
	static void determineLocation() {
		if (DetermineDriver.Driver == null || Customer.city == null) {
			System.out.println("Please make sure that the city entered for the restaurant is correct.");
			System.exit(0);

		} else if (DetermineDriver.Driver == null) {
			System.out.println("Try entering a city you live in or check your spelling, if your spelling and city is correct, we may not currently be supporting your city for deliviries.");
			System.exit(0);

		} 
		else if (DetermineDriver.Driver.getCity().equalsIgnoreCase(Customer.city)) {
			export(); // call export method
		} 
		else {
			try {
				// File writer
				BufferedWriter bw = new BufferedWriter(new FileWriter("invoice.txt"));
				bw.write("Sorry! Our drivers are too far away from you to be able to deliver to your location.");
				bw.close();
			} catch (Exception ex) {
				System.out.println("ERROR: Unable to export due to an unexpected error.");
				System.exit(0);
			}
		}
	}

	public static void export() {
		try {
			System.out.println("Thank you for your order! :D Please view your invoice / receipt under the save path of this program...");
			// File writer
			BufferedWriter bw = new BufferedWriter(new FileWriter("invoice.txt"));
			bw.write("\nOrder Number: 1234" + "\n" + "Customer: " + Customer.name + "\n" + "Email: " + Customer.eMail
					+ "\n" + "Phone Number: " + Customer.tel + "\n" + "Location: " + DetermineDriver.Driver.getCity() + "\n"
					+ "Special Request: " + Customer.specialReq + "\n\n" + "Your delivery driver will be "
					+ DetermineDriver.Driver.getName() + "." + "\n\n"
					+ "If you need to contact the restaurant dial 098 025 3365.");
			bw.close();
		} catch (Exception ex) {
			System.out.println("ERROR: Unable to export due to an unexpected error.");
			System.exit(0);
		}
	}
}
