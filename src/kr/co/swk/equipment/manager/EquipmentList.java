package kr.co.swk.equipment.manager;

public class EquipmentList {
	final int MAX_EQUIPMENT = 100;

	private Equipment[] equipment_list = new Equipment[MAX_EQUIPMENT];
	private int count;

	public EquipmentList() {
		count = 0;
	}

	public int getCount() {
		return count;
	}

	public Equipment getEquipmentList(int index) {
		return equipment_list[index];
	}

	public void insertEquipment(Equipment equipment) {
		equipment_list[count] = equipment;
		count++;
	}

	public void deleteEquipment(int index) {
		equipment_list[index] = equipment_list[index + 1];
		count--;
	}

	public void updateEquipment(int index, Equipment equipment) {
		equipment_list[index] = equipment;
	}
}