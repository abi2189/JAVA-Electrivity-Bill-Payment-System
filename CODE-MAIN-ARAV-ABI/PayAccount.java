public class PayAccount {
    private  long accountNum;
    private String cardholderName;
    private int postalCode;
    private Date expiryDate= new Date();

    public void setpayAccountDetails(long a, String b, int c, Date d) {
        this.setAccountNum(a);
        this.setCardholderName(b);
        this.setPostalCode(c);
        this.setExpiryDate(d);
    }

    public long getAccountNum() {
        return accountNum;
    }
    public void setAccountNum(long accountNum) {
        this.accountNum = accountNum;
    }
    public String getCardholderName() {
        return cardholderName;
    }
    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }
    public int getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
    public Date getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
