package uuu.vgb.entity;

public class Outlet extends Product {
	private int discount;


	public Outlet() {
		super();
	}

	public Outlet(int id, String name, double unitPrice, int stock) {
		super(id, name, unitPrice, stock);
	}

	public Outlet(int id, String name, double unitPrice) {
		super(id, name, unitPrice);
	}

	public void setDiscount(int discount) {
		this.discount = discount;//各商品折扣不一，故不指定預設
	}

	public int getDiscount() {
		return discount;
	}
	public String getDiscountString() {//擴充  顯示畫面用的
		int discount = 100 - this.discount;
		if (discount % 10 == 0) {
			discount=discount / 10;
		}
		return discount + "折";
	}
	@Override
	public double getUnitPrice() { //查詢售價
		return super.getUnitPrice()*(100-discount)/100;
	}

	public double getListPrice() {//查詢定價
		return super.getUnitPrice();
	}

	@Override
	public String toString() {
		return super.toString()+"\n折扣= "+getDiscountString()+"\n售價= "+ getUnitPrice();
	}

}

