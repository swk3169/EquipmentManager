package kr.co.swk.equipment.manager;

import java.util.Scanner;

public class TaskManager {
	Scanner sc = new Scanner(System.in);

	IoHandler ioh = new IoHandler();

	int findEquipment(EquipmentList equipment_list, String name) {
		for (int i = 0; i < equipment_list.getCount(); i++) {
			if (name.contains(equipment_list.getEquipmentList(i).getName())) {
				return i;
			}
		}
		return 0;
	}

	void registerEquipment(EquipmentList equipment_list) {
		System.out.println("��� ������ ����մϴ�.");

		Equipment equipment = ioh.getEquipment();

		equipment_list.insertEquipment(equipment);

		while(true) {
			boolean dialog = ioh.getDialogMenu();

			if (dialog == true) {
				Equipment e = ioh.getEquipment();

				equipment_list.insertEquipment(e);
				
			} else if (dialog == false) {
				break;
			} else {
				break;
			}
		}
	}

	void unregisterEquipment(EquipmentList equipment_list) {
		System.out.println("��� ������ �����մϴ�.");

		String name = ioh.getString("������ ����� �̸��� �Է��Ͻÿ� : ");

		for (int i = findEquipment(equipment_list, name); i < equipment_list.getCount(); i++) {
			equipment_list.deleteEquipment(i);
		}
	}

	void changeEquipment(EquipmentList equipment_list) {
		System.out.println("��� ������ �����մϴ�.");

		System.out.print("������ ����� �̸��� �Է��Ͻÿ� :");
		String name = sc.next();

		System.out.println("���� : " + name + " ����� ������ �����մϴ�.");

		Equipment equipment = ioh.getEquipment();
		equipment_list.updateEquipment(findEquipment(equipment_list, name), equipment);
	}

	public void displayEquipment(EquipmentList equipment_list) {
		System.out.println("��� ������ ����մϴ�.");

		for (int i = 0; i < equipment_list.getCount(); i++) {
			Equipment equipment = equipment_list.getEquipmentList(i);
			ioh.putEquipment(equipment);
		}
	}
}