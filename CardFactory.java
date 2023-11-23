public class CardFactory {
    public CreditCard createCard(String CardNumber){
        return new VisaCC();
    }
}
