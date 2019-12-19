package ch12.generic_ex;

import java.util.ArrayList;

/*class Box<T> {
	ArrayList<T> list = new ArrayList<T>();					// A. 한 가지 타입만 저장할 수 있도록 제네릭 
	
	void add(T item) {
		list.add(item);
	}
	T get(int i) {
		return list.get(i);
	}
	ArrayList<T> getList() {
		return list;
	}
	int size() {
		return list.size();
	}
	public String toString() {
		return list.toString();
	}
}
interface Sound {}													// 제네릭클래스 Box를 상속받고
class MusicBox<T extends Music & Sound> extends Box<T> {			// B. Music클래스와 상속관계이고 Sound인터페이스와 구현관계인
}																	// 타입들 중에서 한 가지 타입만 저장할 수 있도록 제네릭
class Fruit {
	public String toString() {return "Fruit";}
}
class Orange extends Fruit {
	public String toString() {return "Orange";}
}
class Mango extends Fruit {
	public String toString() {return "Mango";}
}
class Music implements Sound {
	public String toString() {return "Music";}
}
class Jazz extends Music {
	public String toString() {return "Jazz";}
}


public class GenericEx {
	public static void main(String[] args) {
		Box<Fruit> myFruit = new Box<Fruit>();					// A1. 제네릭 기본 : Box타입 객체 생성 (Fruit타입만 접근 가능)
		myFruit.add(new Fruit());
		myFruit.add(new Mango());								// A1> 다형성

		Box<Jazz> myJazz = new Box<>();							// A2. 제네릭 생략 : Box타입 객체 생성 (Jazz타입만 접근 가능)
		myJazz.add(new Jazz());
		
		Box myTrash = new Box();								// A3. 제네릭 없음 : Box타입 객체 생성
		myTrash.add(new Fruit());								// A3> 모든 타입 접근 가능
		myTrash.add(new Orange());
		myTrash.add(myJazz);
		
		Box<Fruit> anyMusic1 = new Box<Fruit>();
		anyMusic1.add(new Orange());								// 기껏 만든 뮤직박스에 오렌지를 담고 싶지 않다.
//		MusicBox<Orange> anyMusic2 = new MusicBox<>();			// B1. 제네릭 제한 : MusicBox타입 객체 생성 불가
		MusicBox<Jazz> myMusic = new MusicBox<Jazz>();			// B1> MusicBox타입 객체 생성 (Music타입과 관련된 타입만 접근 가능)
		
		System.out.println("in fruitBox : "+myFruit);
		System.out.println("in trashBox : "+myTrash);
		System.out.println("in trashBox : "+myMusic);
	}
}*/
