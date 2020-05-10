package uuu.vgb.test;

import java.time.LocalDate;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Outlet;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.VIP;

public class TestEqualToOperator {

	public static void main(String[] args) throws Exception {
		String s = "Hello";
		String s1 = "Hello";//String pool
		String s2 = new String("Hello");
		System.out.println("s == s1: "+(s == s1));// true 兩個變數參考同一個物件
		System.out.println("s == s2: "+(s == s2));// false 因s2又新建立一個物件，非同一個物件，故false
		System.out.println("s.equals(s2): "+s.equals(s2));//比較兩者記憶體位子的值是否相同，句點的優先最高，優先計算
		//equals比較句點左邊參考型別跟右邊小括號物件內容是否一樣
		System.out.println("\n===============\n");
		
		LocalDate date1=LocalDate.of(2020, 3, 30);
		LocalDate date2=LocalDate.parse("2020-03-30");
		System.out.println(date1);
		System.out.println(date2);
		System.out.println(date1==date2);
		System.out.println(date1.equals(date2));
		System.out.println("\n===============\n");
		
		
		String z = null;
		String z1 = null;
		String z2=new String();
		System.out.println(z == z1);// true 兩個變數參考同一個物件
		System.out.println(z == z2);// false
				System.out.println(s+="world");//s=s+"world"
		System.out.println("\n===============\n");
		
		byte x=1;
		double y=2.0;
		double a=0.5;
		//int aa=0;		
		//aa=x+=a*2-55/y;//x=x+(1-27.5)
		System.out.println(x+=a*2-55/y);
		byte m=127;
		System.out.println(m++);//127輸出後 再+1變成-128
		System.out.println(++m);//-128+1後再輸出
		System.out.println("\n===============\n");
		
		Customer cus=new Customer("A123456789", "qazqaz", "Racious");
		Customer cus2=new Customer("A123456789", "qazqaz","Racious");
		System.out.println("cus==cus2: "+(cus==cus2));
		System.out.println(cus.equals(cus2));//false,第9、10章介紹[繼承],[多型]後才能改寫customer類別
		System.out.println(cus.getId().equals(cus2.getId()));
		System.out.println("\n===============\n");
		
		System.out.println("true & true: "+(true & true));
		System.out.println("true & false: "+(true & false));
		System.out.println("false & true: "+(false & true));
		System.out.println("false & false: "+(false & false));
		
		System.out.println("true | true: "+(true | true));
		System.out.println("true | false: "+(true | false));
		System.out.println("false | true: "+(false | true));
		System.out.println("false | false: "+(false | false));
		
		System.out.println("true ^ true: "+(true ^ true));
		System.out.println("true ^ false: "+(true ^ false));
		System.out.println("false ^ true: "+(false ^ true));
		System.out.println("false ^ false: "+(false ^ false));
		System.out.println("\n===============\n");
		
		Customer c =new Customer("A123123123", "123456", "Racious");
		Customer c2 =new Customer("A123123123", "123456", "Racious");
		System.out.println("c.equals(c2)= "+c.equals(c2));
		System.out.println("c==c2 "+(c==c2));

		System.out.println(c.getName());
		System.out.println(c.getName()==c2.getName());
		
		VIP v = new VIP();
		v.setName("Racious");
		v.setId("A123123123");
		v.setPassword("123456");
		System.out.println("c.equals(v)= "+c.equals(v));
		System.out.println(c.hashCode());
		System.out.println(c2.hashCode());
		System.out.println(v.hashCode());
	
		String t="";
		System.out.println("t!=null && t.length()>0: "+(t!=null && t.length()>0));
		System.out.println("\n===============\n");
		
		Product p=new Product();
		Outlet outlet=new Outlet();
		Outlet outlet2=new Outlet();
		p.setId(1);
		p.setName("Test");
		p.setUnitPrice(200);
		outlet.setId(1);
		outlet.setName("Test");
		outlet.setUnitPrice(200);
		outlet.setDiscount(10);
		outlet2.setId(1);
		outlet2.setName("Test");
		outlet2.setUnitPrice(200);
		outlet2.setDiscount(20);
		System.out.println("p.equals(outlet)= "+p.equals(outlet));
		System.out.println("outlet.equals(outlet2)= "+outlet.equals(outlet2));
		System.out.println("outlet.getUnitPrice= "+outlet.getUnitPrice());
		System.out.println("outlet2.getUnitPrice= "+outlet2.getUnitPrice());
		
		
		System.out.println("\n===============\n");
	 try {
		 test2(t);
		 System.out.println(t.length()>0);
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	 
	}
	
	public static void test2(String t) throws Exception {
		String tpattern="[a-zA-Z0-9]{1,3}";
		if(!(t.matches(tpattern))) {
			throw new Exception("格式錯誤唷");
		}
	}

}
