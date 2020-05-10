package uuu.vgb.test;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.VIP;

public class Test_Instance_of {

	public static void main(String[] args) {
		Object o=new Object();
		Customer c=new Customer();
		VIP v=new VIP();
		//左邊參考類別的變數參考的物件是不是右邊的類別或子類別建立起來的物件
		System.out.println(o instanceof Object);
		System.out.println(c instanceof Object);//Customer是Object的類別或子類別
		System.out.println(v instanceof Object);//VIP是Object的類別或子類別
		System.out.println();
		System.out.println(o instanceof Customer);//Object不是Customer的類別或子類別
		System.out.println(c instanceof Customer);//Customer是Customer的類別或子類別
		System.out.println(v instanceof Customer);//VIP是Customer的類別或子類別
		System.out.println();
		System.out.println(o instanceof VIP);//Object不是VIP的類別或子類別
		System.out.println(c instanceof VIP);//Customer不是VIP的類別或子類別
		System.out.println(v instanceof VIP);//VIP是VIP的類別或子類別
		System.out.println("\n=========================\n");
		
		Object o1=null;
		Customer c1=null;
		VIP v1=null;
		
		System.out.println(o1 instanceof Object);//做instanceof時，null 一定是false，不須格外再檢查
		System.out.println(c1 instanceof Object);
		System.out.println(v1 instanceof Object);
		System.out.println();
		System.out.println(o1 instanceof Customer);
		System.out.println(c1 instanceof Customer);
		System.out.println(v1 instanceof Customer);
		System.out.println();
		System.out.println(o1 instanceof VIP);
		System.out.println(c1 instanceof VIP);
		System.out.println(v1 instanceof VIP);
		System.out.println();
		
		//
		
	}

}
