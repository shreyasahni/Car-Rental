package Bill;

import java.util.*;
import Customer.Customer;
import Driver.Driver;
import Cars.*;

public class Bill {
	Customer Cust=new Customer();
	Driver Driv=new Driver();
	float Price;
	ArrayList<String> Stops=new ArrayList<String>();
	public void calculateFare() {
		Price=(Stops.size()-2)*(Driv.getCar().returnStop())+Driv.getCar().returnBase();
	}
	public void addStops() {
		Scanner sc1=new Scanner(System.in);
		char choice;
		String word;
		System.out.println("Enter pick-up location: ");
		word=sc1.nextLine();
		Stops.add(word);
		System.out.println("Enter drop location: ");
		word=sc1.nextLine();
		Stops.add(word);
		System.out.println("Do you have any intermediate stop? (Y/N)");
		choice=sc1.next().charAt(0);
		sc1.nextLine();
		if(choice=='y'||choice=='Y') {
			System.out.println("Enter your stop location: ");
			word=sc1.nextLine();
			Stops.add(word);
		}
		return;
	}
	
	public static void main(String[] args) {
		char choice, choice2;
		boolean success=false;
		String pswd;
		int id, i=0, x=0, y=0;
		ArrayList<Customer> c=new ArrayList<Customer>();
		ArrayList<Driver> d=new ArrayList<Driver>();
		Customer cs=new Customer();
		Customer cs1=new Customer();
		Customer cs2=new Customer();
		Customer cs3=new Customer();
		Customer cs4=new Customer();
		Driver dv=new Driver();
		Driver dv1=new Driver();
		Driver dv2=new Driver();
		Driver dv3=new Driver();
		Driver dv4=new Driver();
		Driver dv5=new Driver();
		Driver dv6=new Driver();
		Bill b=new Bill();
		cs1.assignC("Lola", 8964323456L, "lola@gmail.com", 234, "lola123");
		c.add(cs1);
		cs2.assignC("Richa", 8798432345L, "richa@gmail.com", 123, "richa123");
		c.add(cs2);		
		cs3.assignC("Sahil", 7892345681L, "sahil@gmail.com", 100, "sahil123");
		c.add(cs3);
		cs4.assignC("Suraj", 9867312345L, "suraj@gmail.com", 200, "suraj123");
		c.add(cs4);
		dv1.assignD("Raj", 8765439932L, 679032, "Swift", 2356, 100f, 40f, 1);
		d.add(dv1);
		dv2.assignD("Meghna", 7429174010L, 329874, "i10", 3289, 100f, 40f, -1);
		d.add(dv2);
		dv3.assignD("Hari", 9270140984L, 438988, "Dzire", 8974, 150f, 60f, -1);
		d.add(dv3);		
		dv4.assignD("John", 9431490234L, 123454, "Honda City", 3839, 150f, 60f, 1);
		d.add(dv4);		
		dv5.assignD("Ravi", 8912376012L, 987433, "Creta", 2414, 200f, 100f, 1);
		d.add(dv5);		
		dv6.assignD("Ginny", 9730147943L, 314433, "Brezza", 4144, 200f, 100f, 1);
		d.add(dv6);	
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to CAR RENTAL SERVICES!");
		System.out.println("If you are a new user, press R to register.");
		System.out.println("If you are an existing user, press L to login");
		choice=sc.next().charAt(0);
		switch(choice) {
		case 'R':
		case 'r':
			cs.register();
			c.add(cs);
			System.out.println("Successfully registered! Your unique user ID is: "+cs.returnID());
			break;
		case 'L':
		case 'l':
			do {
				System.out.println("Enter log-in ID: ");
				id=sc.nextInt();
				System.out.println("Enter password: ");
				pswd=sc.next();
				for(i=0;i<c.size();i++) {
					cs=c.get(i);
					if(id==cs.returnID() && pswd.equals(cs.returnPassword())) {
						System.out.println("Logged-in successfully!");
						y=i;
						success=true;
					}
				}
				if(!success) {
					System.out.println("Log-in credentials are wrong. Please enter correct details.");
					success=false;
				}
			}while(!success);
			break;
		default:
			System.out.println("Wrong input.");
			return;
		}
		b.Cust=c.get(y);
		b.addStops();
		System.out.println("Vehicle types available: Hatchback (H), Sedan (S), SUV (V)");
		System.out.println("Choose a vehicle type: ");
		success=false;
		choice=sc.next().charAt(0);
		do {
			x=0;
			switch(choice) {
			case 'H':
			case 'h':
				System.out.println("Cars available:\n1. Swift\t2. i10");
				System.out.println("Please select a car (1/2): ");
				x=sc.nextInt();
				x-=1;
				break;
			case 'S':
			case 's':
				System.out.println("Cars available:\n1. Dzire\t2. Honda City");
				System.out.println("Please select a car (1/2): ");
				x=sc.nextInt();
				x+=1;
				break;
			case 'V':
			case 'v':
				System.out.println("Cars available:\n1. Creta\t2. Brezza");
				System.out.println("Please select a car (1/2): ");
				x=sc.nextInt();
				x+=3;
				break;
			default: System.out.println("Wrong choice entered.");
				success=true;
				return;
			}
			dv=d.get(x);
			if(dv.isAvailable()==1) {
				b.Driv=dv;
				dv.display();
				System.out.println("To confirm booking, enter Y.");
				System.out.println("If you wish to book another vehicle, enter N.");
				choice2=sc.next().charAt(0);
				if(choice2=='N'||choice2=='n') {
					success=true;
				}
				else if(choice2=='Y'||choice2=='y') {
					success=false;
				}
				else {
					System.out.println("Wrong choice entered.");
					return;
				}
			}
			else {
				System.out.println("The selected car is unavailable. Please make another choice: ");
				success=true;
			}
		}while(success);
		System.out.println("Booking confirmed! Details regarding the booking have been sent to "+b.Cust.returnEmail());
		System.out.println(b.Driv.getCar().returnModel()+" car has been booked under user ID "+b.Cust.returnID()+".");
	}

}
