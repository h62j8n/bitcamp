class Ex05 {
  public static void main(String[] args) {

	Ex05 a = new Ex05();			// 인스턴스 생성

	a.func();				// non-static 메소드 호출
	System.out.println(a);			// 참조변수는 주소를 가리킨다.
	System.out.println(a.toString());	// 값이 아니기 때문에 자동으로 .toString()

	Ex05 b;
	b = new Ex05();				// 객체를 생성하여 참조변수 b가 가리키게 함
	System.out.println(b);
	b = new Ex05();				// 참조변수 b가 가리키는 대상을 다시 생성한 객체로 변경 (덮어쓰기)
	System.out.println(b);			// b의 우변을 덮어 썼기 때문에 b는 다른 주소를 가리키게 된다
	// 첫번째 주소값을 가리키는 참조변수는 이제 없다
	// 접근 불가능한 주소값이 되었다는 뜻으로, 가비지컬렉션에 의한 메모리 제거 대상이 된다.
  }

  public void func() { // non-static 메소드
	System.out.println("My Function");
  }
}