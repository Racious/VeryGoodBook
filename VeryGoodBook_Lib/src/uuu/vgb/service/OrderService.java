package uuu.vgb.service;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Outlet;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.VIP;

public class OrderService {
	public double order(Customer c, Product p, int quantity) {
		double amount = p.getUnitPrice()*quantity;


		if(c instanceof VIP && !(p instanceof Outlet)){
			VIP v =(VIP) c;
			amount=amount*(v.getDiscount())/100;
		}
		return amount;

	}

//	public double order(VIP v, Product p, int quantity) {
//		double amount=p.getUnitPrice()*quantity*v.getDiscount()/100;
//		return amount;
//
//	}
}
