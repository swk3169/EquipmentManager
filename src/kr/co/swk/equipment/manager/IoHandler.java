package kr.co.swk.equipment.manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class IoHandler {
	Scanner sc = new Scanner(System.in);

	public int getMenu() {
		System.out.println("----- 장비관리 프로그램 -----");
		System.out.println("----- 1. 장비정보 등록 -----");
		System.out.println("----- 2. 장비정보 삭제 -----");
		System.out.println("----- 3. 장비정보 수정 -----");
		System.out.println("----- 4. 장비정보 출력 -----");
		System.out.println("----- 5. 종료            -----");

		int menu = getInteger("선택 : ");
		if (menu >= 1 && 5 >= menu) {
			return menu;
		}
		return 0;
	}
	
	public boolean getExitDialogMenu() {
		
		String answer = getString("프로그램을 종료 하시겠습니까(y/n)?");
		
		if (answer.contains("y")) {
			return true;
		} else if (answer.contains("n")) {
			return false;
		} else {
			System.out.print("Not Found Error");
			return false;
		}
	}

	public boolean getDialogMenu() {

		String answer = getString("계속 입력하시겠습니까(y/n)?");

		if (answer.contains("y")) {
			return true;
		} else if (answer.contains("n")) {
			return false;
		} else {
			System.out.print("Not Found Error");
			return false;
		}
	}

	public Equipment getEquipment() {
		String name = getString("장비명 : ");
		int quantity = getInteger("수량 : ");
		String date = getString("생산일(예:1990-01-01) : ");
		char availability = getChar("재고여부(예:y or n) : ");

		Equipment equipment = new Equipment(name, quantity, date, availability);

		return equipment;
	}
	
	public char getChar(String msg) {
		char value;

		System.out.print(msg);
		value = sc.next().charAt(0);

		return value;
	}
	
	public String getString(String msg) {
		String value;

		System.out.print(msg);
		value = sc.next();

		return value;
	}

	public int getInteger(String msg) {
		int value;

		System.out.print(msg);
		value = sc.nextInt();

		return value;
	}
	
	public void putEquipment(Equipment equipment) {
		System.out.println("-----------------------------------------------------------");
		System.out.println("장비명" + "\t" + "수량" + "\t" + "생산일" + "\t\t" + "재고여부");
		System.out.println("-----------------------------------------------------------");
		System.out.println(equipment.getName() + "\t" + equipment.getQuantity() + "\t" + equipment.getDate() + "\t"
				+ equipment.getAvailability());
	}

	public void loadEquipment(String fileName, EquipmentList equipment_list) throws IOException {

		FileInputStream fin = new FileInputStream(fileName);

		BufferedReader br = new BufferedReader(new InputStreamReader(fin));

		String patchLine;
		String seperator = "\t";

		while ((patchLine = br.readLine()) != null) {

			String[] item = patchLine.split(seperator);

			String name = item[0];
			int quantity = Integer.parseInt(item[1]);
			String date = item[2];
			char availability = item[3].trim().charAt(0);

			Equipment equipment = new Equipment(name, quantity, date, availability);
			equipment_list.insertEquipment(equipment);
		}
		br.close();
	}

	public void saveEquipment(String filename, EquipmentList equipment_list) throws IOException {
		
		FileOutputStream fout = new FileOutputStream(filename);
		BufferedWriter br = new BufferedWriter(new OutputStreamWriter(fout));

		for (int i = 0; i < equipment_list.getCount(); i++) {
			br.write(equipment_list.getEquipmentList(i).getName() + "\t");
			br.write(equipment_list.getEquipmentList(i).getQuantity() + "\t");
			br.write(equipment_list.getEquipmentList(i).getDate() + "\t");
			br.write(equipment_list.getEquipmentList(i).getAvailability() + "\t");
			br.newLine();
		}
		br.close();
	}
}