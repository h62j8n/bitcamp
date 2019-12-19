package ch12.generic_ex;

import java.util.ArrayList;

/*class Box<T> {
	ArrayList<T> list = new ArrayList<T>();					// A. �� ���� Ÿ�Ը� ������ �� �ֵ��� ���׸� 
	
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
interface Sound {}													// ���׸�Ŭ���� Box�� ��ӹް�
class MusicBox<T extends Music & Sound> extends Box<T> {			// B. MusicŬ������ ��Ӱ����̰� Sound�������̽��� ����������
}																	// Ÿ�Ե� �߿��� �� ���� Ÿ�Ը� ������ �� �ֵ��� ���׸�
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
		Box<Fruit> myFruit = new Box<Fruit>();					// A1. ���׸� �⺻ : BoxŸ�� ��ü ���� (FruitŸ�Ը� ���� ����)
		myFruit.add(new Fruit());
		myFruit.add(new Mango());								// A1> ������

		Box<Jazz> myJazz = new Box<>();							// A2. ���׸� ���� : BoxŸ�� ��ü ���� (JazzŸ�Ը� ���� ����)
		myJazz.add(new Jazz());
		
		Box myTrash = new Box();								// A3. ���׸� ���� : BoxŸ�� ��ü ����
		myTrash.add(new Fruit());								// A3> ��� Ÿ�� ���� ����
		myTrash.add(new Orange());
		myTrash.add(myJazz);
		
		Box<Fruit> anyMusic1 = new Box<Fruit>();
		anyMusic1.add(new Orange());								// �ⲯ ���� �����ڽ��� �������� ��� ���� �ʴ�.
//		MusicBox<Orange> anyMusic2 = new MusicBox<>();			// B1. ���׸� ���� : MusicBoxŸ�� ��ü ���� �Ұ�
		MusicBox<Jazz> myMusic = new MusicBox<Jazz>();			// B1> MusicBoxŸ�� ��ü ���� (MusicŸ�԰� ���õ� Ÿ�Ը� ���� ����)
		
		System.out.println("in fruitBox : "+myFruit);
		System.out.println("in trashBox : "+myTrash);
		System.out.println("in trashBox : "+myMusic);
	}
}*/
