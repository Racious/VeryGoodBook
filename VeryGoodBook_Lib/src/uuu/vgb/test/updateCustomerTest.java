package uuu.vgb.test;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.VGBException;
import uuu.vgb.service.CustomerService;

public class updateCustomerTest {

	public static void main(String[] args) {

		CustomerService service =new CustomerService();
	try {
		//修改前
		Customer c=service.login("A109478667", "123456");
		System.out.println("\n修改前"+c);

		c.setBirthday("2012-12-12");
		c.setAddress("美好世界獻上祝福");
		c.setPhone("0910234567");
		service.update(c);
		System.out.println("\n修改後"+c);
		
		//修改前
		Customer c2=service.login("A109478667", "123456");
		System.out.println("\n登入後"+c2);
		} catch (VGBException e) {
			// DateTimeException
			e.printStackTrace();
		}
	}

}
