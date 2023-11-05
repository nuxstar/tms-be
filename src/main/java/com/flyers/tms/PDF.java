package com.flyers.tms;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.File;
import java.io.IOException;

public class PDF {

  static String  filePath = "D:\\Payslip\\save.pdf";

  public String readPdf(){
    try (PDDocument document = PDDocument.load(new File(filePath))) {
      PDFTextStripper textStripper = new PDFTextStripper();
      return textStripper.getText(document);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static void main(String[] args) {

    try (PDDocument document = new PDDocument()) {
      PDPage page = new PDPage();
      document.addPage(page);
      PDPageContentStream contentStream = new PDPageContentStream(document, page);

      // Add content to the PDF
      contentStream.beginText();
      contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
      contentStream.newLineAtOffset(100, 700);
      contentStream.showText("Lambda Expressions and Stream API\n" +
          "Java was always known for having a lot of boilerplate code. With the release of " +
          "Java 8, this statement became a little less valid. The stream API and lambda expressions are the " +
          "new features that move us closer to functional programming.\n" +
          "\n" +
          "In our examples, we will see how we use lambdas and streams in the different scenarios.");
      contentStream.endText();
      contentStream.close();

      // Save the PDF to the specified file path
      document.save(filePath);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
