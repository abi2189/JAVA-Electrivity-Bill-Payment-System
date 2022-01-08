public class otherCharges {

    public static double fixedCharges;
	public static int GST;
	public int duty;
	public double totalOtherCharges;

    public otherCharges(int duty, double totalOtherCharges) {
		super();
		this.duty = duty;
		this.totalOtherCharges = totalOtherCharges;
	}

    public static double getFixedCharges() {
		return fixedCharges;
	}
	public static void setFixedCharges(double fixedCharges) {
		otherCharges.fixedCharges = fixedCharges;
	}
	public static int getGST() {
		return GST;
	}
	public static void setGST(int gST) {
		GST = gST;
	}
	public int getDuty() {
		return duty;
	}
	public void setDuty(int duty) {
		this.duty = duty;
	}
	public double getTotalOtherCharges() {
		return totalOtherCharges;
	}
	public void setTotalOtherCharges(double totalOtherCharges) {
		this.totalOtherCharges = totalOtherCharges;
	}
    
}
