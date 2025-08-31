package com.template.jv;

public class PDFReportGenerator extends ReportGenerator {

	@Override
	void fetchData() {
		System.out.println("Fetching data for PDF report from database");
	}

}
