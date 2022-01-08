

public class Tariff_Slab {

	public Consumption_Units c1;
	public String category;
	public double tariffCharges;
	
	
	//constructor 
	
	public Tariff_Slab(Consumption_Units c1, String category, double tariffCharges) {
		super();
		this.c1 = c1;
		this.category = category;
		this.tariffCharges = tariffCharges;
	}
	//getter and setter
	
	public Consumption_Units getC1() {
		return c1;
	}
	public void setC1(Consumption_Units c1) {
		this.c1 = c1;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getTariffCharges() {
		return tariffCharges;
	}
	public void setTariffCharges(double tariffCharges) {
		this.tariffCharges = tariffCharges;
	}
	
	
	//getter and setter
	
}
