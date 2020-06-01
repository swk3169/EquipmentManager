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
		System.out.println("장비 정보를 등록합니다.");

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
		System.out.println("장비 정보를 삭제합니다.");

		String name = ioh.getString("삭제할 장비의 이름을 입력하시오 : ");

		for (int i = findEquipment(equipment_list, name); i < equipment_list.getCount(); i++) {
			equipment_list.deleteEquipment(i);
		}
	}

	void changeEquipment(EquipmentList equipment_list) {
		System.out.println("장비 정보를 수정합니다.");

		System.out.print("수정할 장비의 이름을 입력하시오 :");
		String name = sc.next();

		System.out.println("장비명 : " + name + " 장비의 정보를 수정합니다.");

		Equipment equipment = ioh.getEquipment();
		equipment_list.updateEquipment(findEquipment(equipment_list, name), equipment);
	}

	public void displayEquipment(EquipmentList equipment_list) {
		System.out.println("장비 정보를 출력합니다.");

		for (int i = 0; i < equipment_list.getCount(); i++) {
			Equipment equipment = equipment_list.getEquipmentList(i);
			ioh.putEquipment(equipment);
		}
	}
}