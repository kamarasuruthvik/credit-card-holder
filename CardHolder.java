import java.io.*;
import java.util.*;

public class CardHolder {

  public static void main(String args[]) throws Exception {
    
    String inputFileName = "input_file.xml";
    String outputFileName = "new_output_file.xml";
    FileReaderContext fileReaderContext;
    List<String[]> dataStore;
    List<String[]> Result= new ArrayList<>();

    //Set File Context i.e .csv or .xml or .json
    if (inputFileName.endsWith(".csv")) {
      fileReaderContext = new FileReaderContext(new CSVFileReader(), inputFileName, outputFileName);
    } else if (inputFileName.endsWith(".xml")) {
      fileReaderContext = new FileReaderContext(new XMLFileReader(), inputFileName, outputFileName);
    } else {
      throw new IllegalArgumentException("Unsupported file type");
    }
    
    
    //Read from File
    dataStore = fileReaderContext.readFile("input_file.xml");

    for (String[] card : dataStore) {
      System.out.println(Arrays.toString(card));
    }  
  

    //Process the file
    ArrayList<CreditCard> cards = new ArrayList<CreditCard>();
    CardFactory fc = new CardFactory();

    String message;
    ErrorChecker e = new ErrorChecker(); //Error Checker class
    for (String[] cardData : dataStore) {
      String accountNumber = cardData[0];
      String expiry = cardData[1]; // Fixed index for expiry
      String name = cardData[2];
  
      if (!e.isAccountNumber(accountNumber).isEmpty()) {
          message = e.isAccountNumber(accountNumber);
          Result.add(new String[]{accountNumber, message }); // Header
          continue;
      }
      
      CreditCard cc = fc.createCard(accountNumber, expiry, name);
      if (cc != null) {
          cards.add(cc);
          message = cc.getCreditCardName();
      } else {
          message = "Invalid: not a possible card number"; // Assuming isValidCC returns a String
      }
      Result.add(new String[]{accountNumber, message });
    }
    

    for (String[] r : Result) {
      System.out.println(Arrays.toString(r));
    }  

    

    fileReaderContext.writeFile(Result, outputFileName);
  }

}
