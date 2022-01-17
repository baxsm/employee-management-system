package baxsm;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExportExcel {
	
	public ExportExcel(){}
	
	public ExportExcel(JTable table){
		export(table);
	}

    public static void export(JTable table) {
    	String excelFilePath = "ems-employee-list.xls";
    	try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("resource");
            writeHeaderLine(sheet, table);
            writeDataLines(workbook, sheet, table);
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            workbook.close();
    	} catch (IOException e) {
    		JOptionPane.showMessageDialog(null, e);
        }
    }

    private static void writeHeaderLine(HSSFSheet sheet, JTable table) {
        Row headerRow = sheet.createRow(0);
        Cell headerCell;
        for (int x = 0; x < table.getColumnCount() ; x++) {
        	headerCell = headerRow.createCell(x);
            headerCell.setCellValue(table.getColumnName(x));
        }
    }
    
    private static void writeDataLines(HSSFWorkbook workbook,HSSFSheet sheet, JTable table) {
        Cell cell;
        Row row;
        for(int rowCount = 0; rowCount < table.getRowCount(); rowCount++) {
        	row = sheet.createRow(rowCount);
        	for(int columnCount = 0; columnCount < table.getColumnCount(); columnCount++) {
            	cell = row.createCell(columnCount);
        		cell.setCellValue(table.getValueAt(rowCount, columnCount).toString());
        	}
          }
    }
}
