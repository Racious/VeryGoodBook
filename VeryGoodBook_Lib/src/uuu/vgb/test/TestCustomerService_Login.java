package uuu.vgb.test;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.VGBException;
import uuu.vgb.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

import com.sun.java_cup.internal.runtime.virtual_parse_stack;

public class TestCustomerService_Login {

	public static void main(String[] args) {
		CustomerService service=new CustomerService();
		try {
			//Customer c =service.login("A129128471", "123456");
			List<Customer> a=service.login("A129128471", "123456","z");
			if (a.size()==0){
				System.out.println("查無資訊");
			}else{
//				for (int i=0;i<a.size();i++) {
//					System.out.println((i+1)+"."+a.get(i).getName());
//				}
				List<Customer> b=new ArrayList<Customer>();
				b.add(a.get(0));
				System.out.println(b);
			}


		}catch(VGBException e) {
			e.printStackTrace();
		}
		
		

	}

}
