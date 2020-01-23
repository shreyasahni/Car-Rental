package Driver;

import java.util.*;
import Cars.Cars;

public class Driver {
	String Name;
	long Mobile;
	int Licence;
	int Available;
	Cars Car=new Cars();
	public int isAvailable() {
		return Available;
	}
	public Cars getCar() {
		return Car;
	}
	public void assignD(String nm, long mob, int lic, String mod, int no, float base, float stop, int av) {
		Name=nm;
		Mobile=mob;
		Licence=lic;
		Available=av;
		Car.assign(mod, no, base, stop);
	}
	public void display() {
		System.out.println("Driver details:\nName: "+Name+"\nMobile Number: "+Mobile+"\nCar Model: "+Car.returnModel()+"\nCar Licence Plate Number: "+Car.returnPlate());
	}
}
