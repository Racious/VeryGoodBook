package uuu.vgb.entity;

public class DataInvalidException extends RuntimeException {
	//客戶資料檢查 三種建構式 
	
	public DataInvalidException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DataInvalidException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public DataInvalidException(String message) {
		super(message);
		
	}

	

}
