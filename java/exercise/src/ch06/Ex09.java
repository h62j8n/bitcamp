package ch06;

public class Ex09 {
	int x=0, y=0;					// 좌표
	int hp = 60;					// 현재 체력
	static int weapon = 6;					// 공격력
	static int armor = 0;					// 방어력
	
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
		System.out.print("클래스 변수 : weapon, armor");
		System.out.println("\n : 어떤 병사(인스턴스)라도 같은 공격력과 방어력을 갖는다.");
	}
}
