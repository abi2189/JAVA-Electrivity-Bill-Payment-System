public class otherCharges {
    private static float fixedCharges = 100.5f;
	private static float GST = 0.05f;
	private static float duty = 0.12f;
	private double totalOtherCharges;

    public otherCharges(int duty, double totalOtherCharges) {
		super();
		this.duty = duty;
		this.totalOtherCharges = totalOtherCharges;
	}

    public static float getFixedCharges() {
		return this.fixedCharges;
	}

	public static int getGST() {
		return this.GST;
	}

	public int getDuty() {
		return this.duty;
	}

	public double getTotalOtherCharges() {
		return this.totalOtherCharges;
	}
	public float calculateTotalOtherCharges(int consUnits, float energyCharges ) {

		this.totalOtherCharges = this.fixedCharges + (energyCharges*this.GST) + (energyCharges*this.duty));
        return this.totalOtherCharges;
	}
    
}
