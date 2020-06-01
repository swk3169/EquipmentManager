package kr.co.swk.equipment.manager;

import java.io.IOException;

//enum Menus {INSERT, DELETE, UPDATE, DISPLAY, EXIT;}

public class Main {
	public static void main(String args[]) {
		EquipmentList equipment_list = new EquipmentList();
		TaskManager tm = new TaskManager();
		IoHandler ioh = new IoHandler();

		try {
			ioh.loadEquipment("equipment.txt", equipment_list);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		while (true) {
			int menu = ioh.getMenu();

			switch (menu) {
			case 1:
				// 장비정보 등록
				tm.registerEquipment(equipment_list);
				break;
			case 2:
				// 장비정보 삭제
				tm.unregisterEquipment(equipment_list);
				break;
			case 3:
				// 장비정보 수정
				tm.changeEquipment(equipment_list);
				break;
			case 4:
				// 장비정보 출력
				tm.displayEquipment(equipment_list);
				break;
			case 5:
				boolean dialog = ioh.getExitDialogMenu();
				
				if (dialog == true) {
					try {
						ioh.saveEquipment("equipment.txt", equipment_list);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.exit(1);
				} else if (dialog == false) {
					continue;
				} else {
					continue;
				}
			default:
				System.out.println("잘못 입력하셨습니다. ");
			}
		}
	}
}
