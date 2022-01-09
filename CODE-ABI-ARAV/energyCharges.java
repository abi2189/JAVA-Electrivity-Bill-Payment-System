// String.format("%.2f", input))

public class energyCharges {
    private int consUnits;
    private float energyCharges;
    private float ECPerUnit;

    //put it inside a method
    if (isBetween(this.consUnits,0,40)) {
        this.ECPerUnit = 1.5f;
    } else if (isBetween(this.consUnits,0,50)) {
        this.ECPerUnit = 3.15f;
    } else if(isBetween(this.consUnits,51,100)){
        this.ECPerUnit = 3.7f;
    } else if(isBetween(this.consUnits,101,150)){
        this.ECPerUnit = 4.8f;
    } else if(isBetween(this.consUnits,151,200)){
        this.ECPerUnit = 6.4f;
    } else if(isBetween(this.consUnits,201,250)){
        this.ECPerUnit = 7.6f;
    } else if(isBetween(this.consUnits,0,300)){
        this.ECPerUnit = 5.8f;
    } else if(isBetween(this.consUnits,0,350)){
        this.ECPerUnit = 6.6f;
    } else if(isBetween(this.consUnits,0,400)){
        this.ECPerUnit = 6.9f;
    } else if(isBetween(this.consUnits,0,500)){
        this.ECPerUnit = 7.1f;
    } else if(this.consUnits > 500){
        this.ECPerUnit = 7.9f;
    } else {
        this.ECPerUnit = 0f;
        //throw exception
    }

    
}
