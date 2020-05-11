package uuu.vgb.test;


import java.util.List;

import uuu.vgb.entity.Product;
import uuu.vgb.entity.VGBException;
import uuu.vgb.service.ProductService;

public class TestProductService {

	public static void main(String[] args) {
		ProductService ps =new ProductService();
		try {
			List<Product> list =ps.searchAllProducts();
			System.out.println(list);
		} catch (VGBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
