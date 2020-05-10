package uuu.vgb.service;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.DuplicateKeyException;
import uuu.vgb.entity.VGBException;
import java.sql.*;

class CustomersDAO {
	// 資料庫存取程式 可不加public
	// static final 常數 習慣全大寫，底線斷字
	private static final String SELECT_CUSTOMER_BY_ID = "SELECT id, password, name," + " gender, email, birthday,"
			+ " phone, address, married " + " FROM customers "
			+ " WHERE (id=? or email=?)";
	
	// 對的查回來 錯的傳錯誤資訊
	public Customer selectCustomerById(String id) throws VGBException {
		Customer c = null;// 預設客戶查不到null
		try (Connection connection = RGBConnection.getConnection(); // 1,2取得連線
				// 有問號需要PreparedStatement傳值，準備指令
				PreparedStatement pstmt = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);// 3準備指令
		) {
			// 3.1傳入?的值 第一個問號，傳入id的值
			pstmt.setString(1, id);
			pstmt.setString(2, id);
			//ResultSet 結果
			try (
					ResultSet rs = pstmt.executeQuery();//4.執行指令
			){
				// 5.讀取rs中的資料
				//找出來開標指向before 資料數 若沒資料會指向after false
				while(rs.next()) {
					c=new Customer();
					c.setId(rs.getString("id"));
					c.setPassword(rs.getString("password"));
					c.setName(rs.getString("name"));
					c.setGender(rs.getString("gender").charAt(0));
					c.setEmail(rs.getString("email"));
					c.setBirthday(rs.getString("birthday"));//日期用字串讀出來
					c.setPhone(rs.getString("phone"));
					c.setAddress(rs.getString("address"));
					c.setMarried(rs.getBoolean("married"));
				}
			}
		} catch (SQLException ex) {
			throw new VGBException("查詢客戶失敗", ex);
		}

		return c;
	}
	//若前後字串無符號則要加上空白
	private static final String INSERT_Customer ="INSERT INTO customers "
			+ "(id, password, name, gender, email, birthday, phone, address, married)"
		    + "VALUES(?,?,?,?,?,?,?,?,?)";

	public void insert(Customer c) throws VGBException{
		try (
			Connection connection = RGBConnection.getConnection();//1.2 建立連線
			PreparedStatement pstmt = connection.prepareStatement(INSERT_Customer);//3.準備指令
			){
			//3-1.傳入問號的值
			pstmt.setString(1,c.getId());
			pstmt.setString(2,c.getPassword());
			pstmt.setString(3,c.getName());
			pstmt.setString(4,c.getGender()+"");//轉字串String.valueOf() or+""
			pstmt.setString(5,c.getEmail());
			//若生日為非必填可null，需修改成c.getBirthday==null?null:String.valueOf(c.getBirthday())
			pstmt.setString(6,String.valueOf(c.getBirthday()));
			pstmt.setString(7,c.getPhone());
			pstmt.setString(8,c.getAddress());
			pstmt.setBoolean(9,c.isMarried());
			
			//4.執行指令1 
			pstmt.executeUpdate();
			//寫入時若發生錯誤 
		} catch (SQLException e) {
			// SQLIntegrityConstraintViolationException shift+f1可看相關說明
			// 若發生主鍵值重複 或其他寫入時發生的錯誤
			if(e instanceof SQLIntegrityConstraintViolationException ) {
				String keyColumn=null;
				//indexOf e的錯誤字串中查詢指定"email"出現的位子 
				if(e.getMessage().indexOf("email_UNIQUE")>0) {
					keyColumn="email";
					//若是主鍵值重複
				}else if(e.getMessage().indexOf("PRIMARY")>=0) {
					keyColumn="身分證";
				}
				if(keyColumn!=null) {
					throw new DuplicateKeyException("新增客戶失敗: "+keyColumn+"已重複註冊",e,keyColumn);
				}
				//e是最底層的訊息 程式人員的錯或資料庫的錯  e.getMessage會顯示系統提示訊息，e.getErrorCode會顯示錯誤代碼
			}
				throw new VGBException("新增客戶失敗"+e.getMessage()+e.getErrorCode(),e);
			
		}
		
	} 
	
	private static final String UPDATE_CUSTOMER="UPDATE customers" + 
			" SET password=?, name=?, gender=?, email=?, birthday=?, phone=?, address=?, married=?" + 
			" WHERE id = ?;";

	public void update(Customer c) throws VGBException{
		try (
			Connection connection = RGBConnection.getConnection();//1.2 建立連線
			PreparedStatement pstmt = connection.prepareStatement(UPDATE_CUSTOMER);//3.準備指令
			){
			//3-1.傳入問號的值
			pstmt.setString(1,c.getPassword());
			pstmt.setString(2,c.getName());
			pstmt.setString(3,c.getGender()+"");
			pstmt.setString(4,c.getEmail());//轉字串String.valueOf() or+""
			pstmt.setString(5,String.valueOf(c.getBirthday()));
			//若生日為非必填可null，需修改成c.getBirthday==null?null:String.valueOf(c.getBirthday())
			pstmt.setString(6,c.getPhone());
			pstmt.setString(7,c.getAddress());
			pstmt.setBoolean(8,c.isMarried());
			pstmt.setString(9,c.getId());
			
			//4.執行指令1 
			pstmt.executeUpdate();
			//寫入時若發生錯誤 
		} catch (SQLException e) {
			// SQLIntegrityConstraintViolationException shift+f1可看相關說明
			// 若發生主鍵值重複 或其他寫入時發生的錯誤
			if(e instanceof SQLIntegrityConstraintViolationException ) {
				String keyColumn=null;
				//indexOf e的錯誤字串中查詢指定"email"出現的位子 
				if(e.getMessage().indexOf("email_UNIQUE")>0) {
					keyColumn="email";
					//若是主鍵值重複
				}
				if(keyColumn!=null) {
					throw new DuplicateKeyException("修改客戶失敗: "+keyColumn+"已重複",e,keyColumn);
				}
				//e是最底層的訊息 程式人員的錯或資料庫的錯  e.getMessage會顯示系統提示訊息，e.getErrorCode會顯示錯誤代碼
			}
				throw new VGBException("修改客戶失敗"+e.getMessage()+e.getErrorCode(),e);
			
		}
		
	}
	
}
