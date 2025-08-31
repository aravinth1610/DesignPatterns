package com.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.template.jv.ExcelReportGenerator;
import com.template.jv.PDFReportGenerator;
import com.template.jv.ReportGenerator;

@SpringBootApplication
public class TemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemplateApplication.class, args);
	}

	@Bean
	 String TemplatePatternDemo() {
		ReportGenerator pdfReport = new PDFReportGenerator();
		System.out.println("Generating PDF Report:");
		pdfReport.generateReport();

		System.out.println("\nGenerating Excel Report:");
		ReportGenerator excelReport = new ExcelReportGenerator();
		excelReport.generateReport();
		return "";
	}

}
