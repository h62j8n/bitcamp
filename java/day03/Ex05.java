class Ex05 {
public static void main(String[] args) {

int a = -9;

if (a >= 0 && a%2 == 0) {
	System.out.println("����� ¦��");
} else if (a >= 0 && a%2 == 1) {
	System.out.println("����� Ȧ��");
} else if (a%2 == 0) { // ����� �ƴ� �͸� �����´�
	System.out.println("������ ¦��");
} else { // ����� �ƴϰ� ¦���� �ƴ� �͸� �����´�
	System.out.println("������ Ȧ��");
}

}
}