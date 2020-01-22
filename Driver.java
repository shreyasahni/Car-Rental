package Driver;

import java.util.*;
import Cars.Cars;

public class Driver {
	String Name;
	long Mobile;
	int Licence;
	public Cars Car=new Cars();
	public void assignD(String nm, long mob, int lic, String mod, int no, float base, float stop) {
		Name=nm;
		Mobile=mob;
		Licence=lic;
		Car.assign(mod, no, base, stop);
	}
}
