class Ex03 {

public static void main(String[] args) {

for (int i=0; i<5; i++) {
	if (i>2) {continue;}
	System.out.println(i+1+"번째 반복");
}
System.out.println("main end");

for (int i=0; i<5; i++) {
	if (i>2) {break;}
	System.out.println(i+1+"번째 반복");
}
System.out.println("main end");

for (int i=0; i<5; i++) {
	if (i>2) {return;}
	System.out.println(i+1+"번째 반복");
}
System.out.println("main end");

}
}