package desktop.fdsf;

import java.util.Scanner;

public class Primeno {
	public static void main(String[] args) {
		Primeno primeno = new Primeno();
		primeno.triangleReverse(5);
		primeno.prmeNos(100);

	}

	public void triangle(int rows) {

		for (int i = 1; i <= rows; i++) {

			for (int space = 1; space <= rows - i; space++) {
				System.out.print("  ");
			}

			for (int j = 1; j <= 2 * i - 1;j++) {
				System.out.print("* ");
			}

			System.out.println();
		}
	}

	public void triangleReverse(int n) {
		int rows = n;
		for (int i = rows; i >= 1; i--) {
			
			for (int space = 1; space <= rows - i; space++) {
				System.out.print("  ");
			}

			for (int j = 0; j <= 2 * i - 2;j++) {
				System.out.print("* ");
			}

			System.out.println();
		}
	}

	public static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		for (int i = 2; i < Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public void prmeNos(int prime){
		int n=prime;
		
		for(int i=1;i<=n;i++){
			int temp = 0;
			for(int j=2;j<=i-1;j++){
				if(i%j==0){
					temp=temp+1;
				}
			}
				if(temp==0){
					System.out.println("prime no is----> "+i);
				}
				else{
					temp=0;
				}
			}
		}
		
}
