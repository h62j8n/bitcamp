package ch06;

public class Ex09 {
	int x=0, y=0;					// ��ǥ
	int hp = 60;					// ���� ü��
	static int weapon = 6;					// ���ݷ�
	static int armor = 0;					// ����
	
	void weaponUp() {
		weapon++;
	}
	void armorUp() {
		armor++;
	}
	void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public static void main(String[] args) {
		System.out.print("Ŭ���� ���� : weapon, armor");
		System.out.println("\n : � ����(�ν��Ͻ�)�� ���� ���ݷ°� ������ ���´�.");
	}
}
