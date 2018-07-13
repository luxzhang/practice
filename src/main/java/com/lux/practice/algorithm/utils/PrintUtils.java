package com.lux.practice.algorithm.utils;

public class PrintUtils {

	public static void printIntegerArray(Integer a[][], int row, int col){
	    for(int i=1; i<=row+1; i++){
	        for(int j=1; j<=col+1; j++){
	            if(i==1){
	                if(j==col+1)
	                    break;
	                System.out.print("  " + j);
	                continue;
	            }
	            else{
	                if(j==1)
	                    System.out.print(i-1+" ");
	                else{
	                    System.out.print(a[i-2][j-2] + "  ");
	                }
	            }
	        }
	        System.out.println();
	    }
	}
}
