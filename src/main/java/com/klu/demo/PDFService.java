package com.klu.demo;
import org.w3c.dom.Document;
import org.w3c.tidy.Tidy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;

@Service
public class PDFService {

    private static final String PDF_RESOURCES = "";
    private MyService studentService;
    private SpringTemplateEngine templateEngine;

    @Autowired
    public PDFService(MyService studentService, SpringTemplateEngine templateEngine) {
        this.studentService = studentService;
        this.templateEngine = templateEngine;
    }
    
    
    
    private String convertToXhtml(String html) throws UnsupportedEncodingException {
    	  Tidy tidy = new Tidy();
    	  tidy.setXHTML(true);
    	  tidy.setIndentContent(true);
    	  tidy.setPrintBodyOnly(true);
    	  tidy.setInputEncoding("UTF-8");
    	  tidy.setOutputEncoding("UTF-8");
    	  tidy.setSmartIndent(true);
    	  tidy.setShowWarnings(false);
    	  tidy.setQuiet(true);
    	  tidy.setTidyMark(false);

    	  Document htmlDOM = tidy.parseDOM(new ByteArrayInputStream(html.getBytes()), null);

    	  OutputStream out = new ByteArrayOutputStream();
    	  tidy.pprint(htmlDOM, out);
    	  return out.toString();
    	}
    

    public File generatePdf(@PathVariable("id") long id) throws IOException, DocumentException {
        Context context = getContext(id);
        System.out.println("Generate PDF="+id);
        String html = loadAndFillTemplate(context);
        String xhtml = convertToXhtml(html);
        return renderPdf(xhtml);
    }


    private File renderPdf(String html) throws IOException, DocumentException {
        File file = File.createTempFile("students", ".pdf");
        OutputStream outputStream = new FileOutputStream(file);
        ITextRenderer renderer = new ITextRenderer(20f * 4f / 3f, 20);
        renderer.setDocumentFromString(html, new ClassPathResource(PDF_RESOURCES).getURL().toExternalForm());
        renderer.layout();
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        renderer.createPDF(outputStream);
        outputStream.close();
        file.deleteOnExit();
        return file;
    }
/*
    private Context getContext(long id) {
        Context context = new Context();
        context.setVariable("students", studentService.getResume(id));
        return context;
    }
    */
    private Context getContext(@PathVariable("id") long id) {
        Context context = new Context();
        context.setVariable("students", studentService.getResume(id));
        System.out.println("PDF SEVICE="+id);
        return context;
    }

    private String loadAndFillTemplate(Context context) 
    {
  
        return templateEngine.process("thymeleaf/pdf_resume", context);
    }


}