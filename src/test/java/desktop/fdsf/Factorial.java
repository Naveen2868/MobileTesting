package desktop.fdsf;

public class Factorial {
	int rem, sum = 0;
	int n = 17;
	int temp;
	int count = 0;

	public static void main(String[] args) {
		Factorial f = new Factorial();
		f.factorial(5);
		//f.primeno(120);
		/*f.primeno(111);
		f.primeno(11);
		f.primeno(13);*/
	}

	public int primeno(int n) {
		for (int i = 2; i < n / 2; i++) {
			if (n % i == 0) {
				count++;
				System.out.println(i);
				System.out.println(n + " is not prime number");
			 break;
			}
		}
		if (count == 0) {
			System.out.println(n + " is prime number");
		}

		return count;
	}

	public void armstrongnumber() {
		temp = n;
		while (n != 0) {
			rem = n % 10;
			sum = sum + (rem * rem * rem);
			n = n / 10;
		}
		if (temp == sum)
			System.out.println("armstrongnumber number ");
		else
			System.out.println("not armstrongnumber");

	}

	public void palindrome() {
		temp = n;
		while (n > 0) {
			rem = n % 10;
			sum = (sum * 10) + rem;
			n = n / 10;
		}
		if (temp == sum)
			System.out.println("palindrome number ");
		else
			System.out.println("not palindrome");

	}

	public void factorial(int n) {
		int sum = 0;
		while (n != 0) {
			rem = n % 10;
			int f = 1;
			for (int i = 1; i <= rem; i++) {
				f = f*i;
			}
			sum = sum + f;
			n = n / 10;
		}
		System.out.println("factorial of the given no: " + sum);
	}

	public void reverse() {
		while (n != 0) {
			rem = n % 10;
			sum = sum * 10 + rem;
			n = n / 10;
		}
		System.out.println("reverse of the given no: " + sum);
	}

}
