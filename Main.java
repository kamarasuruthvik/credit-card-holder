import java.io.*;  
import java.util.*;  

public class Main {
    public static void main(String args[]) throws Exception{       
        File file = new File("input_file-1.csv");
        Scanner sc = new Scanner(file);  
        System.out.println(sc.nextLine());
        sc.useDelimiter(",");
        while (sc.hasNext()){  
            System.out.print(sc.next());
        }   
        sc.close();

        CardFactory fc = new CardFactory();
        CreditCard cc= fc.createCard("894589382845");
        cc.printCardName();
    }
}
