class Ex02 {
public static void main(String[] args){

int a;
a = 100;

a++;
System.out.println(a);
// 대입연산자 없이 사용할 때엔 전위 후위의 구분이 무색하다.

a = ++a;
System.out.println(a);
// 리터럴 연산(a+1) 후 변수 a에 저장

a = a++;
System.out.println(a);
// 변수 a에 리터럴 (a) 저장 후 연산(a+1)

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