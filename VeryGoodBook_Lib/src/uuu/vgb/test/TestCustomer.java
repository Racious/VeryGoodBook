package uuu.vgb.test;

//import java.time.LocalDate;

import uuu.vgb.entity.Customer;

public class TestCustomer {

	public static void main(String[] args) throws Exception {
		Customer c = new Customer();
//		c.id = "A123456789";
		c.setId("A987654321");
		//c.setPassword("123456");
		//c.setName("一二三");
		c.setGender('M');
		c.setEmail("test@gamil.com");
//		c.birthday=LocalDate.of(1999, 1, 1);
//		c.birthday=LocalDate.parse("2010-03-17");//將符合規範的字串轉為日期
//		c.setBirthday(2000,1,2);
		System.out.println(c.getBirthday());
//		c.setBirthday("2002-03-17");
		System.out.println(c.getBirthday());
		System.out.println(c.getId());
		System.out.println(c.getPassword());
		System.out.println(c.getName());
		System.out.println(c.getGender());
		System.out.println(c.getEmail());
		System.out.println(c.getBirthday());
		System.out.println(c.getPhone());
		System.out.println(c.getAddress());
		System.out.println(c.isMarried());
		
//		c.getage(c.birthday);
//		int thisyear = LocalDate.now().getYear();
//		System.out.println(thisyear);
//		int birthyear=c.birthday.getYear();
//		int age = thisyear-birthyear;
		System.out.println(c.getage());
		
		
	}

}
