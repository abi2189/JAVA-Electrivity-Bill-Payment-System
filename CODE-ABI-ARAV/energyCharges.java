// String.format("%.2f", input))

public class energyCharges {
    private int consUnits;
    private float ECPerUnit;
    private float energyCharges;
    private String tariffSlab;

    public energyCharges(){}

    public void setConsUnits(int u){
        this.consUnits = u;
    }

    public void findTariffSlab(){
        if(this.consUnits >= 0 && this.consUnits <= 250){
            this.tariffSlab = "LT-1 Domestic Telescopic";
        } else if (this.consUnits >= 251 && this.consUnits <= 1000){
            this.tariffSlab = "LT-1 Domestic Non-Telescopic";
        } else {
            this.tariffSlab = "Out of Range";
        }
    }

    public float calculateECPerUnit(){
        if (this.consUnits >= 0f && this.consUnits <= 40f) {
            this.ECPerUnit = 1.5f;
        } else if (this.consUnits >= 0f && this.consUnits <= 50f) {
            this.ECPerUnit = 3.15f;
        } else if(this.consUnits >= 51f && this.consUnits <= 100f){
            this.ECPerUnit = 3.7f;
        } else if(this.consUnits >= 101f && this.consUnits <= 150f){
            this.ECPerUnit = 4.8f;
        } else if(this.consUnits >= 151f && this.consUnits <= 200f){
            this.ECPerUnit = 6.4f;
        } else if(this.consUnits >= 201f && this.consUnits <= 250f){
            this.ECPerUnit = 7.6f;
        } else if(this.consUnits >= 0f && this.consUnits <= 300f){
            this.ECPerUnit = 5.8f;
        } else if(this.consUnits >= 0f && this.consUnits <= 350f){
            this.ECPerUnit = 6.6f;
        } else if(this.consUnits >= 0f && this.consUnits <= 400f){
            this.ECPerUnit = 6.9f;
        } else if(this.consUnits >= 0f && this.consUnits <= 500f){
            this.ECPerUnit = 7.1f;
        } else if(this.consUnits > 500f){
            this.ECPerUnit = 7.9f;
        } else {
            this.ECPerUnit = 0f;
            //throw exception
        }

        return this.ECPerUnit;
    }

    public float calculateEnergyCharges(){
        findTariffSlab();
        this.energyCharges = this.consUnits * calculateECPerUnit();
        return this.energyCharges;
    }

    public String toString(){
        // findTariffSlab();
        return "\nNo. of Units Consumed: " + this.consUnits + "\nTariff Slab: " + this.tariffSlab +"\nEnergy Charges Per Unit: " + this.ECPerUnit + "\nTotal Energy Charges: " + this.energyCharges;
    }
    
}
