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
//        String jdbcURL = "jdbc:mysql://localhost:3306/formDB?useUnicode=yes&characterEncoding=UTF-8&characterSetResults=UTF-8";
        String jdbcURL = "jdbc:mysql://79.175.177.58:3306/formDB?useUnicode=yes&characterEncoding=UTF-8&characterSetResults=UTF-8";
        String username = "bourna";
        String password = "Bourn@1234";
        String excelFilePath = "partnersinstitute-export"+ ".xlsx";
        String excelFilePathcmp = "partnerscompany-export" + ".xlsx";
        File file = new File(excelFilePath);
        File file1 = new File(excelFilePathcmp);

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {

            String sqlinstitiue = "SELECT * FROM instituteentity WHERE partnerid="+partnerId+";";
            String sqlcompany = "SELECT * FROM companyentity WHERE partnerid="+partnerId+";";

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
        headerCell.setCellValue("id");
        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("name");
        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("phone");
        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("email");
        headerCell = headerRow.createCell(4);
        headerCell.setCellValue("work_experiences");
        headerCell = headerRow.createCell(5);
        headerCell.setCellValue("support_descriptions");
        headerCell = headerRow.createCell(6);
        headerCell.setCellValue("projectname");
        headerCell = headerRow.createCell(7);
        headerCell.setCellValue("work_experiences_description");



    }


    private void writeHeaderLine(XSSFSheet sheet) {
        Row headerRow = sheet.createRow(0);
        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("id");
        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("name");
        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("lastname");
        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("phone");
        headerCell = headerRow.createCell(4);
        headerCell.setCellValue("email");
        headerCell = headerRow.createCell(5);
        headerCell.setCellValue("degree");
        headerCell = headerRow.createCell(6);
        headerCell.setCellValue("work_experiences");
        headerCell = headerRow.createCell(7);
        headerCell.setCellValue("support_descriptions");
        headerCell = headerRow.createCell(8);
        headerCell.setCellValue("projectname");
        headerCell = headerRow.createCell(9);
        headerCell.setCellValue("work_experiences_description");


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
            String projectname = result.getString("projectname");
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

            cell = row.createCell(columnCount++);
            cell.setCellValue(projectname);

            cell = row.createCell(columnCount++);
            cell.setCellValue(hourdes);

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
            String projectname = resultcmp.getString("projectname");
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

            cell = row.createCell(columnCount++);
            cell.setCellValue(projectname);

            cell = row.createCell(columnCount++);
            cell.setCellValue(hourdes);
        }
    }

    public static void main(String[] args) throws IOException {
        new ExportPartnersTable().export(1);
    }
}
