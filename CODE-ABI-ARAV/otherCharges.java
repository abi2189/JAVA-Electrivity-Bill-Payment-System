public class otherCharges {
    private static float fixedCharges = 100.5f;
	private static float GST = 0.05f;
	private static float duty = 0.12f;
	private float totalOtherCharges;
	private float energyCharges;

	public otherCharges(){}
    public otherCharges(float totalOtherCharges) {
		this.totalOtherCharges = totalOtherCharges;
	}

	public void setTotalOtherCharges(float totalOtherCharges) {
		this.totalOtherCharges=totalOtherCharges;
	}
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


	public float calculateTotalOtherCharges(float energyCharges) {
		this.energyCharges=energyCharges;
		this.totalOtherCharges = fixedCharges + (energyCharges*GST) + (energyCharges*duty);
        return this.totalOtherCharges;
	}
	public String toString(){
        return String.format("FixedCharges: %.2f\nGST: %.2f\nDuty: %.2f\nTotal Other Charges: %.2f",fixedCharges, energyCharges*GST,energyCharges*duty,totalOtherCharges);
    }
    
}
