package kr.co.swk.equipment.manager;

public class Equipment {
	private String name; // ����
	private int quantity; // ����
	private String date; // ������
	private char availability;	// �����(���뼺)

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
