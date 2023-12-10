public class DiscoverCC extends CreditCard{
    public DiscoverCC(String cardNumber, String expiry, String cardHolderName){
        this.CreditCardName = "Discover";
        this.creditCardNumber = cardNumber;
        this.expirationDate = expiry;
        this.cardHolderName = cardHolderName;
    }
}
