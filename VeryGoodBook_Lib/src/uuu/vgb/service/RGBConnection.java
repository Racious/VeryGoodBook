package uuu.vgb.service;

import java.sql.*;

import uuu.vgb.entity.VGBException;

class RGBConnection {
	// 不能在static 屬性中載入non static屬性，故需加上static
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	// 新版本須加上serverTimezone=CST，指令需依照指定的資料庫更動
	private static final String url = "jdbc:mysql://localhost:3306/vgb?serverTimezone=CST";
	private static final String user = "root";// 資料庫設定的登入名稱
	private static final String password = "85054728";// sql設定的密碼

	// 每個方法都沒設定(預設)只能拋出Error,RuntimeException，故需另外宣告(Error,RuntimeException可不寫)
	public static Connection getConnection() throws VGBException {
		// 連上資料庫有可能會錯，必須加上try catch
		try {
			Class.forName(driver); // 1.載入JDBC Driver
			try {
				Connection connection = DriverManager.getConnection(url, user, password);// 2. 建立連線
				return connection;// 建立連線沒有失敗則回傳資訊 因為要回傳 所以不要主動關掉
			} catch (SQLException e) {
				throw new VGBException("建立連線失敗: ", e);
				// 需設計全新的類別回傳商業邏輯出錯的訊息，通知前端用
			}

		} catch (ClassNotFoundException e) {
				throw new VGBException("無法載入JDBC Driver: ", e);
		}
		// return null;// 方法結束前回傳null 因回傳null會無法辨別問題，故需另外設計錯誤類別回傳

	}

//	public static void main(String[] args) {
//		try (Connection connection = RGBConnection.getConnection();// 1.2取得連線
//		) {
//			System.out.println(connection.getCatalog());
//		} catch (VGBException e) {
//			// 處理conneection的錯
//			//e.printStackTrace();
//			System.out.println(e);
//		} catch (SQLException e1) {
//			// 處理getCatalog的錯
//			//e1.printStackTrace();
//			System.out.println(e1);
//		}
//		System.out.println("The End");
//	}
}
//RTFSC RTFM
/*
 * Error compiler不會提醒，亦不可處理 VM 伺服器處理
 * 
 * 語法錯誤 compiler會提醒，編譯時期錯誤
 * 
 * 方法內的敘述式有錯
 *
 * 
 * 句點左邊是null，會發生NullPointrtException RuntimeException
 * 可利用程式技巧事前防範不會發生，故compiler不會提醒
 * ClassCast、NullPointrt、Arithmetic、ArrayIndexOutOfBonds、
 * 
 * 
 * 
 */
