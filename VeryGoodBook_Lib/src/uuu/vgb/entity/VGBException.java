package uuu.vgb.entity;

public class VGBException  extends Exception{

	public VGBException() {
		super();
	}

	public VGBException(String message, Throwable cause) {
		super(message, cause);
	}

	public VGBException(String message) {
		super(message);
	}

	
}

/*資料庫的錯大部分通知開發人員或系統管理員
 * 類別需繼承Throwable，該物件才能throw，
 * 故繼承Exception
 * 底層的錯，設計Exception
 * 資料庫 底層的檢查
 */
 