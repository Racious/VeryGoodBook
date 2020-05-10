package uuu.vgb.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.VGBException;
import uuu.vgb.service.CustomerService;

public class addCustomerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer c=new Customer();
		CustomerService service =new CustomerService();
//		LocalDate date=LocalDate.now();
//		LocalTime time =LocalTime.now().withNano(0);
//		System.out.println(date);
//		System.out.println(time);
		c.setId("A109497144");
		c.setPassword("123456");
		c.setName("AAAABBB");
		c.setGender('F');
		c.setEmail("AAAABBB@gamil.com");
		c.setBirthday("2000-05-05");
		
		try {
			service.register(c);
			Customer c2=service.login("A109497144", "123456");
			System.out.println(c2);
		} catch (VGBException e) {
			// DateTimeException
			e.printStackTrace();
		}
	}

}
