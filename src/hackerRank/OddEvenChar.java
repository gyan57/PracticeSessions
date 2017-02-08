package hackerRank;

import java.util.Scanner;

public class OddEvenChar {

public static void printOddEvenChar(String inputString){
        
        char[] inputChar = inputString.toCharArray();
        char[] finalString = new char[inputString.length() + 1];
        int odd = 0;
        if(inputString.length()%2 == 1) {
        	odd = (inputString.length() + 1)/2;
        } else {
        	odd = inputString.length()/2;
        }
        
        int even = 0;
        finalString[odd] = ' ';
        
        for(int i = 0; i < inputString.length(); i++) {
            if(i%2 == 1) {
            	odd += 1;
                finalString[odd] = inputChar[i];
            } else {
            	finalString[even++] = inputChar[i];
            }
        }
        String output = new String(finalString);
        System.out.println(output);
            
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named OddEvenChar. */
        //Scanner scan = new Scanner(System.in);
        //int numberOfEntry = scan.nextInt();
        //for(int i = 0; i < numberOfEntry; i++) {
           // String entryString = scan.next();
            //printOddEvenChar("ioquosuotmwqxsywsyusy");
    	printOddEvenChar("Hacke");
        //}
        //scan.close();
    }
}
