package uuu.vgb.test;

import java.util.Random;
import java.util.Scanner;

public class TestGuess {

	public static void main(String[] args) {
		Scanner req = new Scanner(System.in);
		Random random = new Random();
		int guess = 0, ans,number=1;
		ans = random.nextInt(10) + 1;
//		System.out.println(ans);

		do {
			if(number>3) {
				System.out.println("猜錯了 答案是 "+ans);
				return;
			}
			System.out.println("猜第"+number+"次"+" 請輸入一個數字1~10");
			guess=req.nextInt();
			number+=1;
		} while (guess!=ans);
		System.out.println("答對了，答案是"+ans);
		
//		while (guess!=ans) {
//			if (number>3) {
//				System.out.println("猜錯了　答案是"+ans);
//				return;
//			}
//			System.out.println("猜第"+number+"次");
//			number+=1;
//			guess=req.nextInt();
//			if(guess==ans) {
//				return;
//			}else {
//				System.out.println("猜錯了");
//			}
//			
//		}
//		System.out.println("猜錯了，您輸入的數字是" + guess);
	
		
	}
	
	
}
