package Cars;

public class Cars {
	String Model;
	int PlateNo;
	float BasePrice;
	float StopPrice;
	public float returnBase() {
		return BasePrice;
	}
	public float returnStop() {
		return StopPrice;
	}
	public void assign(String mod, int no, float base, float stop) {
		Model=mod;
		PlateNo=no;
		BasePrice=base;
		StopPrice=stop;
	}
	public String returnModel() {
		return Model;
	}
	public int returnPlate() {
		return PlateNo;
	}
}
