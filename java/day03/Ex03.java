class Ex03 {
public static void main(String[] args) {

String title = "비트 편의점";

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
System.out.println(" 제품\t| 단가\t| 수량\t| 합계");
System.out.println("--------------------------------");
System.out.println(" 생수\t| "+water+"\t| "+waterNum+"\t| "+waterSum+"원");
System.out.println(" 바나나\t| "+banana+"\t| "+bananaNum+"\t| "+bananaSum+"원");
System.out.println(" 우유\t| "+milk+"\t| "+milkNum+"\t| "+milkSum+"원");
System.out.println("--------------------------------\n");
System.out.println(" 합계\t "+"\t "+"\t "+total+"원");
System.out.println("--------------------------------");

}
}