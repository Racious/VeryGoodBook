package uuu.vgb.test;

import java.util.Set;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.VIP;

public class TestPolymorphism {

	public static void main(String[] args) throws Exception {
		//Object 是大家的父類別，可放入所有東西
		Object obj=new Object();
		String s="Hello";
		Customer c=new Customer();
		c.setName("Raicous");
		c.setId("a123123123");
		c.setPassword("123456");
		VIP vip=new VIP();
		vip.setName("sandy");
		vip.setId("a129128471");
		vip.setPassword("qazqaz");
		vip.setDiscount(30);

		Object obj1="Hello";//多型的區域變數，String pool

		System.out.println("s: "+s);//
		System.out.println("obj1: "+obj1);//透過多型，因String覆寫Object，故使用字串的toString
		
		System.out.println(obj1);
		System.out.println("s.length()= "+s.length());
		//obj1=c;
		
		//System.out.println(obj1.length());編譯失敗 length是String定義的方法，句點左邊為Object
		System.out.println("obj1.length= "+
				(obj1 instanceof String?((String)obj1).length():0));
		System.out.println("obj1==s:"+(obj1==s));
		System.out.println("obj1==c:"+(obj1==c));
		System.out.println();
		obj1=c;
		System.out.println(obj1);//因實體為c(客戶)，故toString後會顯示客戶的toString(覆寫)
		System.out.println("obj1==s:"+(obj1==s));
		System.out.println("obj1==c:"+(obj1==c));
		//System.out.println(obj1.getName()); 編譯失敗，因getName為Customer定義的方法，但句點左邊為Object
		System.out.println("姓名:"+((Customer)obj1).getName());
		System.out.println();
		c=vip;
		System.out.println("姓名:"+c.getName());
		System.out.println(((VIP)c).getDiscountString());
		System.out.println(c);

	}

}
