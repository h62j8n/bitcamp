class Ex02 {
public static void main(String[] args) {

int jStart = 2; // 2단부터
int jLimit = 9; // 9단까지
int iStart = 1; // 1부터 시작
int iLimit = 9; // 9까지 곱하기

for (int i=iStart-1; i<=iLimit; i++) { // 반복횟수(곱하는 수)
	for (int j=jStart; j<=jLimit; j++) {
		if (i == iStart-1) { // 제목
			System.out.print(j+"단\t");
		} else {
			System.out.print(j+"x"+i+"="+j*i+"\t");
		}
	}
	System.out.println();
}

}
}