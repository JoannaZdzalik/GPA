package pl.gpalpin.gpa.service;

import com.lowagie.text.DocumentException;

import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Service
public class PdfService implements PdfServiceInterface{
	
	//private static final String fileLocation = "user.dir"; lub user.home
	private static final String path = "C:\\Users\\asus\\Desktop\\Irkowa stronka\\gpa\\src\\main\\resources\\pdfs"; //lokalizacja będzie do zmiany na 100%
	private String fileName = "GPA_oferta.pdf";
	
	 public String parseThymeleafTemplate() {
	    ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
	    templateResolver.setSuffix(".html");
	    templateResolver.setTemplateMode(TemplateMode.HTML);

	    TemplateEngine templateEngine = new TemplateEngine();
	    templateEngine.setTemplateResolver(templateResolver);

	    Context context = new Context();
	    context.setVariable("czego", "dachu");

	    return templateEngine.process("pdftemplate", context);
	}
	
	public void generatePdfFromHtml(String html)throws IOException, DocumentException {
	   // String outputFolder = System.getProperty("user.dir")+ File.separator + "GPAoferta.pdf";
	   String outputFolder = path + File.separator + fileName;
	    OutputStream outputStream = new FileOutputStream(outputFolder);

	    ITextRenderer renderer = new ITextRenderer();
	    renderer.setDocumentFromString(html);
	    renderer.layout();
	    renderer.createPDF(outputStream);

	    outputStream.close();
	}

}
