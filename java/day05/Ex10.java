class Ex10 {
public static void main(String[] args) {

java.util.Scanner sc = new java.util.Scanner(System.in);


System.out.println("---------------------------------");
System.out.println("가위 바위 보 게임(v0.0.1)");
System.out.println("---------------------------------");

// 사용자 값
System.out.print("1: 가위 2: 바위 3: 보 0: 종료\n>");
int user = sc.nextInt();

int totalCount = 0; // 총 횟수
int winCount = 0; // 이긴 횟수
int loseCount = 0; // 진 횟수
int drawCount = 0; // 비긴 횟수
double winningRate = 0; // 승률

while (true) {
	if (user != 0) {
		// 컴퓨터 값
		// 0*3+1 <= Math.random()*3+1 < 1*3+1
		int num = (int)(Math.random()*3)+1;
		
		// 값 출력
		System.out.println("computer: "+print(num)+", \tyou: "+print(user));

		// 결과 계산
		result(num, user);

		if (result(num, user) == 1) {
			System.out.println("이겼습니다!");
			winCount++;
		} else if (result(num, user) == 2) {
			System.out.println("졌습니다.");
			loseCount++;
		} else if (result(num, user) == 3) {
			System.out.println("비겼습니다.");
			drawCount++;
		}
		totalCount++;
		winningRate = (double)winCount/totalCount*100;

		// 사용자 값
		System.out.print("1: 가위 2: 바위 3: 보 0: 종료\n>");
		user = sc.nextInt();
	} else {
		System.out.println("이용해주셔서 감사합니다.");
		System.out.println("---------------------------------");
		System.out.println("총 "+totalCount+"회, 승률 "+winningRate+"%, "+winCount+"승 "+drawCount+"무 "+loseCount+"패");
		System.out.println("---------------------------------");

		break;
	}
}

} // main end

// 가위바위보 결과 계산
public static int result(int num, int user) {
	int matchPoint = 0;
	if (user == 2 && num == 1 || user == 3 && num == 2 || user == 1 && num == 3) {
		matchPoint = 1;
	} else if (user == 1 && num == 2 || user == 2 && num == 3 || user == 3 && num == 1) {
		matchPoint = 2;
	} else {
		matchPoint = 3;
	}
	return matchPoint;
} // result end

// 사용자 값, 컴퓨터 값 출력
public static String print(int value) {
	String card = "";
	switch (value) {
		case 1:
			card = "가위";
			break;
		case 2:
			card = "바위";
			break;
		case 3:
			card = "보";
			break;
		default:
			break;
	}
	return card;
} // print end
}