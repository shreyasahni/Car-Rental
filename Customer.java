package Customer;

import java.util.*;

public class Customer {
	String Name;
	Long PhoneNo=new Long(0);
	String Email;
	String Password;
	int ID;
	public int returnID() {
		return ID;
	}
	public String returnPassword() {
		return Password;
	}
	public void assignC(String nm, long ph, String em, String psw) {
		Random rand=new Random();
		Name=nm;
		PhoneNo=ph;
		Email=em;
		Password=psw;
		ID=rand.nextInt(100);
	}
	public void register() {
		Scanner sc=new Scanner(System.in);
		Random rand=new Random();
		String pwd1, pwd2;
		System.out.println("Enter the following details to register: ");
		System.out.println("Name: ");
		Name=sc.nextLine();
		while(Name=="" ) {
			System.out.println("Please enter valid details: ");
			Name=sc.nextLine();
		}
		System.out.println("Phone number: ");
		PhoneNo=sc.nextLong();
		while(PhoneNo.toString().length()!=10) {
			System.out.println("Please enter valid details: ");
			PhoneNo=sc.nextLong();
		}
		System.out.println("Email: ");
		Email=sc.next();
		while(Email=="" ) {
			System.out.println("Please enter valid details: ");
			Email=sc.nextLine();
		}
		do {
			System.out.println("Password: ");
			pwd1=sc.next();
			System.out.println("Retype password: ");
			pwd2=sc.next();
		} while(pwd1!=pwd2);
		Password=pwd1;
		ID=rand.nextInt(100);
		sc.close();
	}
	
}
