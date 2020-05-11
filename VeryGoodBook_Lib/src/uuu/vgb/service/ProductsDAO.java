package uuu.vgb.service;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import uuu.vgb.entity.Outlet;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.VGBException;

class ProductsDAO {

	private static final String SELETE_ALL_PRODUCTS ="SELECT" + 
			" id, name, unit_price, stock, photo_url, discount, class_name, category" + 
			" FROM products";
	
	//查詢只會有資料庫的錯
	public List<Product> selectAllProduct() throws VGBException{
		List<Product> list=new ArrayList<Product>();
		
		try (
			//1.2 建立連線 完成後需關掉需寫在()裡面
			Connection connection = RGBConnection.getConnection();
			//3.準備指令
			PreparedStatement pstmt=connection.prepareStatement(SELETE_ALL_PRODUCTS);
			ResultSet rs =pstmt.executeQuery();//4準備指令
		){
			//5.處理rs
			while(rs.next()) {
				Product p;
				String className=rs.getString("class_name");
				if("Outlet".equals(className)) {
					p =new Outlet();
					((Outlet)p).setDiscount(rs.getInt("discount"));
				}else {
					p=new Product();
				}
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setUnitPrice(rs.getDouble("unit_price"));
				p.setStock(rs.getInt("stock"));
				p.setPhotoUrl(rs.getString("photo_url"));
				p.setCategory(rs.getString("category"));
				list.add(p);
			}
			
		} catch (SQLException e) {
			throw new VGBException("查詢全部產品失敗",e);
		}
		
		return list;
	}
	
	
	
}
