package uuu.vgb.test;

public class TestOperation {

	public static void main(String[] args) {
		System.out.println(1 + 2); // 3
		System.out.println('1' + '2'); // 字元相加49+50
		System.out.println("1" + 2); // 字串直接加在後面
		System.out.println('2' - '1');// 1
		System.out.println('b' - 'a');// 1
		System.out.println(1 / 2); // 0.5但因運算結果預設int固無小數點
		double a = 1 / 2;
		System.out.println(a);// 0.0 因運算元最大int，固無小數點
		System.out.println(1 / 2D); // 運算元型別最大為double，故0.5
		System.out.println(100000 * 20000000); // 因預設數值為int，故運算結果溢位
		System.out.println(100000L * 20000000); // 因指定型態為long，固可得答案
		byte c = 1, b = 1;
		byte d = (byte) (b + c);// 因小於int數字型態，會自動提升為int，故需castiong
		System.out.println(d);

		// String operator
		String s = "Hello";
		System.out.println(s + " World");

		String q = "123.45";
		System.out.println(q + 6);
		System.out.println(Double.parseDouble(q) + 6);
		System.out.println(Float.parseFloat(q));
		int x=10,y=20;
		System.out.println("x==y :"+(x==y));
		System.out.println("x!=y :"+(x!=y));
		System.out.println("x<y :"+(x<y));
		System.out.println("x>y :"+(x>y));
		System.out.println(x<y!=false);
		System.out.println(!(x==y));
		
	}

}