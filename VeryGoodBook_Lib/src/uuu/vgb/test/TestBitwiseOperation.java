package uuu.vgb.test;

public class TestBitwiseOperation {

	public static void main(String[] args) {
		byte i=6,j=5;
		System.out.println(~j);//求補數 -6
		System.out.println(~i);//求補數 -7
		System.out.println(i&j);//4
		System.out.println(i|j);//7
		System.out.println(i^j);//3
		
		byte k =32;
		byte m=(byte)(k<<2);
		System.out.println(k<<2);
		System.out.println(m);
		System.out.println(k>>2);//往右移 00100000=>00001000=8
		System.out.println(-k>>2);//11100000=>11111000=-8
		System.out.println(-k<<2);//11100000=>10000000=-128
		System.out.println(k>>>2);
		System.out.println(-k>>>2);
		
		int answer=0;
		System.out.println(answer==0?"正確":"不正確");//判斷布林，True第一個選項，False第二個選項
	}

}

/*
00000110
00000101
*/