package Ujian2;

import java.util.Scanner;
import java.lang.Math; 

public class Main {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Platfon = ");
		double platfon = sc.nextInt();
		System.out.print("Bunga = ");
		double bunga = sc.nextDouble();
		System.out.print("Lama Pinjaman = ");
		double lama = sc.nextInt();
		
		angsuran(platfon, bunga, lama);
		
	}
	
	static void angsuran(double platfon, double bunga, double lama) {
		
		for (int x = 1; x <= lama; x++) {
			
			System.out.println("=======================");
			System.out.println("Angsuran Bulan Ke" +x);
			
			double v = (1 + (bunga / 12));
	        double t = (-(lama / 12) * 12);
	        double totalangsuran = (platfon * (bunga / 12)) / (1 - Math.pow(v, t));
	        System.out.println("Total Angsuran =" +totalangsuran);
	        
	        /*double totalangsuran = bunga * platfon * (Math.pow(((1+ bunga)),lama))/(Math.pow(((1+ bunga)),lama)-1);
			System.out.println("Total Angsuran =" +totalangsuran);*/
		
	        /*double totalangsuran = platfon * bunga / lama;
			System.out.println(totalangsuran);*/
			
			double angsuranbunga = platfon * bunga / lama;
			System.out.println("Angsuran Bunga =" +angsuranbunga);
			
			double angsuranpokok = totalangsuran - angsuranbunga;
			System.out.println("Angsuran Pokok =" +angsuranpokok);
			
			double sisapinjaman = platfon - angsuranpokok;
			System.out.println("Sisa Pinjaman =" +sisapinjaman);
			
		}
		
	}

}
