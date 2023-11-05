package com.flyers.tms.day4;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PDF {

  public static void main(String[] args) {

    String logoImagePath = "C:/Users/user/Downloads/images.png"; // Update the path without double quotes
    String outputFilePath = "D:\\New folder\\logo.pdf";

    PDF pdfGenerator = new PDF();
    try {
      pdfGenerator.generatePdfDocument(outputFilePath, logoImagePath);
      System.out.println("PDF document generated successfully.");
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Error generating the PDF document.");
    }
  }

  private void generatePdfDocument(String outputFilePath, String logoImagePath) throws IOException {
    PDDocument document = new PDDocument();
    PDPage page = new PDPage(PDRectangle.A4);
    document.addPage(page);

    // Load logo image from file
    Path logoPath = Paths.get(logoImagePath);
    byte[] logoBytes = Files.readAllBytes(logoPath);
    PDImageXObject logoImage = PDImageXObject.createFromByteArray(document, logoBytes, "logo");

    try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
      // Add logo
      float logoX = 100; // X coordinate for the logo image
      float logoY = 700; // Y coordinate for the logo image
      float logoWidth = 200; // Width of the logo
      float logoHeight = 100; // Height of the logo
      contentStream.drawImage(logoImage, logoX, logoY, logoWidth, logoHeight);

      // Add text
      float textX = 100; // X coordinate for the text
      float textY = 600; // Y coordinate for the text
      float fontSize = 12; // Font size for the text
      contentStream.beginText();
      contentStream.setFont(PDType1Font.HELVETICA_BOLD, fontSize);
      contentStream.newLineAtOffset(textX, textY);
      contentStream.showText("Welcome to our PDF document with logo and text!");
      contentStream.endText();

      contentStream.close();
    }

    document.save(new File(outputFilePath));
    document.close();
  }
}
