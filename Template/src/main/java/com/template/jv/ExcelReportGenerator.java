package com.template.jv;

public class ExcelReportGenerator extends ReportGenerator {

	@Override
	void fetchData() {
		System.out.println("Fetching data for Excel report from API");
	}

	@Override
	void formatData() {
		System.out.println("Formate and Exporting to Excel report");
	}
}
