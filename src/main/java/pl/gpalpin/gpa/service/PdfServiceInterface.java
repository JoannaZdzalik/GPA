package pl.gpalpin.gpa.service;

import java.io.IOException;

import com.lowagie.text.DocumentException;

public interface PdfServiceInterface {

	String parseThymeleafTemplate();
	void generatePdfFromHtml(String html) throws IOException, DocumentException;
}
