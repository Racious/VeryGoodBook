package uuu.vgb.entity;

public class VIP extends Customer {
	public VIP() {
		super();
	}

	public VIP(String id, String password, String name, char gender) throws Exception {
		super(id, password, name, gender);
		// TODO Auto-generated constructor stub
	}

	public VIP(String id, String password, String name) throws Exception {
		super(id, password, name);
		// TODO Auto-generated constructor stub
	}

	private int discount = 5;

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getDiscount() {
		return 100 - this.discount;
	}

	public String getDiscountString() {// 擴充 顯示畫面用的
		int discount = 100 - this.discount;
		if (discount % 10 == 0) {
			return discount / 10 + "折";
		} else {
			return discount + "折";
		}

	}

	@Override
	public String toString() {
		return super.toString() + "\n折扣: " + discount + " 即享有" + getDiscountString();
	}

}