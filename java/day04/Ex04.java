class Ex04 {
public static void main(String[] args) {

// Q1. 1~100ÀÇ ÇÕ
int i = 0;
int q1 = 0;

while (i <= 10) {
	q1 += i;
	i++;
}
System.out.println(q1);
System.out.println("--------------------------------------------");

// Q2. 10~50ÀÇ Â¦¼öÀÇ ÇÕ
i = 10;
int q2 = 0;

while (i <= 50) {
	if (i%2 == 0) {
		q2 += i;
	}
	i++;
}
System.out.println(q2);
System.out.println("--------------------------------------------");

// Q3. "1+3+5+7+9=25"
i = 1;
int q3 = 0;

while (i<10) {
	if (i%2 != 0) {
		System.out.print(i);
		q3 += i;
	} else {
		System.out.print(" + ");
	}
	i++;
}
System.out.println(" = "+q3);
System.out.println("--------------------------------------------");

// Q4. 1~50 Áß 3ÀÇ ¹è¼ö Ãâ·Â
i = 1;
int limit = 50;

while (i != limit+1) {
	if (i != 0 && i%3 == 0) {
		System.out.print(i+" ");
	}
	i++;
}
System.out.println("\n--------------------------------------------");

// Q5. 2ÀÇ1Á¦°ö, 2Á¦°ö, 3Á¦°ö, 4Á¦°ö, 5Á¦°ö
i = 0;
int q5 = 2;

while(i < 5) {
	q5 += q5;
	System.out.print(q5+" ");
	i++;
}
System.out.println("\n--------------------------------------------");

}
}