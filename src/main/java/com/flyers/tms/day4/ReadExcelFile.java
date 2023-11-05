package com.flyers.tms.day4;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadExcelFile {

  public static void readFile(String path, int rowValue, int cellValue) throws IOException {

    FileInputStream stream = new FileInputStream(path);

    XSSFWorkbook workbook = new XSSFWorkbook(stream);

    Sheet sheet = workbook.getSheetAt(0);

    Row row = sheet.getRow(rowValue);

    for (Cell cell : row
    ) {
      CellType type = cell.getCellType();

      switch (type) {
        case STRING -> System.out.println(cell.getStringCellValue());
        case NUMERIC -> System.out.println(cell.getNumericCellValue());
        default -> System.out.println("This is Default");
      }
      System.out.println();

    }
  }

  private static void writeFile(String path, String sheetName, int rowValue, int cellValue, String value) throws IOException {

    FileInputStream inputStream = new FileInputStream(path);

    XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

    Sheet sheet = workbook.createSheet(sheetName);

    Row row = sheet.createRow(rowValue);

    row.createCell(cellValue).setCellValue(value);

    try
        (
            FileOutputStream outputStream = new FileOutputStream(path)
        ) {
      workbook.write(outputStream);
      System.out.println("Excel file created successfully.");
      workbook.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public static void main(String[] args) throws IOException {

//    ReadExcelFile.readFile("C:\\Users\\user\\Desktop\\TMS\\flyers-tms\\src\\main\\resources\\timesheet.xlsx",
//        1,2);
//    ReadExcelFile.writeFile("C:\\Users\\user\\Desktop\\TMS\\flyers-tms\\src\\main\\resources\\timesheet.xlsx",
//        "New-Sheet",1,0,"New Cell Value Created");

    List<String> list = new ArrayList<>(Arrays.asList("java", "python", "node"));
    //  var result = list.stream().map( l -> l.concat(l)).collect(Collectors.toList());
    var result = list.stream().collect(Collectors.joining());
    System.out.println(result);

    Stream<Integer> randomNumbers = Stream
        .generate(() -> (new Random()).nextInt(100));

    randomNumbers.limit(20).forEach(p -> System.out.println(p));


    List<Integer> listss = new ArrayList<Integer>();
    for (int i = 1; i < 10; i++) {
      listss.add(i);
    }
//Here creating a parallel stream
    Stream<Integer> stream = listss.parallelStream();
    Integer[] evenNumbersArr = stream.filter(i -> i % 2 == 0).toArray(Integer[]::new);
    System.out.print(Arrays.toString(evenNumbersArr));
  }
}
