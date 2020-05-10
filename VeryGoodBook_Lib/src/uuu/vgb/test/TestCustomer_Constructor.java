package uuu.vgb.test;

//import java.time.LocalDate;

import uuu.vgb.entity.Customer;

public class TestCustomer_Constructor {

	public static void main(String[] args) throws Exception {
		Customer c = new Customer("a12323123","987654","我是男生");
//		c.id = "A123456789";
//		c.setId("A987654321");
//		c.setPassword("123456");
//		c.setName("一二三");
//		c.setGender('M');
		c.setEmail("test@gamil.com");
//		c.birthday=LocalDate.of(1999, 1, 1);
//		c.birthday=LocalDate.parse("2010-03-17");//將符合規範的字串轉為日期
//		c.setBirthday(2000,1,2);
		System.out.println(c.getBirthday());
//		c.setBirthday("2002-03-17");
		System.out.println(c.getBirthday());
		System.out.println("id: "+c.getId());
		System.out.println("password: "+c.getPassword());
		System.out.println("name: "+c.getName());
		System.out.println("性別: "+c.getGender());
		System.out.println("Email: "+c.getEmail());
		System.out.println("生日: "+c.getBirthday());
		System.out.println("電話: "+c.getPhone());
		System.out.println("地址: "+c.getAddress());
		System.out.println("是否已婚: "+c.isMarried());
		
//		c.getage(c.birthday);
//		int thisyear = LocalDate.now().getYear();
//		System.out.println(thisyear);
//		int birthyear=c.birthday.getYear();
//		int age = thisyear-birthyear;
		System.out.println("年齡: "+c.getage()+"\n");
		
		Customer c2 = new Customer("A21365987","112233","我是女生",'F');
		System.out.println("id: "+c2.getId());
		System.out.println("password: "+c2.getPassword());
		System.out.println("name: "+c2.getName());
		System.out.println("性別: "+c2.getGender());
		System.out.println("Email: "+c2.getEmail());
		System.out.println("生日: "+c2.getBirthday());
		System.out.println("電話: "+c2.getPhone());
		System.out.println("地址: "+c2.getAddress());
		System.out.println("是否已婚: "+c2.isMarried());

	}

}
