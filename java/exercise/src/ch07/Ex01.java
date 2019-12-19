package ch07;

// 1���� 10������ ���ڰ� ���� ī�尡 �� �־� �ְ�, 1, 3, 8�� �� �� �ϳ��� ��
class SutdaDeck {
	final int CARD_NUM = 20;			// 20��
	SutdaCard[] cards = new SutdaCard[CARD_NUM];
	
	SutdaDeck() {
	}
}

class SutdaCard {
	int num;
	boolean isKwang;
	
	SutdaCard() {
		this(1, true);
	}
	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	
	public String toString() {
		return num + (isKwang ? "K" : "");
	}
}

public class Ex01 {
	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck();
		for(int i=0; i < deck.cards.length;i++) {
			System.out.print(deck.cards[i]+",");
		}
	}
}
