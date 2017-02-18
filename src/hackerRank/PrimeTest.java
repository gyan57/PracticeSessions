package hackerRank;

import java.util.Scanner;

public class PrimeTest {

	public static void checkPrime(int x){
        
        boolean prime = true;
		
        if(x == 2 || x== 3 || x == 5) {
            prime = true;
        } /*else if(x == 1 || x%2 == 0 || x%5 == 0 || x%3 == 0) {
            System.out.println("Not prime");
        } else if((x+1)%6 == 0 || (x-1)%6 == 0 ) {
           System.out.println("Prime"); 
        }
*/      
		for(int i=2; i*i <=x;i++) {
			if(x%i==0) {
				prime = false;
			} 
		}
		
		if(prime) {
			System.out.println("Prime");
		} else {
			System.out.println("Not prime");
		}
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
        int loopCount = scan.nextInt();
        int variable = 0;
        for(int i=0;i<loopCount; i++){
            variable = scan.nextInt();
            checkPrime(variable);
        }
        scan.close();
	}

}
