package hackerRank;

import java.util.*;
import java.util.regex.*;

public class RegexMatch {
	
	 public static boolean validMail(String firstName, String emailID) {
	        
	        Pattern name = Pattern.compile("[a-z]{0,20}");
	        Pattern email = Pattern.compile("[a-z.]{0,50}@gmail.com");
	        Matcher nameMatch = name.matcher(firstName);
	        Matcher emailMatch = email.matcher(emailID);
	        boolean nameB = nameMatch.matches();
	        boolean emailB = emailMatch.matches();
	        
	        if(nameB && emailB) {
	            return true;
	        }
	        
	        return false;
	    }

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int N = in.nextInt();
	        String[] nameArray = new String[N];
	        int counter = -1;
	        for(int a0 = 0; a0 < N; a0++){
	            String firstName = in.next();
	            String emailID = in.next();
	            if(validMail(firstName , emailID)) {
	                ++counter;
	                nameArray[counter] = firstName;
	            }
	        }
	        String[] finalArray = new String[counter+1];
	        for(int i=0;i<=counter; i++) {
	            finalArray[i] = nameArray[i];
	        }
	        Arrays.sort(finalArray);
	        for(String name : finalArray) {
	            System.out.println(name);
	        }
	    }

}
