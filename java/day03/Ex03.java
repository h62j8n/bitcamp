class Ex03 {
public static void main(String[] args) {

String title = "��Ʈ ������";

int water = 900;
int banana = 3500;
int milk = 2000;

int waterNum = 2;
int bananaNum = 1;
int milkNum = 3;

int waterSum = water*waterNum;
int bananaSum = banana*bananaNum;
int milkSum = milk*milkNum;
int total = waterSum+bananaSum+milkSum;

System.out.println("--------------------------------");
System.out.println(" "+title);
System.out.println("--------------------------------\n");
System.out.println(" ��ǰ\t| �ܰ�\t| ����\t| �հ�");
System.out.println("--------------------------------");
System.out.println(" ����\t| "+water+"\t| "+waterNum+"\t| "+waterSum+"��");
System.out.println(" �ٳ���\t| "+banana+"\t| "+bananaNum+"\t| "+bananaSum+"��");
System.out.println(" ����\t| "+milk+"\t| "+milkNum+"\t| "+milkSum+"��");
System.out.println("--------------------------------\n");
System.out.println(" �հ�\t "+"\t "+"\t "+total+"��");
System.out.println("--------------------------------");

}
}