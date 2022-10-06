//Student: Evan Bezuidenhout
//Level: 2
//Task: 11
//Compulsory Task: 
//File: Customer.java

public class Customer extends Main {
	static String name;
	static String tel;
	static String eMail;
	static String specialReq;
	static String city;

	// ====================================
	// Object Constructor of Customer class
	// ====================================
	public Customer(String name, String tel, String eMail, String specialReq, String city) {
		Customer.name = name;
		Customer.tel = tel;
		Customer.eMail = eMail;
		Customer.specialReq = specialReq;
		Customer.city = city.replaceAll("[\\\n\\t]", " ").replaceAll(" ", "");
		// call determineLocation method with FindCustomer class
		FindCustomer.determineLocation();
	}
}