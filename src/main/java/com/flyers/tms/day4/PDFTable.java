package com.flyers.tms.day4;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.io.IOException;

public class PDFTable {

  public static void main(String[] args) {

    String path = "D:\\New folder\\table.pdf";

    PDFTable pdfGenerator = new PDFTable();
    try {
      pdfGenerator.generatePdfWithTable(path);
      System.out.println("PDF document generated successfully.");
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Error generating the PDF document.");
    }
  }

  private void generatePdfWithTable(String path) throws IOException {
    PDDocument document = new PDDocument();
    PDPage page = new PDPage(PDRectangle.A4);
    document.addPage(page);

    float margin = 50;
    float yStart = page.getMediaBox().getHeight() - margin;
    float tableWidth = page.getMediaBox().getWidth() - 2 * margin;
    float yPosition = yStart;
    int rows = 5;
    int cols = 3;
    float rowHeight = 20;
    float tableHeight = rowHeight * rows;
    float cellMargin = 5f;

    try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {

      drawTable(contentStream, yStart, tableWidth, yPosition, tableHeight, cellMargin, rows, cols);

      String[][] data = {
          {"Name", "Age", "City"},
          {"John Doe", "30", "New York"},
          {"Jane Smith", "25", "San Francisco"},
          {"Michael Johnson", "35", "Chicago"},
          {"Emily Brown", "28", "Los Angeles"}
      };
      float textX = margin + cellMargin;
      float textY = yPosition - 15;
      float fontSize = 12;
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          contentStream.beginText();
          contentStream.setFont(PDType1Font.HELVETICA, fontSize);
          contentStream.newLineAtOffset(textX, textY);
          contentStream.showText(data[i][j]);
          contentStream.endText();
          textX += tableWidth / cols;
        }
        textX = margin + cellMargin;
        textY -= rowHeight;
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    document.save(new File(path));
    document.close();
  }

  private void drawTable
      (
          PDPageContentStream contentStream,
          float yStart,
          float tableWidth,
          float yPosition,
          float tableHeight,
          float cellMargin,
          int rows,
          int cols
      ) throws IOException {
    float nextX = yPosition;
    for (int i = 0; i <= cols; i++) {
      contentStream.moveTo(nextX, yStart);
      contentStream.lineTo(nextX, yStart - tableHeight);
      contentStream.stroke();
      nextX += tableWidth / cols;
    }

    float nextY = yStart;
    for (int i = 0; i <= rows; i++) {
      contentStream.moveTo(yPosition, nextY);
      contentStream.lineTo(yPosition + tableWidth, nextY);
      contentStream.stroke();
      nextY -= tableHeight / rows;
    }
  }
}
