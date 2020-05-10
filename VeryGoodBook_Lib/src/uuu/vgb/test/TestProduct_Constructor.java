package uuu.vgb.test;

import uuu.vgb.entity.Product;

public class TestProduct_Constructor {

	public static void main(String[] args) {
		Product product= new Product(1,"裝睡的人叫不醒，再不清醒窮死你",80);
//		product.setId(1);
//		product.setName("裝睡的人叫不醒，再不清醒窮死你");
//		product.setUnitPrice(80);
		product.setStock(10);
		product.setDescription("專治想太美、玻璃心、懷才不夠的軟爛巨嬰，\r\n"+"打醒滿足於小確幸、成天白日夢的昏庸腦袋！");
		product.setPhotoUrl("https://www.books.com.tw/img/001/083/35/0010833595.jpg");	
		
		System.out.println("id: "+product.getId());
		System.out.println("Name: "+product.getName());
		System.out.println("Url: "+product.getPhotoUrl());
		System.out.println("Stock: "+product.getStock());
		System.out.println("Price: "+product.getUnitPrice());
		System.out.println("Description: "+product.getDescription()+"\n");
		
		Product product2=new Product(2,"武漢封城日記",100,20);
		System.out.println("id: "+product2.getId());
		System.out.println("Name: "+product2.getName());
		System.out.println("Url: "+product2.getPhotoUrl());
		System.out.println("Stock: "+product2.getStock());
		System.out.println("Price: "+product2.getUnitPrice());
		System.out.println("Description: "+product2.getDescription());
	}

}
//Java been
//提供public無參數建構子
//屬性不得宣告public，最好是private
//為屬性提供正確的數值
//