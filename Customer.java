package Person;

import java.util.Random;
import java.util.Scanner;

abstract class Person {
	String Name;
	long Mobile;
}

public class Customer extends Person {
	String Email;
	String Password;
	int ID;
	public int returnID() {
		return ID;
	}
	public String returnPassword() {
		return Password;
	}
	public String returnEmail() {
		return Email;
	}
	public void assignC(String nm, long ph, String em, int id, String psw) {
		Name=nm;
		Mobile=ph;
		Email=em;
		Password=psw;
		ID=id;
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
		Mobile=sc.nextLong();
		while(Mobile==0) {
			System.out.println("Please enter valid details: ");
			Mobile=sc.nextLong();
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
		} while(!pwd1.equals(pwd2));
		Password=pwd1;
		ID=rand.nextInt(100);
	}
	
}

