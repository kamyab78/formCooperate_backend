package ir.bourna.form.Config;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.persistence.Column;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.time.Instant;

public class ExportPartnersTable {



    public void export(int partnerId) throws IOException {
        String jdbcURL = "jdbc:mysql://localhost:3306/announcementsDB?useUnicode=yes&characterEncoding=UTF-8&characterSetResults=UTF-8";
        String username = "admin";
        String password = "admin";

        String excelFilePath = "partnersinstitute-export" + Instant.now().getEpochSecond() + ".xlsx";
        String excelFilePathcmp = "partnerscompany-export" + Instant.now().getEpochSecond() + ".xlsx";
        File file = new File(excelFilePath);
        if (file.createNewFile()) {
            System.out.println(excelFilePath + " File Created");
        } else System.out.println("File " + excelFilePath + " already exists");

        File file1 = new File(excelFilePathcmp);
        if (file1.createNewFile()) {
            System.out.println(excelFilePathcmp + " File Created");
        } else System.out.println("File " + excelFilePathcmp + " already exists");

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {

            String sqlinstitiue = "SELECT * FROM instituteentity ";
            String sqlcompany = "SELECT * FROM companyentity";

            Statement statement = connection.createStatement();
            Statement statementcmp = connection.createStatement();
            ResultSet resultins = statement.executeQuery(sqlinstitiue);
            ResultSet resultcmp = statementcmp.executeQuery(sqlcompany);

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFWorkbook workbookcmp = new XSSFWorkbook();
            XSSFSheet sheetins = workbook.createSheet("partnersInstitute");
            XSSFSheet sheetcmp = workbookcmp.createSheet("partnersCompany");

            writeHeaderLine(sheetins);
            writeHeaderLine1(sheetcmp);

            writeDataLines(resultins, workbook, sheetins);
            writeDataLinescmp(resultcmp, workbookcmp, sheetcmp);


            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            FileOutputStream outputStreamcmp = new FileOutputStream(excelFilePathcmp);
            workbook.write(outputStream);
            workbookcmp.write(outputStreamcmp);
            workbook.close();
            workbookcmp.close();


        } catch (SQLException e) {
            System.out.println("Datababse error:");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File IO error:");
            e.printStackTrace();
        }
    }



    private void writeHeaderLine1(XSSFSheet sheetcmp) {
        Row headerRow = sheetcmp.createRow(0);
        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("name");
        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("phone");
        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("email");
        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("work_experiences");
        headerCell = headerRow.createCell(4);
        headerCell.setCellValue("support_descriptions");
        headerCell = headerRow.createCell(5);
        headerCell.setCellValue("hour_description");
    }


    private void writeHeaderLine(XSSFSheet sheet) {
        Row headerRow = sheet.createRow(0);

        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("name");
        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("lastname");
        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("phone");
        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("email");
        headerCell = headerRow.createCell(4);
        headerCell.setCellValue("degree");
        headerCell = headerRow.createCell(5);
        headerCell.setCellValue("work_experiences");
        headerCell = headerRow.createCell(6);
        headerCell.setCellValue("support_descriptions");
        headerCell = headerRow.createCell(7);
        headerCell.setCellValue("hour_description");

    }

    private void writeDataLines(ResultSet result, XSSFWorkbook workbook,
                                XSSFSheet sheet) throws SQLException {
        int rowCount = 1;
        while (result.next()) {
            int id = result.getInt("id");
            String name = result.getString("name");
            String lastname = result.getString("lastname");
            String phone = result.getString("phone");
            String email = result.getString("email");
            String degree = result.getString("degree");
            String workexp = result.getString("workexp");
            String supportdes = result.getString("supportdes");
            String hourdes = result.getString("hourdes");
            Row row = sheet.createRow(rowCount++);


            int columnCount = 0;
            Cell cell = row.createCell(columnCount++);
            cell.setCellValue(id);

            cell = row.createCell(columnCount++);
            cell.setCellValue(name);

            cell = row.createCell(columnCount++);
            cell.setCellValue(lastname);

            cell = row.createCell(columnCount++);
            cell.setCellValue(phone);

            cell = row.createCell(columnCount++);
            cell.setCellValue(email);

            cell = row.createCell(columnCount++);
            cell.setCellValue(degree);

            cell = row.createCell(columnCount++);
            cell.setCellValue(workexp);

            cell = row.createCell(columnCount++);
            cell.setCellValue(supportdes);


        }
    }
    private void writeDataLinescmp(ResultSet resultcmp, XSSFWorkbook workbook, XSSFSheet sheetcmp) throws SQLException {
        int rowCount = 1;
        while (resultcmp.next()) {
            int id = resultcmp.getInt("id");
            String name = resultcmp.getString("name");
            String phone = resultcmp.getString("phone");
            String email = resultcmp.getString("email");
            String workexp = resultcmp.getString("workexp");
            String supportdes = resultcmp.getString("supportdes");
            String hourdes = resultcmp.getString("hourdes");
            Row row = sheetcmp.createRow(rowCount++);
            int columnCount = 0;
            Cell cell = row.createCell(columnCount++);
            cell.setCellValue(id);

            cell = row.createCell(columnCount++);
            cell.setCellValue(name);

            cell = row.createCell(columnCount++);
            cell.setCellValue(phone);

            cell = row.createCell(columnCount++);
            cell.setCellValue(email);
            cell = row.createCell(columnCount++);
            cell.setCellValue(workexp);

            cell = row.createCell(columnCount++);
            cell.setCellValue(supportdes);


        }
    }

    public static void main(String[] args) throws IOException {
        new ExportPartnersTable().export(1);
    }
}
