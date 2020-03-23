package com.fin.festa.model.entity;

public class PageSearchVo {		//�˻� & ������ 

	private String search;		//���� �˻�
	private String keyword;		//�ش� �˻���
	private String category;	//������������ �Ű��ʿ� �����޴�(�׷�,ķ����,���ǵ�,�׷��ǵ�,�����ǵ�,����)
	private int check;			//������������ �Ű��� �з�(������=1,ó���Ϸ�=2)
	private int startnum;		//�������� �Խñ� ����(����)
	private int endnum;			//�������� �Խñ� ����(��)
	
	private int page;			//���� ������ ����Ʈ1  (10�� �ο츦 ��ȸ�Ҷ� ���� ������)  
	private int page2;			//���� ������ ����Ʈ1  (5�� �ο츦 ��ȸ�Ҷ� ���� ������)
	private int page3;			//���� ������ ����Ʈ1  (6�� �ο츦 ��ȸ�Ҷ� ���� ������)
	private int page4;			//�ǵ��� ����Ҷ� ���� ������
	private int displayRow=10;	//�� �������� row����
	private int totalCount;		//��ü �Խñۼ�
	private int beginPage;		//��ȭ�鿡 ���̴� ù������
	private int endPage;		//��ȭ�鿡 ���̴� ������������
	private int displayRow2=5;	//�� �������� row����
	private int displayRow3=6;	//�� �������� row����
	private int displayPage=5;	//��ȭ�鿡 ���̴� �� ����������
	boolean prev;				//prev ��ư Ȱ��ȭ
	boolean next;				//next ��ư Ȱ��ȭ
	private int totalPage;
	


	//�Ķ���ͷ� �������� �����ö� �ڵ������� �ο찹�� ���� 10���ο�˻�
	public void setPage(int page) {
		this.page = page;
		startnum=(page-1)*10+1;
		endnum=page*10;
	}
	
	//�Ķ���ͷ� �������� �����ö� �ڵ������� �ο찹�� ���� 5���ο�˻�
	public void setPage2(int page2) {
		this.page2 = page2;
		startnum=(page2-1)*5+1;
		endnum=page2*5;
	}
	
	//�Ķ���ͷ� �������� �����ö� �ڵ������� �ο찹�� ���� 6���ο�˻�
	public void setPage3(int page3) {
		this.page3 = page3;
		startnum=(page-1)*6+1;
		endnum=page*6;
	}

	//�Ķ���ͷ� �ǵ��� �������� �����ö� �ڵ������� �ο찹�� ����(�ǵ��۴�����)
	public void setPage4(int page4) {
		this.page4 = page4;
		startnum=page4*3-2;
		endnum=page4*3;
	}
	
	
	//���̺� �ο찹���� �ְ� ��������� ����  (10�� �ο츦 ��ȸ�Ҷ� ���� ���)
	public void setTotalCount(int totalCount){
		
		this.totalCount=totalCount;
		paging();
	}
	
	//���̺� �ο찹���� �ְ� ��������� ����  (5���� �ο츦 ��ȸ�Ҷ� ���� ���)
	public void setTotalCount2(int totalCount){
		
		this.totalCount=totalCount;
		paging2();
	}
	
	//���̺� �ο찹���� �ְ� ��������� ����  (5���� �ο츦 ��ȸ�Ҷ� ���� ���)
	public void setTotalCount3(int totalCount){
		
		this.totalCount=totalCount;
		paging3();
	}

	private void paging(){
		totalPage=totalCount/displayRow;
		
		//�ƽ������� ���� ����
		System.out.println("���������� ���� : "+(totalCount%displayRow!=0));
		if(totalCount%displayRow!=0){
			totalPage+=1;
		}
		//prev,next,beginPage,endPage�� ���
		endPage = ((page+(displayPage-1))/displayPage)*displayPage;
		beginPage = endPage - (displayPage-1);
		
		if(totalPage<endPage&&totalPage==page){
			endPage=totalPage;
			next=false;
		}else if(totalPage<endPage&&totalPage>page) {
			endPage=totalPage;
			next=true;
		}else if(totalPage==endPage&&totalPage==page){
			next=false;
		}else {
			next=true;
		}
		if(beginPage==1){
			prev=false;
		}else{
			prev=true;
		}
		//prev=(beginPage==1)?false:true;
	}
	
	private void paging2(){
		totalPage=totalCount/displayRow2;
		
		//�ƽ������� ���� ����
		System.out.println("���������� ���� : "+(totalCount%displayRow2!=0));
		if(totalCount%displayRow2!=0){
			totalPage+=1;
		}
		//prev,next,beginPage,endPage�� ���
		endPage = ((page2+(displayPage-1))/displayPage)*displayPage;
		beginPage = endPage - (displayPage-1);
		
		if(totalPage<endPage&&totalPage==page2){
			endPage=totalPage;
			next=false;
		}else if(totalPage<endPage&&totalPage>page2) {
			endPage=totalPage;
			next=true;
		}else if(totalPage==endPage&&totalPage==page2){
			next=false;
		}else {
			next=true;
		}
		if(beginPage==1){
			prev=false;
		}else{
			prev=true;
		}
		//prev=(beginPage==1)?false:true;
	}
	
	private void paging3(){
		totalPage=totalCount/displayRow3;
		
		//�ƽ������� ���� ����
		System.out.println("���������� ���� : "+(totalCount%displayRow3!=0));
		if(totalCount%displayRow3!=0){
			totalPage+=1;
		}
		//prev,next,beginPage,endPage�� ���
		endPage = ((page3+(displayPage-1))/displayPage)*displayPage;
		beginPage = endPage - (displayPage-1);
		
		if(totalPage<endPage&&totalPage==page3){
			endPage=totalPage;
			next=false;
		}else if(totalPage<endPage&&totalPage>page3) {
			endPage=totalPage;
			next=true;
		}else if(totalPage==endPage&&totalPage==page3){
			next=false;
		}else {
			next=true;
		}
		if(beginPage==1){
			prev=false;
		}else{
			prev=true;
		}
		//prev=(beginPage==1)?false:true;
	}

	@Override
	public String toString() {
		return "PageSearchVo [search=" + search + ", keyword=" + keyword + ", startnum=" + startnum + ", endnum="
				+ endnum + ", page=" + page + ", page2=" + page2 + ", page3=" + page3 + ", page4=" + page4 + ", displayRow=" + displayRow + ", totalCount="
				+ totalCount + ", beginPage=" + beginPage + ", endPage=" + endPage + ", displayRow2=" + displayRow2
				+ ", displayPage=" + displayPage + ", prev=" + prev + ", next=" + next + ", category="+ category + ", check="+ check
				+ ",totalPage=" + totalPage +"]";
	}
	
	public PageSearchVo() {
		// TODO Auto-generated constructor stub
	}
	
	

	public PageSearchVo(String search, String keyword, int startnum, int endnum, int page, int page2, int page3, int page4, int displayRow,
			int totalCount, int beginPage, int endPage, int displayRow2, int displayPage, boolean prev, boolean next, String category,
			int check, int totalPage) {
		super();
		this.search = search;
		this.keyword = keyword;
		this.startnum = startnum;
		this.endnum = endnum;
		this.page = page;
		this.page2 = page2;
		this.displayRow = displayRow;
		this.totalCount = totalCount;
		this.beginPage = beginPage;
		this.endPage = endPage;
		this.displayRow2 = displayRow2;
		this.displayPage = displayPage;
		this.prev = prev;
		this.next = next;
		this.category = category;
		this.check = check;
		this.totalPage = totalPage;
		this.page3 = page3;
		this.page4 = page4;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getStartnum() {
		return startnum;
	}

	public void setStartnum(int startnum) {
		this.startnum = startnum;
	}

	public int getEndnum() {
		return endnum;
	}

	public void setEndnum(int endnum) {
		this.endnum = endnum;
	}

	public int getPage() {
		return page;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getDisplayRow2() {
		return displayRow2;
	}

	public void setDisplayRow2(int displayRow2) {
		this.displayRow2 = displayRow2;
	}

	public int getDisplayRow() {
		return displayRow;
	}

	public void setDisplayRow(int displayRow) {
		this.displayRow = displayRow;
	}

	public int getDisplayPage() {
		return displayPage;
	}

	public void setDisplayPage(int displayPage) {
		this.displayPage = displayPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getPage2() {
		return page2;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
	}
	
	public int getPage3() {
		return page3;
	}

	public int getDisplayRow3() {
		return displayRow3;
	}

	public void setDisplayRow3(int displayRow3) {
		this.displayRow3 = displayRow3;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPage4() {
		return page4;
	}

	
	
	
}
