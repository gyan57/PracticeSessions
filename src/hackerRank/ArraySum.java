package hackerRank;

import java.util.Scanner;

public class ArraySum {
	
	public static void hourGlass(int arr[][]) {
        int maxSum = -63;
        int arrSum = 0;
        int array[][] = new int[3][3];
        int x = arr.length;
        int y = arr[0].length;
        for(int i=0; i<x - 2; i++) {
            for(int j=0; j< y - 2; j++) {
            	arrSum = 0;
                for(int k=0; k<3; k++) {
                	for(int l=0;l<3;l++ ) {
                		array[k][l] = arr[i+k][j+l];
                        array[1][0] = 0;
                        array[1][2] = 0;
                        
                        arrSum += array[k][l];
                	}
                }
                pritnArray(array);
                System.out.println(arrSum);
                System.out.print("\n");
                if(arrSum > maxSum)
            		maxSum = arrSum;
            }
        }
        
        System.out.print(maxSum);
    }
	
	public static void pritnArray(int arr[][]) {
		for(int i=0; i < 3; i++){
			System.out.print("\n");
            for(int j=0; j < 3; j++){
                System.out.print(arr[i][j]);
            }
		}
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }
        
        hourGlass(arr);
    }

}
