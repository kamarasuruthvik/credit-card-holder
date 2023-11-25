import java.util.ArrayList;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    
    ArrayList<ArrayList<String>> dataStore = new ArrayList<>();
    CardFactory fc = new CardFactory();

    File file = new File("input_file-1.csv");
    Scanner sc = new Scanner(file);

    // Skip header if present
    if (sc.hasNextLine()) {
      sc.nextLine();
    }

    while (sc.hasNextLine()) {
      String line = sc.nextLine();
      String[] values = line.split(",");
      ArrayList<String> temp = new ArrayList<>();
      for (String value : values) {
        temp.add(value.trim());
        System.out.print(value.trim() +" ");
      }
      System.out.println();
      dataStore.add(temp);
    }
    sc.close(); 



    CreditCard cc = fc.createCard("894589382845");
    cc.printCardName();
  }
}
