package uuu.vgb.test;

import java.security.Provider.Service;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Outlet;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.VIP;
import uuu.vgb.service.OrderService;

import javax.swing.text.DefaultEditorKit;

public class TestOrderService {

	public static void main(String[] args) throws Exception {
		OrderService orderService=new OrderService();
		Customer c=new Customer("A123456789","123456","Racious");//代入建構子
		c.setName("Racious");
		Product p=new Product(1,"裝睡的人叫不醒",999);//代入建構子
		VIP vip=new VIP();
		vip.setId("a123456789");
		vip.setName("awenracious");
		vip.setDiscount(34);
		
		Outlet outlet=new Outlet();
		outlet.setId(2);
		outlet.setName("野貓軍團總動員(5冊)");
		outlet.setUnitPrice(1000);
		outlet.setDiscount(20);
		//int q=2;

		System.out.println();

		double amount =orderService.order(vip, p, 1);
		System.out.println(Math.round(amount));
		
		double amount2 =orderService.order(c, outlet, 1);
		System.out.println(amount2);
		System.out.println(vip.getPassword());
	}

}
