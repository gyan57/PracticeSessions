package hackerRank;

import java.util.Scanner;

public class ConsecutiveCount {

public static void countConsecutive(int n) {
        
        int maxCount = 0;
        int curruentCount = 0;
        int remainder = 0;
        
        while (n > 0) {
            
            remainder = n % 2;
            n = n / 2;
            System.out.println(remainder);
            if(remainder == 1) {
                curruentCount++;
                if(curruentCount > maxCount )
                    maxCount = curruentCount;
            } else {
                curruentCount = 0;
            }   
        }
        
        System.out.println(maxCount);
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        countConsecutive(n);
        in.close();
    }
}
