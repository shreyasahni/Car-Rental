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
		Price=(Stops.size()-1)*(Driv.Car.returnStop())+Driv.Car.returnBase();
	}
	public void addStops() {
		Scanner sc=new Scanner(System.in);
		char choice;
		System.out.println("Enter pick-up location: ");
		Stops.add(sc.next());
		System.out.println("Enter drop location: ");
		Stops.add(sc.next());
		do {
			System.out.println("Do you have any intermediate stops? (Y/N)");
			choice=sc.next().charAt(0);
			Stops.add(sc.next());
		} while(choice=='Y'||choice=='y');
		sc.close();
	}
	
	public static void main(String[] args) {
		char choice;
		boolean success=true;
		String pswd;
		int id, i=0, y;
		ArrayList<Customer> c=new ArrayList<Customer>(); 
		Customer cs=new Customer();
		Bill b=new Bill();
		Driver[] D=new Driver[6];
		D[0].assignD("Raj", 8765439932L, 679032, "Swift", 2356, 100, 40);
		D[1].assignD("Meghna", 7429174010L, 329874, "i10", 3289, 100, 40);
		D[2].assignD("Hari", 9270140984L, 438988, "Dzire", 8974, 150, 60);
		D[3].assignD("John", 9431490234L, 123454, "Honda City", 3839, 150, 60);
		D[4].assignD("Ravi", 8912376012L, 987433, "Creta", 2414, 200, 100);
		D[5].assignD("Ginny", 9730147943L, 314433, "Brezza", 4144, 200, 100);		
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
			default: System.out.println("Wrong choice entered. Please enter a valid type: ");
			}
		}while(choice!='H' || choice!='h' || choice!='S' ||choice!='s' || choice!='V' ||choice!='v');
		D[y].display();
		sc.close();
	}

}
