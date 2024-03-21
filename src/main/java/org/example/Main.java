package org.example;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();
        List<String> info = new ArrayList<String>();
        try {
            XSSFWorkbook work = new XSSFWorkbook(new FileInputStream(new File("C:\\Users\\Harsh Singh\\Downloads\\new1.xlsx" )));
            XSSFSheet sheet = work.getSheetAt(0);
            int rowCount = sheet.getLastRowNum() + 1;
            for (int i = 0; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                int cellCount = row.getLastCellNum();
                for (int j = 0; j < cellCount; j++) {
                    Cell cell = row.getCell(j);
                    // Process the cell value as needed
                    DataFormatter dataFormatter = new DataFormatter();
                    String formattedCellStr = dataFormatter.formatCellValue(cell);
                    info.add(formattedCellStr);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(info.getFirst());
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(info.get(1));
        driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys(info.get(2));
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(info.get(3));
        driver.findElement(By.xpath(" //input[@type='tel']")).sendKeys(info.get(4));
//        if(info.get(5).equals("Male"){
//driver.findElement(By.xpath("    }
}
}
