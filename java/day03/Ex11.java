class Ex11 {
public static void main(String[] args) {
System.out.println("\n-----------------------");

// Q1.
int q1 = 0;
for (int i=1; i<=100; i++) {
	q1 += i;
}
System.out.println(q1);
System.out.println("-----------------------");

// Q2.
for (int i=1; i<10; i+=2) {
	System.out.print(i+" ");
}
System.out.println("\n-----------------------");

// Q3.
int q3 = 1;
for (int i=1; i<=5; i++) {
	q3 = q3*2;
	System.out.print(q3+" ");
}
System.out.println("\n-----------------------");

// Q4.
int q4 = 0;
for (int i=1; i<=5; i++) {
	q4 += 2;
	System.out.print(q4);
	if (i<5) {
		System.out.print(" + ");
	}
}
System.out.println("\n-----------------------");

// Q5.
int numQ5 = 0;
int sumQ5 = 0;
for (int i=1; i<=5; i++) {
	numQ5 += 2;
	sumQ5 += numQ5;

	System.out.print(numQ5);

	if (i<5) {
		System.out.print(" + ");
	} else {
		System.out.print(" = "+sumQ5);
	}
}
System.out.println("\n-----------------------");

}
}