package hackerRank;

import java.math.BigInteger;
import java.util.Scanner;

public class PrimeCount {

public static boolean isPrime(int n){
        
        for(int i=2; i<n; i++){
            if(n%i==0)
                return false;
        }
        
        return true;
    }
    
    public static int getPrimeCount(int n){
        
        int count = 0;
        
        for(int i=2; i<=n; i++){
            if(isPrime(i))
                count++;
        }
        
        return count;
    }
    
    public static BigInteger factorial(long n){
        
    	BigInteger factorial = BigInteger.ONE;
        
        for(int i=1; i<=n; i++)
            factorial = factorial.multiply(BigInteger.valueOf(i));
        
        return factorial;
    }
    
    public static BigInteger getNumberOfCombination(int brick){
        
        int numberOfSquares = brick/4;
        BigInteger combinations = BigInteger.ONE;
        for(int i = 1; i<=numberOfSquares; i++)
            {
        		int remainingBricks = brick - 4*i;
        		combinations = combinations.add(factorial(remainingBricks + i).divide((factorial(i).multiply((factorial(remainingBricks))))));
        }
        return combinations;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named OddEvenChar.         */
        int numberOfBricks = 0;
        BigInteger numberOfCombinaiton = BigInteger.ONE;
        int numberOfPrime = 0;
        int numberOfIteration = 0;
        
        Scanner scan = new Scanner(System.in);
        numberOfIteration = scan.nextInt();
        for(int i = 0; i < numberOfIteration; i++) {
            numberOfBricks = scan.nextInt();
            numberOfCombinaiton = getNumberOfCombination(numberOfBricks);
            numberOfPrime = getPrimeCount(numberOfCombinaiton.intValue());
        
            System.out.println(numberOfPrime);
        }
        scan.close();       
    }
}
