package uuu.vgb.service;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.VGBException;
import uuu.vgb.entity.VIP;
import uuu.vgb.entity.testproduct;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.regexp.internal.recompile;

class CustomerSearch {
    // 資料庫存取程式 可不加public
    // static final 常數 習慣全大寫，底線斷字
    private static final String SELECT_CUSTOMER_BY_GENDER = "SELECT id, password, name," + " gender, email, birthday,"
            + " phone, address, married, discount, class_name" + " FROM customers WHERE gender=?";

    public List<Customer> selectCustomerByGender(String gender) throws VGBException {
        List<Customer> customerList = new ArrayList<Customer>();
        try (Connection connection = RGBConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(SELECT_CUSTOMER_BY_GENDER);
        ) {
            pstmt.setString(1, gender);
            try (
                    ResultSet rs = pstmt.executeQuery();
            ) {
                while (rs.next()) {
                    String className = rs.getString("class_name");
                    Customer c=new Customer();
                    if ("VIP".equals(className)){
                        c =new VIP();
                        ((VIP) c).setDiscount(rs.getInt("discount"));
                    }
                    c.setId(rs.getString("id"));
                    c.setPassword(rs.getString("password"));
                    c.setName(rs.getString("name"));
                    c.setGender(rs.getString("gender").charAt(0));
                    c.setEmail(rs.getString("email"));
                    c.setBirthday(rs.getString("birthday"));//日期用字串讀出來
                    c.setPhone(rs.getString("phone"));
                    c.setAddress(rs.getString("address"));
                    c.setMarried(rs.getBoolean("married"));
                    customerList.add(c);

                }
            }
        } catch (SQLException e) {
            throw new VGBException("查詢客戶失敗", e);
        }
        return customerList;

    }

	private static final String SELECT_PRODUCT = "SELECT id, name,"
			+ " price, releasedate"
			+ " FROM product "
			+ " WHERE name like ?";
	
	public List<testproduct> search(String search) throws VGBException {
		List<testproduct> productlist = new ArrayList<>();
		
		
		try (
			Connection connection = RGBConnection.getConnection();
			PreparedStatement pstmt=connection.prepareStatement(SELECT_PRODUCT);
		){
			pstmt.setString(1, '%' + search + '%');
			try (
				ResultSet rs=pstmt.executeQuery();
			){
				while (rs.next()) {
					testproduct tp=new testproduct();
					tp.setId(rs.getInt("id"));
					tp.setName(rs.getString("name"));
					tp.setPrice(rs.getInt("price"));
					tp.setReleasedate(rs.getString("releasedate"));
					productlist.add(tp);
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new VGBException("查詢產品失敗", e);
			
		}
		
		return productlist;
	}
}
