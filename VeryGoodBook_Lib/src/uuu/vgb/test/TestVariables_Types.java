package uuu.vgb.test;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

import uuu.vgb.entity.Customer;

public class TestVariables_Types {

	public static void main(String[] args) throws Exception {
		Customer c = new Customer();
		c.setId("A123456789");
		System.out.println(c.getId());

		Date today1 = new Date();
		System.out.println("today1: " + today1);
		Date past1 = new GregorianCalendar(1999, 1 - 1, 1).getTime();
		System.out.println("past1: " + past1);
		Date future1 = new GregorianCalendar(2090, 6 - 1, 6).getTime();
		System.out.println("future1: " + future1);

		LocalDate today = LocalDate.now();
		System.out.println("today: " + today);
		LocalDate past = LocalDate.of(1999, 1, 1);
		System.out.println("past: " + past);
		LocalDate future = LocalDate.parse("2090-06-06");
		System.out.println("future: " + future);

		byte a = 10;// 十進位
		System.out.println(a);
		short b = 0b0000_1111;// 二進位
		System.out.println(b);
		int d = 01_0000_0000;// 八進位
		System.out.println(d);// 16777216
		long e = 0xcafe;// 十六進位
		System.out.println(e);// 51966
		long money = 250_000_000L;// 2億5千萬 因數值預設int，需加上L改為long
		System.out.println(money);
		float f = 1.0f - 0.8f;// IEEE 754演算法
		System.out.println(f);// 0.19999999
		double g = 1.0 - 0.8;
		System.out.println(g);// 0.19999999999999996
		NumberFormat nf = NumberFormat.getInstance(); // 需要import
		nf.setMaximumFractionDigits(4);// 小數點最多4位 台灣2
		nf.setMinimumFractionDigits(2);// 小數點最少2位 台灣0
		System.out.println(nf.format(f));// 0.20
		System.out.println(nf.format(g));// 0.20

		float f1 = 0.1f + 0.1f + 0.1f;
		System.out.println(f1);
		double g1 = 0.1 + 0.1 + 0.1;
		System.out.println(g1);
		System.out.println(nf.format(f1));// 0.30
		System.out.println(nf.format(g1));// 0.30
		System.out.println(Double.MAX_VALUE);
		System.out.println(Double.MIN_VALUE);

		int x, y, z;
		System.out.println(x = 100);
		y = x;
		z = x + y;
		System.out.println(y);
		System.out.println(z);

	}

}
