package uuu.vgb.test;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.VIP;

public class Test_Get_Class {

	public static void main(String[] args) {
		Object o=new Object();
		Customer c=new Customer();
		VIP v=new VIP();
		//左邊的變數一定要是右邊類別建起來的物件，getclass左邊是據點，所以左邊不能是null，需另外提供檢查方法
		System.out.println(o!=null && o.getClass()==Object.class);
		System.out.println(o!=null && o.getClass()==Customer.class);
		System.out.println(o!=null && o.getClass()==VIP.class);
		System.out.println();
		//因為是多型 所以下層型別的物件無法參考上層類別的物件，故編譯失敗
		//System.out.println(c!=null && c.getClass()==Object.class);
		System.out.println(c!=null && c.getClass()==Customer.class);//True
		System.out.println(c!=null && c.getClass()==VIP.class);//False
		System.out.println();
		//System.out.println(v!=null && v.getClass()==Object.class);
		//System.out.println(v!=null && v.getClass()==Customer.class);
		System.out.println(v!=null && v.getClass()==VIP.class);//Ture
		System.out.println("\n=========================\n");
	}

}
