class Ex08 {
  public static void main(String[] args) {
	int limit = 6;

	// Q1.
	System.out.println("Q1.");
	for (int i=1; i<limit; i++) {
		for (int j=1; j<=i; j++) {
			System.out.print("★");
		}
		System.out.println();
	}
	System.out.println("===============");

	// Q2.
	System.out.println("Q2.");
	for (int i=limit; i>1; i--) {
		for (int j=1; j<i; j++) {
			System.out.print("★");
		}
		System.out.println();
	}
	System.out.println("===============");

	// Q3.
	System.out.println("Q3.");
	for (int i=1; i<limit; i++) {
		for (int j=limit-1; j>i; j--) {
			System.out.print(" ");
		}
		for (int j=1; j<=i; j++) {
			System.out.print("★");
		}
		System.out.println();
	}
	System.out.println("===============");
	for (int i=0; i<limit; i++) {
		for (int j=0; j<limit; j++) {
			if (j<limit-i-1) {
				System.out.print(" ");
			} else {
				System.out.print("★");
			}
		}
		System.out.println();
	}
	System.out.println("===============");
	// Q4.
	System.out.println("Q4.");
	for (int i=limit; i>1; i--) {
		for (int j=limit; j>i; j--) {
			System.out.print(" ");
		}
		for (int j=1; j<i; j++) {
			System.out.print("★");
		}
		System.out.println();
	}
	System.out.println("===============");

	// Q5.
	System.out.println("Q5.");
	for (int i=1; i<limit; i++) {
		for (int j=limit-1; j>i; j--) {
			System.out.print(" ");
		}
		for (int j=1; j<=2*i-1; j++) {
			System.out.print("★");
		}
		System.out.println();
	}
	System.out.println("===============");

	// Q6.
	System.out.println("Q6.");
	limit = 1000000;
	double temp = 0;
	for(int i=1; i<limit; i++) {
		int j=i+1;
		temp += (double)i/j;
	}
	System.out.println(temp);
	System.out.println("===============");

	double result = 0.0;
	for (int i=1; i<1000000; i++) {
		// result = result+(1-1.0/(i+1));
		result += i*1.0/(i+1);
	}
	System.out.println(result);
  }
}