package generics;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtile {
    private Workbook workbook;
    private Sheet sheet;

    // Load the Excel file and specify the sheet
    public ExcelUtile(String filePath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
    }

	// Get cell data by row and column index
    public String getCellData(int rowIndex, int colIndex) {
        Cell cell = sheet.getRow(rowIndex).getCell(colIndex);
        if (cell == null) return "";
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
    }

    // Get the total number of rows
    public int getRowCount() {
        return sheet.getLastRowNum() + 1;
    }

    // Get the total number of columns
    public int getColumnCount() {
        return sheet.getRow(0).getLastCellNum();
    }

    // Close workbook
    public void closeWorkbook() throws IOException {
        workbook.close();
    }
}
