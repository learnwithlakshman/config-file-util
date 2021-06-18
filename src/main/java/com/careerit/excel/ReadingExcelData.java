package com.careerit.excel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcelData {
	public static void main(String[] args) {
		List<Player> list = readDataFromExcel();
		list.stream().map(e->e.getName().toUpperCase()).forEach(e->System.out.println(e));
	}

	public static List<Player> readDataFromExcel() {
		
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("id",0);
		map.put("name", 1);
		map.put("price",2);
		map.put("role", 3);
		map.put("label", 4);
		List<Player> players = new ArrayList<Player>();
		try {

			XSSFWorkbook workbook = new XSSFWorkbook(
					ReadingExcelData.class.getResourceAsStream("/sql/ipl_sql_data.xlsx"));
			XSSFSheet sheet = workbook.getSheet("players");

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				
				Row row = sheet.getRow(i);
				int id = (int)Double.parseDouble(getValue(row.getCell(map.get("id"))));
				String name =getValue(row.getCell(map.get("name")));
				double price = Double.parseDouble(getValue(row.getCell(map.get("price"))));
				String role = getValue(row.getCell(map.get("role")));
				String label = getValue(row.getCell(map.get("label")));
			
				Player player = Player.builder()
							          .id(id)
							          .name(name)
							          .price(price)
							          .role(role)
							          .label(label)
							          .build();
				players.add(player);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("while reading excel file :" + e);
		}
		return players;
	}

	private static String getValue(Cell currentCell) {
		if (currentCell.getCellType() == CellType.STRING) {
			return currentCell.getStringCellValue();
		} else if (currentCell.getCellType() == CellType.NUMERIC) {
			return String.valueOf(currentCell.getNumericCellValue());
		}
		return null;
	}

}
