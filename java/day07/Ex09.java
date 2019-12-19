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
	System.out.println(scNum+"번\t| "+kor+"점\t| "+eng+"점\t| "+sum+"점\t| "+avg+"점");
  }
}

class Ex09 {
  public static void main(String[] args) {
	java.util.Scanner scan = new java.util.Scanner(System.in);

	Ex09Student s1 = new Ex09Student();
	Ex09Student s2 = new Ex09Student();
	Ex09Student s3 = new Ex09Student();

	System.out.println("----------------------------------------");
	System.out.println("학생 성적 관리 프로그램 (v 0.0.2)");
	System.out.println("----------------------------------------");

	System.out.print("1: 입력 2: 보기 0: 종료\n>");
	int input = scan.nextInt();
	int inputN, inputK, inputE;

	while (input != 0) {
		if (input == 1) { // 1: 입력
			System.out.print("학번 (1: 1번 2: 2번 3: 3번)\n>");
			inputN = scan.nextInt();

			System.out.print(inputN+"번학번 국어:\n>");
			inputK = scan.nextInt();
			System.out.print(inputN+"번학번 영어:\n>");
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
			System.out.println("학번\t| "+"국어\t| "+"영어\t| "+"합계\t| "+"평균");
			System.out.println("----------------------------------------");
			s1.showStudent();
			s2.showStudent();
			s3.showStudent();
			System.out.println("----------------------------------------");
		}

		System.out.print("1: 입력 2: 보기 0: 종료\n>");
		input = scan.nextInt();
	}
	System.out.println("이용해주셔서 감사합니다.");
  }
}