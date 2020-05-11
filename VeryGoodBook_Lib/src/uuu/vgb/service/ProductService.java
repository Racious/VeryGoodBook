package uuu.vgb.service;

import java.util.List;

import uuu.vgb.entity.Product;
import uuu.vgb.entity.VGBException;

public class ProductService {
	
	ProductsDAO dao = new ProductsDAO();//代理人模式 delegation model
	
	public List<Product> searchAllProducts() throws VGBException {
		//資料庫查詢		
		return dao.selectAllProduct();
	}
}
