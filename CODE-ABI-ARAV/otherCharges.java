public class otherCharges {
    private static float fixedCharges = 100.5f;
	private static float GST = 0.05f;
	private static float duty = 0.12f;
	private float totalOtherCharges;
	private float energyCharges;

	public otherCharges(){}

    public static float getFixedCharges() {
		return fixedCharges;
	}
	public static float getGST() {
		return GST;
	}
	public float getDuty() {
		return duty;
	}
	public double getTotalOtherCharges() {
		return this.totalOtherCharges;
	}

	//same as setting but calculating
	public float calculateTotalOtherCharges(int units, float tEnergyCharges) {
		this.energyCharges=tEnergyCharges;
		this.totalOtherCharges = fixedCharges + (this.energyCharges*GST) + (units*duty);
		duty = units*duty;
        return this.totalOtherCharges;
	}

	public String toString(){
        return "\nFixedCharges: " + fixedCharges + "\nGST: " + this.energyCharges*GST + "\nDuty Charges: " + duty + "\nTotal Other Charges: " + this.totalOtherCharges;
	}
    
}
