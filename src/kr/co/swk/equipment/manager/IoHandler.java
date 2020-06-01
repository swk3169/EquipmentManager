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
		System.out.println("----- ������ ���α׷� -----");
		System.out.println("----- 1. ������� ��� -----");
		System.out.println("----- 2. ������� ���� -----");
		System.out.println("----- 3. ������� ���� -----");
		System.out.println("----- 4. ������� ��� -----");
		System.out.println("----- 5. ����            -----");

		int menu = getInteger("���� : ");
		if (menu >= 1 && 5 >= menu) {
			return menu;
		}
		return 0;
	}
	
	public boolean getExitDialogMenu() {
		
		String answer = getString("���α׷��� ���� �Ͻðڽ��ϱ�(y/n)?");
		
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

		String answer = getString("��� �Է��Ͻðڽ��ϱ�(y/n)?");

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
		String name = getString("���� : ");
		int quantity = getInteger("���� : ");
		String date = getString("������(��:1990-01-01) : ");
		char availability = getChar("�����(��:y or n) : ");

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
		System.out.println("����" + "\t" + "����" + "\t" + "������" + "\t\t" + "�����");
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