package com.flyers.tms.day4;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import java.io.FileOutputStream;
import com.itextpdf.text.pdf.PdfWriter;

public class TablePdf {

  public static void main(String args[]) {
    String dest = "D:\\New folder\\PDTable.pdf";
    Document document = new Document();

    try {
      PdfWriter.getInstance(document, new FileOutputStream(dest));
      document.open();

      float[] pointColumnWidths = {150F, 150F, 150F};
      PdfPTable table = new PdfPTable(pointColumnWidths);

      table.addCell(new PdfPCell(new Paragraph("Name")));
      table.addCell(new PdfPCell(new Paragraph("Raju")));
      table.addCell(new PdfPCell(new Paragraph("Id")));
      table.addCell(new PdfPCell(new Paragraph("1001")));
      table.addCell(new PdfPCell(new Paragraph("Designation")));
      table.addCell(new PdfPCell(new Paragraph("Programmer")));

      document.add(table);
      document.close();

      System.out.println("Table created successfully..");
    } catch (DocumentException e) {
      e.printStackTrace();
      System.out.println("Error creating the table.");
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
