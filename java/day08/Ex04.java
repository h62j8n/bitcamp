package com.bit;
class Ex04 {
  public static void main(String[] args) {

	Ex04Car my = new Ex04Car("���");	// 4 Ex04Car(String model) �����ڸ� ���� �ν���Ʈ ����
	my.show();
	my.speedUp();
	my.show();
	my.speedDown();
	my.show();

	Ex04Kia my2 = new Ex04Kia();		// �ڽ�Ŭ������ �ν��Ͻ��� ������ �� �θ�Ŭ������ �ν��Ͻ��� ������
	my2.show();
	my2.speedUp();
	my2.show();
	my2.speedUp();
	my2.show();
	my2.speedDown();
	my2.show();
	my2.speedDown();
	my2.show();
  }
}

class Ex04Kia extends Ex04Car {			// 5 Ex04CarŬ������ ��ӹ޴� Ex04KiaŬ���� ����
	String company = "���";
	int durability = 0; // ������

	public Ex04Kia () { // ������
		super("�߰���");
	}

	public void show() {				// �θ��� �޼ҵ带 ���׷��̵��ϴ� �޼ҵ� �������̵�
		System.out.println("������ "+durability+"�� "+company+" ȸ���� "+model+"(��)�� "+speed+"km�� �޸���");
	}
}

class Ex04Car {
	  int speed;						// 1 �ʵ� ����
	  String model;

	  public Ex04Car() {				// 2 ������ (�����ε�)
		this("�¿���");
		// ��ü�� ������ �� �𵨸� ���ڸ� ���� ���� ���
		// �𵨸� "�¿���"�� �ο��ϴ� ���ÿ� Ex04Car(String model) ȣ��,
		// Ex04Car(String model)�� speed ���� ����
	  }
	  public Ex04Car(String model) {
		this.model = model;
		speed = 0;
		// ��ü�� ������ �� �𵨸� ���ڸ� ���� ���
	  }

	  public void show() {				// 3 �޼ҵ�
		System.out.println(model+"(��)�� "+speed+"km�� �޸���");
	  }
	  public void speedUp() {
		speed += 10;
	  }
	  public void speedDown() {
		speed -= 10;
	  }
	}
