class Ex06 {
public static void main(String[] args) {

int i = 0;
int j = 9;

while (i <= 9) {
	for (j=2; j<=9; j++) {
		if (i == 0) {
			System.out.print(j+"´Ü\t");
		} else {
			System.out.print(j+"x"+i+"="+j*i+"\t");
		}
	}
	System.out.println();

	i++;
}
System.out.println("--------------------------------------------------------------");

int su = 1;

while (su < 10) {
	int dan = 2;
	while (dan < 10) {
		System.out.print(dan+"x"+su+"\t");
		dan++;
	}
	System.out.println();
	su++;
}



}
}