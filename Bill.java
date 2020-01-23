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
		Scanner sc=new Scanner(System.in);
		char choice;
		System.out.println("Enter pick-up location: ");
		Stops.add(sc.next());
		System.out.println("Enter drop location: ");
		Stops.add(sc.next());
		System.out.println("Do you have any intermediate stop? (Y/N)");
		choice=sc.next().charAt(0);
		if(choice=='y'||choice=='Y') {
			System.out.println("Enter your stop location: ");
			Stops.add(sc.next());
		}
		sc.close();
	}
	
	public static void main(String[] args) {
		char choice;
		boolean success=true;
		String pswd;
		int id, i=0, y=0;
		ArrayList<Customer> c=new ArrayList<Customer>();
		Customer cs=new Customer();
		cs.assignC("Lola", 8964323456L, "lola@gmail.com", "lola123");
		c.add(cs);
		cs.assignC("Richa", 8798432345L, "richa@gmail.com", "richa123");
		c.add(cs);		
		cs.assignC("Sahil", 7892345681L, "sahil@gmail.com", "sahil123");
		c.add(cs);
		cs.assignC("Suraj", 9867312345L, "suraj@gmail.com", "suraj123");
		c.add(cs);
		Bill b=new Bill();
		Driver[] D=new Driver[6];
		D[0].assignD("Raj", 8765439932L, 679032, "Swift", 2356, 100f, 40f, 1);
		D[1].assignD("Meghna", 7429174010L, 329874, "i10", 3289, 100f, 40f, -1);
		D[2].assignD("Hari", 9270140984L, 438988, "Dzire", 8974, 150f, 60f, -1);
		D[3].assignD("John", 9431490234L, 123454, "Honda City", 3839, 150f, 60f, 1);
		D[4].assignD("Ravi", 8912376012L, 987433, "Creta", 2414, 200f, 100f, 1);
		D[5].assignD("Ginny", 9730147943L, 314433, "Brezza", 4144, 200f, 100f, 1);		
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to CAR RENTAL SERVICES!");
		System.out.println("If you are a new user, press R to register.");
		System.out.println("If you are an existing user, press L to login");
		do {
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
					for(Customer x: c) {
						if(id==x.returnID() && pswd==x.returnPassword()) {
							System.out.println("Logged-in successfully!");
							success=true;
							cs=c.get(i);
						}
						else {
							System.out.println("Log-in credentials are wrong.");
							success=false;
						}
						i++;
					}
				}while(!success);
				break;
			default: System.out.println("Wrong input. Please enter R/L.");
			}
		}while(choice!='R' || choice!='r' || choice!='L' ||choice!='l');
		b.Cust=cs;
		b.addStops();
		System.out.println("Vehicle types available: Hatchback (H), Sedan (S), SUV (V)");
		System.out.println("Choose a vehicle type: ");
		do {
			choice=sc.next().charAt(0);
			switch(choice) {
			case 'H':
			case 'h':
				System.out.println("Cars available:\n1. Swift\t2. i10");
				System.out.println("Please select a car (1/2): ");
				y=sc.nextInt();
				y-=1;
				break;
			case 'S':
			case 's':
				System.out.println("Cars available:\n1. Dzire\t2. Honda City");
				System.out.println("Please select a car (1/2): ");
				y=sc.nextInt();
				y+=1;
				break;
			case 'V':
			case 'v':
				System.out.println("Cars available:\n1. Creta\t2. Brezza");
				System.out.println("Please select a car (1/2): ");
				y=sc.nextInt();
				y+=3;
				break;
			default: System.out.println("Wrong choice entered.");
				success=true;
			}
			if(D[y].isAvailable()==1) {
				b.Driv=D[y];
				D[y].display();
				System.out.println("Confirm booking? (Y/N). If you wish to book another vehicle, enter N.");
				choice=sc.next().charAt(0);
				if(choice=='N'||choice=='n') {
					success=true;
				}
				else if(choice=='Y'||choice=='y') {
					success=false;
				}
				else {
					System.out.println("Wrong choice entered.");
				}
			}
			else {
				System.out.println("The selected car is unavailable. Please make another choice.");
				success=true;
			}
		}while(success);
		sc.close();
	}

}
