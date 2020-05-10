package uuu.vgb.test;

public class TestCasting_Promotion {

	public static void main(String[] args) {
		byte y =5;
		int i=15;
		int j=i;
		double x=j;//Promotion,小記憶體搬到大的
		long z=y;
		char a=(char)y;//casting
		short b=y;
		float c=z;
		String id=new String("A123456789");
		char idcharAt1=id.charAt(1);//字元轉整數
		int idnumAt1=idcharAt1-'0';//字元0=49，故全部數字需-48('0')
		System.out.println(idnumAt1);
		System.out.println(b);
		
		
	}

}