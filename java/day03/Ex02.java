class Ex02 {
public static void main(String[] args){

int a;
a = 100;

a++;
System.out.println(a);
// ���Կ����� ���� ����� ���� ���� ������ ������ �����ϴ�.

a = ++a;
System.out.println(a);
// ���ͷ� ����(a+1) �� ���� a�� ����

a = a++;
System.out.println(a);
// ���� a�� ���ͷ� (a) ���� �� ����(a+1)

a+=10;
System.out.println(a);
System.out.println("--------------------");

System.out.println(3+2-100*2>2*2-9%2);
// 3+2-(100*2) > (2*2)-(9%2)

int b = 2;
System.out.println(b == 3-1);
System.out.println(b != 3-1);
System.out.println("--------------------");

System.out.println(true && true);
System.out.println(true && false);
System.out.println(false && false);

System.out.println(true || true);
System.out.println(true || false);
System.out.println(false || false);
System.out.println("--------------------");

System.out.println(!true);
System.out.println(!false);

}
}