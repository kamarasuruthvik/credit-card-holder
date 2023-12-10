public class ErrorChecker {
    public String isAccountNumber(String accountNumber){
        if (accountNumber.length() > 19) {
            return "Invalid: more than 19 digits";
        }
        else if (accountNumber.length() < 1) {
            return "Invalid: empty/null card number";
        }
        else if (!accountNumber.matches("\\d+")) {
            return "Invalid: non numeric characters";
        }
        else
            return "";
    }

    public String isValidCC(CreditCard cc){
        if(cc==null)
            return "Invalid: not a possible card number";
        return "";
    }
}
