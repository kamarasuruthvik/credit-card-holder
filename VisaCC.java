public class VisaCC extends CreditCard{
    public VisaCC(String cardNumber, String expiry, String cardHolderName){
        this.CreditCardName = "Visa";
        this.creditCardNumber = cardNumber;
        this.expirationDate = expiry;
        this.cardHolderName = cardHolderName;
    }
}
