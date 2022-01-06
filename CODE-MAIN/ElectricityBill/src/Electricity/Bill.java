package Electricity;

public class Bill {
     public long billNo;
     public Tariff_Slab TC;
     public otherCharges OC;
     public double billAmount;
     public String billArea;
     public int issueMonth;
     public Date issueDate=new Date();
     public Date dueDate=new Date();
     public Date disconDate=new Date();
	@Override
	
	
	public String toString() {
		return "Bill [billNo=" + billNo + ", TC=" + TC + ", OC=" + OC + ", billAmount=" + billAmount + ", billArea="
				+ billArea + ", issueMonth=" + issueMonth + ", issueDate=" + issueDate + ", dueDate=" + dueDate
				+ ", disconDate=" + disconDate + "]";
	}
     
     
}
