class Ex02 {
public static void main(String[] args) {

int jStart = 2; // 2�ܺ���
int jLimit = 9; // 9�ܱ���
int iStart = 1; // 1���� ����
int iLimit = 9; // 9���� ���ϱ�

for (int i=iStart-1; i<=iLimit; i++) { // �ݺ�Ƚ��(���ϴ� ��)
	for (int j=jStart; j<=jLimit; j++) {
		if (i == iStart-1) { // ����
			System.out.print(j+"��\t");
		} else {
			System.out.print(j+"x"+i+"="+j*i+"\t");
		}
	}
	System.out.println();
}

}
}