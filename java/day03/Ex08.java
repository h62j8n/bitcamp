class Ex08 {
public static void main(String[] args) {

String title = "�����������α׷�";

int kor = 86;
int eng = 93;
int math = 74;

int sum = kor+eng+math;
double avg = sum*100/3/100.0; // �Ҽ� ��°�ڸ�
char grade = 'F';

System.out.println("\n-------------------------");
System.out.println("|\t"+title+"|");
System.out.println("-------------------------");
System.out.println("| ���� :\t"+kor+"\t|");
System.out.println("| ���� :\t"+eng+"\t|");
System.out.println("| ���� :\t"+math+"\t|");
System.out.println("-------------------------");
System.out.println("| �հ� :\t"+sum+"\t|");
System.out.println("-------------------------");
System.out.println("| ��� :\t"+avg+"\t|");
System.out.println("-------------------------");

switch (sum/3/10) { // == (int)avg/10
	case 10:
	case 9:
		grade = 'A';
		break;
	case 8:
		grade = 'B';
		break;
	case 7:
		grade = 'C';
		break;
	case 6:
		grade = 'D';
		break;
	default:
		break;
}

System.out.println("| ���� :\t"+grade+"����\t|");
System.out.println("-------------------------");

}
}