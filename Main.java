import java.io.*;  
import java.util.*;  

public class Main {
    public static void main(String args[]) throws Exception{
        //parsing a CSV file into Scanner class constructor
        File file = new File("input_file-1.csv");
        // System.out.println(file.exists());
        Scanner sc = new Scanner(file);  
        System.out.println(sc.nextLine());
        sc.useDelimiter(",");   //sets the delimiter pattern  
        while (sc.hasNext()){  //returns a boolean value  
            System.out.print(sc.next());  //find and returns the next complete token from this scanner  
        }   
        sc.close();  //closes the scanner   
    }
}
