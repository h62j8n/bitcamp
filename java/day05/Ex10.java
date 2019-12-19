class Ex10 {
public static void main(String[] args) {

java.util.Scanner sc = new java.util.Scanner(System.in);


System.out.println("---------------------------------");
System.out.println("���� ���� �� ����(v0.0.1)");
System.out.println("---------------------------------");

// ����� ��
System.out.print("1: ���� 2: ���� 3: �� 0: ����\n>");
int user = sc.nextInt();

int totalCount = 0; // �� Ƚ��
int winCount = 0; // �̱� Ƚ��
int loseCount = 0; // �� Ƚ��
int drawCount = 0; // ��� Ƚ��
double winningRate = 0; // �·�

while (true) {
	if (user != 0) {
		// ��ǻ�� ��
		// 0*3+1 <= Math.random()*3+1 < 1*3+1
		int num = (int)(Math.random()*3)+1;
		
		// �� ���
		System.out.println("computer: "+print(num)+", \tyou: "+print(user));

		// ��� ���
		result(num, user);

		if (result(num, user) == 1) {
			System.out.println("�̰���ϴ�!");
			winCount++;
		} else if (result(num, user) == 2) {
			System.out.println("�����ϴ�.");
			loseCount++;
		} else if (result(num, user) == 3) {
			System.out.println("�����ϴ�.");
			drawCount++;
		}
		totalCount++;
		winningRate = (double)winCount/totalCount*100;

		// ����� ��
		System.out.print("1: ���� 2: ���� 3: �� 0: ����\n>");
		user = sc.nextInt();
	} else {
		System.out.println("�̿����ּż� �����մϴ�.");
		System.out.println("---------------------------------");
		System.out.println("�� "+totalCount+"ȸ, �·� "+winningRate+"%, "+winCount+"�� "+drawCount+"�� "+loseCount+"��");
		System.out.println("---------------------------------");

		break;
	}
}

} // main end

// ���������� ��� ���
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

// ����� ��, ��ǻ�� �� ���
public static String print(int value) {
	String card = "";
	switch (value) {
		case 1:
			card = "����";
			break;
		case 2:
			card = "����";
			break;
		case 3:
			card = "��";
			break;
		default:
			break;
	}
	return card;
} // print end
}