public class MasterCC extends CreditCard{
    public MasterCC(String cardNumber, String expiry, String cardHolderName){
        this.CreditCardName = "MasterCard";
        this.creditCardNumber = cardNumber;
        this.expirationDate = expiry;
        this.cardHolderName = cardHolderName;
    }
}
