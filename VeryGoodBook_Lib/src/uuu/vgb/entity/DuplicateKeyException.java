package uuu.vgb.entity;

public class DuplicateKeyException extends VGBException {
	private final String keyColumnName;
	//新增時才會發生重複id 主鍵值重複
	//錯誤欄位
	//無參數建構式 錯誤訊息 錯誤訊息+底層的錯誤

	public String getKeyColumnName() {
		return keyColumnName;
	}

	public DuplicateKeyException(String keyColumnName) {
		super();
		this.keyColumnName=keyColumnName;
		// TODO Auto-generated constructor stub
	}

	public DuplicateKeyException(String message, Throwable cause,String keyColumnName) {
		super(message, cause);
		// 
		this.keyColumnName=keyColumnName;
	}

	public DuplicateKeyException(String message,String keyColumnName) {
		super(message);
		// TODO Auto-generated constructor stub
		this.keyColumnName=keyColumnName;
	}
	

}
