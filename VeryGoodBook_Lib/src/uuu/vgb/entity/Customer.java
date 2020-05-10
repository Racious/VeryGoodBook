package uuu.vgb.entity;

import java.time.LocalDate;


public class Customer {

	public static final char MALE='M';
	public static final char FEMALE='F';
	public static final String PASSWORD_REGEXP="^[a-zA-z0-9\\/*-+]{6,20}$";
	public static final String EMAIL_REGEXP="^[a-z0-9_-]+([.a-z0-9_-])*@[a-z0-9_-]+([.a-z0-9_-]+)*$";
	public static final String ID_REGEXP="[a-zA-Z][1-2][0-9]{8}";
	
	
	private String id;// ROC ID ,PKey,required

	private String password;// 必須6~20個字元,required

	private String name;// required

	private char gender;// 'M'男生，'F'女生,required

	private String email;// required，regular expression檢查,unique index

	private LocalDate birthday;// required

	private String phone = "";// optional

	private String address = "";// optional

	private boolean married = false;// optional

	public Customer() {
	}

	public Customer(String id, String password, String name) throws Exception {
		// super();
		this.setId(id);
		this.setPassword(password);
		this.setName(name);
	}

	public Customer(String id, String password, String name, char gender) throws Exception {
		// super();
		this(id, password, name);// 參數多的呼叫參數少的,一定要寫在第一行，呼叫27行
		this.setGender(gender);
	}

	public void setId(String id) {
		Check_Customer check =new Check_Customer();
		if (id != null && id.matches(ID_REGEXP)) {
			check.checkid(id);
			this.id = id;
		} else {
			//System.out.println("身分證號碼不正確");
			// TODO:
			throw new DataInvalidException("身分證號碼不正確");
		}
	}

	public String getId() {
		return id;
	}

	public void setPassword(String password)  {
		if (password == null || !(password.matches(PASSWORD_REGEXP))) {
			throw new DataInvalidException("密碼不正確，長度必須6~20個字元");
		} else {
			this.password = password;
		}

	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		if (name == null) {
			throw new DataInvalidException("資料錯誤");
		} else if ((name=name.trim()).length()==0) {
			throw new DataInvalidException("請輸入名子");
		} else {
			this.name = name;
		}
	}

	public String getName() {
		return name;
	}

	public void setGender(char gender) {
		if(gender==MALE ||gender==FEMALE)
			this.gender = gender;
	}

	public char getGender() {
		return gender;
	}

	public void setEmail(String email) {
		if (email != null && (email.toLowerCase().matches(EMAIL_REGEXP))) {
			this.email = email;
		}else {
			throw new DataInvalidException("必須輸入正確格式的Email");
		}

	}

	public String getEmail() {
		return email;
	}

	public void setBirthday(LocalDate birthday){
		if (LocalDate.now().isAfter(birthday)) {
			this.birthday = birthday;
		}else {
			//throw new Exception("出生日不能大於今日");
			throw new DataInvalidException("客戶生日不能為未來時間");
		}
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(String date)  {
		setBirthday(LocalDate.parse(date));
	}

	public void setBirthday(int year, int month, int day) {
		setBirthday(LocalDate.of(year, month, day));
	}

	public int getage() {
		if (getBirthday() != null) {
			int thisyear = LocalDate.now().getYear();
			int birthyear = getBirthday().getYear();
			int age = thisyear - birthyear;
			return age;
		} else {
			return 0;
		}

	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	public boolean isMarried() {
		return married;
	}
	@Override
	public String toString() {
		return "\nid: " + id + "\n密碼: " + password +
				"\n姓名: " + name + "\n性別: " + gender + "\n電子信箱: "+ email +
				"\n生日: " + birthday + "\n電話: " + phone + "\n地址: " +address +
				"\n婚姻狀態: " + (married?"已婚":"未婚");
	}
//@Override
//public boolean equals(Object obj) {
//	boolean answer=false;
//	//if (this==obj) return true; 若是跟自己比較可提早確認，增加效率
//	if(obj instanceof Customer) {
//		Customer another=(Customer)obj;
//		answer=(this.id!=null?
//				this.id.equals(another.id):false);
//	}
//	return answer;
//}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Customer))
			return false;
		Customer other = (Customer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}




}