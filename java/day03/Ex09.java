class Ex09 {
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
		grade -= 1;
	case 8:
		grade -= 1; // 일치하는 case를 만났을때부터 모든 수행문 실행
	case 7:
		grade -= 1;
	case 6:
		grade -= 2;
}

System.out.println("| 학점 :\t"+grade+"학점\t|");
System.out.println("-------------------------");

}
}