package uuu.vgb.entity;

import java.time.LocalDate;

public class testproduct {

	@Override
	public String toString() {
		return "id=" + id + " name=" + name + " price=" + price + " releasedate=" + releasedate + "\n\n";
	}
	private int id;
	private String name;
	private int price;
	private LocalDate releasedate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
			this.id = id;			
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public LocalDate getReleasedate() {
		return releasedate;
	}
	public void setReleasedate(LocalDate releasedate) {
		this.releasedate = releasedate;
	}
	public void setReleasedate(String string) {
		setReleasedate(LocalDate.parse(string));
		// TODO Auto-generated method stub
		
	}
	
}
