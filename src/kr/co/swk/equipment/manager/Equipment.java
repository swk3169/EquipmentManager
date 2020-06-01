package kr.co.swk.equipment.manager;

public class Equipment {
	private String name; // 장비명
	private int quantity; // 수량
	private String date; // 생산일
	private char availability;	// 재고여부(가용성)

	public Equipment() {};
	public Equipment(String name, int quantity, String date, char availability) {
		this.name = name;
		this.quantity = quantity;
		this.date = date;
		this.availability = availability;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getDate() {
		return date;
	}
	
	public char getAvailability() {
		return availability;
	}
}
