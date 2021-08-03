package Ujian;

import java.util.Scanner;

public class MenggambarDenganJava {
	
	public static void main(String[] args) {
		//INPUT DISINI
		gambargabung(1, 1);
	}
	
	public static void kotak() {
		int jawab = 5;
		
		for(int x =0; x < jawab; x++) {
			for(int y=0; y < jawab; y++) {
			
			System.out.print("*");
			
		}
			System.out.println(" ");
		}
	  }
	
	public static void segitiga() {
		int panjang = 5;
		
		for(int x = 0; x < panjang; x++) {
			
			for (int y = 0; y <= x; y++) {
				
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
	
	public static void segitigaterbalik() {
		int panjang = 5;
		
		for(int x = 0; x < panjang; x++) {
			
			for (int y = panjang; y > x; y--) {
				
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
	
	public static void campur() {
		
		int panjang = 5;
		
		for (int x =0 ; x < panjang ;x ++) {
			
			for(int y = 0 ; y <= panjang; y++) {
				
				if (y<=x) {
					System.out.print("*");
				}else {
					System.out.print("#");
				}
				
				
			}
			
			System.out.println();
		
	}
	}
	
	public static void seling() {
		
		int rows = 15;
		
		   for(int q=rows; q>=1; q--){

		        if(q%2 != 0){
		            for(int r=q; r>=1; r--){
		                if(r%2 !=0){
		                	System.out.print("*");
		                }
		                else {
		                	System.out.print("!");
		                }
		            }
		        }
		        if(q%2 ==0){
		            for(int r=q; r>=1; r--){
		                if(r%2 !=0){
		                	System.out.print("!");
		                }
		                else {
		                	System.out.print("*");
		                }
		            }
		        }
		        System.out.println();
		   }
	} 
	
	/*public void gabunggambar() {
		
		int rows = 5;
		
		for (int i = 1; i <= rows; ++i) {
		      for (int j = 1; j <= i; ++j) {
		    	  System.out.print("*");

		      }
		      for(int k=rows-(i); k>=1; k--){
		    	  System.out.print("#");
		         }
		      System.out.print("\n");
		   }
		   for(int q=rows; q>=1; q--){

		        if(q%2 != 0){
		            for(int r=q; r>=1; r--){
		                if(r%2 !=0){
		                	System.out.print("*");
		                }
		                else {
		                	System.out.print("!");
		                }
		            }
		        }
		        if(q%2 ==0){
		            for(int r=q; r>=1; r--){
		                if(r%2 !=0){
		                	System.out.print("!");
		                }
		                else {
		                	System.out.print("*");
		                }
		            }
		        }
		       System.out.println();
		   }
		}*/
	
	public static void gambargabung(int baris, int kolom) {
		campur();
		seling();
	}
}
