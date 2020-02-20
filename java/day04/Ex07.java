class Ex07 {
public static void main(String[] args) {

// Q1.
int i = 0;
int num = 4;
while (i < num) {
	for (int j=0; j<num; j++) {
		System.out.print("≮ ");
	}
	System.out.println();
	i++;
}
System.out.println("-------");
for (i=1; i<20; i++) {
	if (i%5 == 0) {
		System.out.println();
	} else {
		System.out.print("≮ ");
	}
}

System.out.println("\n-------");

// Q2.
i = 0;
num = 3;
int start = 1;
while (i < num) { // 技临
	for (int j=0; j<num; j++) { // 技俺
		System.out.print(start+" ");
		start++;
	}
	System.out.println();
	i++;
}

System.out.println("-------");

num = 1;
for (i=1; i<=12; i++) {
	if (i%4 == 0) {
		System.out.println();
	} else {
		System.out.print(num++ +" ");
	}
}

System.out.println("-------");

// Q3.
i = 0;
num = 3;
start = 1;
while (i < num) { // 技临
	for (int j=0; j<num; j++) { // 技俺
		System.out.print(start+" ");
		start++;
	}
	start -= (num-1);
	System.out.println();
	i++;
}

System.out.println("-------");

/*
(123 +0)
(123 +1)
(123 +2)
*/

for (i=1; i<=12; i++) {
	if (i%4 == 0) {
		System.out.println();
	} else {
		System.out.print((i%4 + i/4)+" ");
	}
}

}
}