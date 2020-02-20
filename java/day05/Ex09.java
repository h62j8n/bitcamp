class Ex09 {
public static void main(String[] args) {


System.out.println("-------");
// Q1. Q2.
int length = 'Z'-'A'+1;
int gap = 'a'-'A';
for (int i=0; i<length; i++) {
	System.out.print((char)('A'+i)+"("+(char)('A'+i+gap)+") ");
}
System.out.println("\n-------");



// Q3-1.
for (int i=1; i<=4; i++) {
	for (int j=1; j<=i; j++) {
		System.out.print("* ");
	}
	System.out.println();
}
System.out.println("-------");

// Q3-2.
int num = 1;
for (int i=1; i<5; i++) {
	for (int j=0; j<i; j++) {
		System.out.print(num+" ");
		num++;
		if (num == 10) {
			num %= 10;
		}
	}
	System.out.println();
}

/*
개행 규칙
1		1+2
2 3		3+3
4 5 6		6+4
7 8 9 0		10+5
*/

System.out.println("-------");



// Q3-3.
for (int i=1; i<=4; i++) {
	for (int j=1; j<=i; j++) {
		System.out.print(j+" ");
	}
	System.out.println();
}
System.out.println("-------");



// #Q3-3.
String tmp = "";
for (int i=1; i<5; i++) {
	tmp+=i;
	System.out.println(tmp);
}
System.out.println("-------");



// Q3-4.
for (int i=1; i<=4; i++) {
	for (int j=i; j>=1; j--) {
		System.out.print(j+" ");
	}
	System.out.println();
}
System.out.println("-------");



// Q3-5.
char ch = 'A';
for (int i=0; i<5; i++) {
	for (int j=0; j<i; j++) {
		System.out.print(ch+" ");
		ch++;
	}
	System.out.println();
}
System.out.println("\n-------");

}
}