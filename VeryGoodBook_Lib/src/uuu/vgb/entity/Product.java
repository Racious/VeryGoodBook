package uuu.vgb.entity;

import java.util.Locale.Category;

public class Product {

	private int id;//PKey,auto increment
	private String name;//required, Unique Index
	private double unitPrice;//required
	private int stock;//required
	private String description="";//optional
	private String photoUrl;//optional
	private String category;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}



	public Product() {}

	public Product(int id, String name, double unitPrice) {
		this.id=id; this.name=name; this.unitPrice=unitPrice;
	}

	public Product(int id, String name, double unitPrice, int stock) {
		//super();
		this.id = id;
		this.name = name;
		this.unitPrice = unitPrice;
		this.stock = stock;
	}

	public int getId() {//getter一定沒有參數
		return id;
	}

	public void setId(int id) {//setter一定會有形態
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getUnitPrice() {//定價即為售價
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	@Override
	public String toString() {
		return this.getClass().getName()+"\nid= " + id + "\n書名= " + name +
				"\n定價= " + unitPrice + "\n庫存= " + stock	+
				"\n描述= " + description + "\n類別= "+ category +"\n圖片網址= " + photoUrl ;
	}

}
