class Ex08 {
	public static void main(String[] args) {
		char ch;
		ch = 'A';
		System.out.println(ch);

		ch = '\uac00';
		System.out.println(ch);

		ch = 'ㄱ';
		System.out.println(ch);

		ch = 97;
		System.out.println(ch);

		ch = 1;
		System.out.println((int)ch);		
		ch = '1';
		System.out.println((int)ch);
		// 1과 '1' 은 다르다.

		ch = '\\';
		System.out.println(ch);

		String str = "PATH=\"C:\\Program Files\\Java\\jdk1.8.0_231\\bin\"";
		System.out.println(str);
	}
}