package uuu.vgb.test;

import uuu.vgb.entity.Product;

public class TestProduct {

	public static void main(String[] args) {
		Product product= new Product();
		product.setId(1);
		product.setName("裝睡的人叫不醒，再不清醒窮死你");
		product.setPhotoUrl("https://www.books.com.tw/img/001/083/35/0010833595.jpg");
		product.setStock(10);
		product.setUnitPrice(80);
		product.setDescription("專治想太美、玻璃心、懷才不夠的軟爛巨嬰，\r\n"+"打醒滿足於小確幸、成天白日夢的昏庸腦袋！");
		
		System.out.println(product.getId());
		System.out.println(product.getName());
		System.out.println(product.getPhotoUrl());
		System.out.println(product.getStock());
		System.out.println(product.getUnitPrice());
		System.out.println(product.getDescription());
	}

}
