public class Bill {
    public long billNo;
    public TariffSlab TC;
    public otherCharges OC;
    public double billAmount;
    public String billArea;
    public int issueMonth;
    public Date issueDate=new Date();
    public Date dueDate=new Date();
    public Date disconDate=new Date();
}
