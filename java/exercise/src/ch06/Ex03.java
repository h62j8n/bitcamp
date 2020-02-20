package ch06;

class Student {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	
	public Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public int getTotal() {
		int result = kor+eng+math;
		return result;
	}
	public float getAverage() {
		float result = getTotal()*10/3/10.0f;
		return result;
	}
	public String info() {
		String result = name+", "+ban+", "+no+", "+kor+", "+eng+", "+math+", "+getTotal()+", "+getAverage();
		return result;
	}
}

public class Ex03 {
	public static void main(String[] args) {
		Student s = new Student("ȫ�浿", 1, 1, 100, 60, 76);
		
		System.out.println("�̸� : "+s.name);
		System.out.println("���� : "+s.getTotal());
		System.out.println("��� : "+s.getAverage());
		System.out.println(s.info());
	}
}
