class Ex06 {
public static void main(String[] args) {

int kor = 86;
int eng = 93;
int math = 74;

int sum = kor+eng+math;
double avg = sum/3.0;
char grade = 'A';

System.out.println("����: "+kor);
System.out.println("����: "+eng);
System.out.println("����: "+math);
System.out.println("�հ�: "+sum);
System.out.println("���: "+avg);

System.out.print("����: ");
if (avg >= 90 && avg <= 100) {
} else if (avg >= 80 && avg < 90) {
	grade+=1;
} else if (avg >= 70 && avg < 80) {
	grade+=2;
} else if (avg >= 60 && avg < 70) {
	grade+=3;
} else {
	grade+=4;
}
System.out.println(grade);

}
}