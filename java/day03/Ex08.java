class Ex08 {
public static void main(String[] args) {

String title = "성적관리프로그램";

int kor = 86;
int eng = 93;
int math = 74;

int sum = kor+eng+math;
double avg = sum*100/3/100.0; // 소수 둘째자리
char grade = 'F';

System.out.println("\n-------------------------");
System.out.println("|\t"+title+"|");
System.out.println("-------------------------");
System.out.println("| 국어 :\t"+kor+"\t|");
System.out.println("| 수학 :\t"+eng+"\t|");
System.out.println("| 영어 :\t"+math+"\t|");
System.out.println("-------------------------");
System.out.println("| 합계 :\t"+sum+"\t|");
System.out.println("-------------------------");
System.out.println("| 평균 :\t"+avg+"\t|");
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

System.out.println("| 학점 :\t"+grade+"학점\t|");
System.out.println("-------------------------");

}
}