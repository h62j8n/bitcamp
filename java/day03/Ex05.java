class Ex05 {
public static void main(String[] args) {

int a = -9;

if (a >= 0 && a%2 == 0) {
	System.out.println("양수인 짝수");
} else if (a >= 0 && a%2 == 1) {
	System.out.println("양수인 홀수");
} else if (a%2 == 0) { // 양수가 아닌 것만 내려온다
	System.out.println("음수인 짝수");
} else { // 양수가 아니고 짝수가 아닌 것만 내려온다
	System.out.println("음수인 홀수");
}

}
}