package hackerRank;

import java.util.Scanner;

public class SherlcokArray {
	
	public static void checkSherlock(int[] array) {
        
        int arrayLength = array.length;
        int addOnLeft = 0;
        int addOnRight = 0;
        int arrayEnd = array.length-1;
        String finalVerdict = "NO";
        if(arrayLength == 1) {
        	finalVerdict="YES";
        } else if(arrayLength == 2) {
        	finalVerdict="NO";
        }{
        	/*for(int i= 1; i<arrayLength; i++) {
                addOnLeft += array[i-1];
                addOnRight = 0;
                for(int j = i+1; j<arrayLength; j++){
                    addOnRight += array[j];
                    if(addOnLeft > addOnRight){
                        continue; 
                    } else if(addOnLeft < addOnRight && j<arrayEnd) {
                        break;
                    } else if(addOnLeft == addOnRight && j==arrayEnd) {
                        finalVerdict = "YES";
                    } 
                }
            }*/
        	int i = 0;
            int j = array.length - 1;
            int sum = 0;
            while (i != j) {
                if(sum >= 0) {
                    sum -= array[j];
                    j--;
                } else {
                    sum +=array[i];
                    i++;
                }
            }
            if(sum == 0) {
            	finalVerdict = "YES";
            }
        }
         
        System.out.println(finalVerdict);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numberOfArray = 0;
        int arraySize = 0;
        Scanner scan = new Scanner(System.in);
        numberOfArray = scan.nextInt();
        for(int i=0; i<numberOfArray; i++) {
            arraySize = 0;
            arraySize = scan.nextInt();
            int[] array = new int[arraySize];
            for(int j=0; j<arraySize; j++) {
                array[j] = scan.nextInt();
            }
            checkSherlock(array);
        }
        scan.close();
	}

}
