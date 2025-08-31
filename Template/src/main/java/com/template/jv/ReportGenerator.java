package com.template.jv;

public abstract class ReportGenerator {

	// Template method (final to prevent overriding)
	public final void generateReport() {
		fetchData();
		formatData();
	}

	// Abstract methods to be implemented by subclasses
	abstract void fetchData();

	// Hook method with default implementation (optional to override)
	void formatData() {
		System.out.println("Formate and Exporting report to default format As PDF");
	}

}
