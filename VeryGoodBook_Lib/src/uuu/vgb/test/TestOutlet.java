package uuu.vgb.test;

import uuu.vgb.entity.Outlet;

public class TestOutlet {

	public static void main(String[] args) {
		Outlet outlet=new Outlet();
		outlet.setId(2);
		outlet.setName("野貓軍團總動員(5冊)");
		outlet.setUnitPrice(1400);
		outlet.setStock(12);
		outlet.setPhotoUrl("https://im1.book.com.tw/image/getImage?i=https://www.books.com.tw/img/001/080/30/0010803058.jpg");
		outlet.setDescription("野貓軍團再次引爆你的歡笑！\r\n"+"沒有最搗蛋，只有更搗蛋，野貓軍團出動！");
		outlet.setDiscount(34);
		

//		System.out.println("id: "+outlet.getId());
//		System.out.println("名稱: "+outlet.getName());
//		System.out.println("定價: "+outlet.getListPrice());
//		System.out.println("庫存: "+outlet.getStock());
//		System.out.println("圖片: "+outlet.getPhotoUrl());
//		System.out.println("描述: "+outlet.getDescription());
//		System.out.println("折扣: "+outlet.getDiscountString());
//		System.out.println("售價: "+outlet.getUnitPrice());	
		System.out.println(outlet);//等同呼叫outlet.toString()
//		System.out.println(outlet.toString());
	}

}
