package com.bit;

class Ex09Student {
  int scNum;
  int kor;
  int eng;
  int sum;
  double avg;

  public Ex09Student(int s, int k, int e) {
	scNum = s;
	kor = k;
	eng = e;
	sum = k+e;
	avg = (k+e)/2.0;
  }
  public void showStudent() {
	System.out.println(scNum+"��\t| "+kor+"��\t| "+eng+"��\t| "+sum+"��\t| "+avg+"��");
  }
}

class Ex09 {
  public static void main(String[] args) {
	java.util.Scanner scan = new java.util.Scanner(System.in);

	Ex09Student s1 = new Ex09Student();
	Ex09Student s2 = new Ex09Student();
	Ex09Student s3 = new Ex09Student();

	System.out.println("----------------------------------------");
	System.out.println("�л� ���� ���� ���α׷� (v 0.0.2)");
	System.out.println("----------------------------------------");

	System.out.print("1: �Է� 2: ���� 0: ����\n>");
	int input = scan.nextInt();
	int inputN, inputK, inputE;

	while (input != 0) {
		if (input == 1) { // 1: �Է�
			System.out.print("�й� (1: 1�� 2: 2�� 3: 3��)\n>");
			inputN = scan.nextInt();

			System.out.print(inputN+"���й� ����:\n>");
			inputK = scan.nextInt();
			System.out.print(inputN+"���й� ����:\n>");
			inputE = scan.nextInt();

			if (inputN == 1) {
				s1 = new Ex09Student(inputN, inputK, inputE);
			} else if (inputN == 2) {
				s2 = new Ex09Student(inputN, inputK, inputE);
			} else if (inp7utN == 3) {
				s3 = new Ex09Student(inputN, inputK, inputE);
			}
		} else if (input == 2) {
			System.out.println("----------------------------------------");
			System.out.println("�й�\t| "+"����\t| "+"����\t| "+"�հ�\t| "+"���");
			System.out.println("----------------------------------------");
			s1.showStudent();
			s2.showStudent();
			s3.showStudent();
			System.out.println("----------------------------------------");
		}

		System.out.print("1: �Է� 2: ���� 0: ����\n>");
		input = scan.nextInt();
	}
	System.out.println("�̿����ּż� �����մϴ�.");
  }
}