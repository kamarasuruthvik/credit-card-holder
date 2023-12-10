public class CardFactory {
    public CreditCard createCard(String cardNumber, String expiry, String cardHolderName) {
        if (cardNumber.charAt(0) == '5' && (cardNumber.charAt(1) >= '1' && cardNumber.charAt(1) <= '5') && cardNumber.length() == 16)
            return new MasterCC(cardNumber, expiry, cardHolderName);
        else if (cardNumber.charAt(0) == '4' && (cardNumber.length() == 13 || cardNumber.length() == 16))
            return new VisaCC(cardNumber, expiry, cardHolderName);
        else if (cardNumber.charAt(0) == '3' && (cardNumber.charAt(1) == '4' || cardNumber.charAt(1) == '7') && cardNumber.length() == 15)
            return new AmExCC(cardNumber, expiry, cardHolderName);
        else if (cardNumber.startsWith("6011") && cardNumber.length() == 16)
            return new DiscoverCC(cardNumber, expiry, cardHolderName);


        // Handle the case where none of the conditions are met
        return null; // or throw an exception
    }
}