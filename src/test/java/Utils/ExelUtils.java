package Utils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ExelUtils {
    private Sheet sheet;
    private Workbook workbook;

    public ExelUtils(String filePath, String sheetName) {
        try {
            // Load the Excel workbook
            FileInputStream inputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(inputStream);
            // Load the specified sheet
            sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet " + sheetName + " does not exist in the workbook");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read the Excel file: " + e.getMessage());
        }
    }

    public String getPhoneNumber(int rowIndex, int colIndex) {
        return getStringValueFromCell(rowIndex, colIndex);
    }

    public String getPinCode(int rowIndex, int colIndex) {
        return getStringValueFromCell(rowIndex, colIndex + 1);  // Assuming pin code is in the next column
    }

    private String getStringValueFromCell(int rowIndex, int colIndex) {
        try {
            Cell cell = sheet.getRow(rowIndex).getCell(colIndex);
            if (cell != null) {
                if (cell.getCellType() == CellType.NUMERIC) {
                    // Numeric cell type, convert it to string without scientific notation
                    return String.valueOf((long)cell.getNumericCellValue());
                } else if (cell.getCellType() == CellType.STRING) {
                    // String cell type, directly return the value
                    return cell.getStringCellValue();
                }
                // Handle other types as needed
            }
        } catch (NullPointerException e) {
            System.out.println("Error: Cell was null - " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ""; // Return empty string if there's any issue
    }

    
    public boolean isExecutionRequired(String testCaseName) {
        int rowNum = sheet.getLastRowNum();
        for (int i = 1; i <= rowNum; i++) {
            Row row = sheet.getRow(i);
            if (row.getCell(0).getStringCellValue().trim().equalsIgnoreCase(testCaseName)) {
                return row.getCell(1).getStringCellValue().trim().equalsIgnoreCase("Yes");
            }
        }
        return false;
    }
  
}
