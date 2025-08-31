# Template Design Pattern


1. Defines the template method (final) that outlines the algorithm's structure and declares abstract methods for steps that subclasses will implement
2. The template method is marked final to prevent subclasses from altering the algorithm's structure
3. Abstract methods are implemented by subclasses to provide specific behavior

**Use case**

1. Create the Abstract Class, Make abstract method as final in on method.
2. create the class and extend the method, it forceFully override the abstract method
3. you can override the default method you can override and you can you custome logic

## Real Time use Cases

**Data Processing Pipelines**

In ETL (Extract, Transform, Load) systems, data processing often follows a fixed sequence: extract data from a source, transform it, and load it into a destination. Different data sources (e.g., CSV, database, API) require different extraction or transformation logic, but the overall process remains the same.

```Java
abstract class DataProcessor {
    // Template method
    public final void processData() {
        extract();
        transform();
        load();
    }

    protected abstract void extract();
    protected abstract void transform();
    protected abstract void load();
}

class CSVDataProcessor extends DataProcessor {
    @Override
    protected void extract() {
        System.out.println("Extracting data from CSV file");
    }

    @Override
    protected void transform() {
        System.out.println("Transforming CSV data");
    }

    @Override
    protected void load() {
        System.out.println("Loading CSV data to database");
    }
}

class DatabaseDataProcessor extends DataProcessor {
    @Override
    protected void extract() {
        System.out.println("Extracting data from database");
    }

    @Override
    protected void transform() {
        System.out.println("Transforming database data");
    }

    @Override
    protected void load() {
        System.out.println("Loading data to data warehouse");
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        DataProcessor csvProcessor = new CSVDataProcessor();
        csvProcessor.processData();

        DataProcessor dbProcessor = new DatabaseDataProcessor();
        dbProcessor.processData();
    }
}
```

**Web Request Processing**

In web applications, HTTP request processing follows a standard sequence: authenticate the request, validate input, process the business logic, and send a response. Different endpoints may have unique validation or processing logic, but the overall flow is consistent.


```Java
abstract class RequestHandler {
    // Template method
    public final void handleRequest() {
        authenticate();
        validate();
        process();
        sendResponse();
    }

    protected void authenticate() {
        System.out.println("Authenticating request");
    }

    protected abstract void validate();
    protected abstract void process();
    protected void sendResponse() {
        System.out.println("Sending response");
    }
}

class UserRequestHandler extends RequestHandler {
    @Override
    protected void validate() {
        System.out.println("Validating user request");
    }

    @Override
    protected void process() {
        System.out.println("Processing user request");
    }
}

class OrderRequestHandler extends RequestHandler {
    @Override
    protected void validate() {
        System.out.println("Validating order request");
    }

    @Override
    protected void process() {
        System.out.println("Processing order request");
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        RequestHandler userHandler = new UserRequestHandler();
        userHandler.handleRequest();

        RequestHandler orderHandler = new OrderRequestHandler();
        orderHandler.handleRequest();
    }
}
```

**Report Generation**

Generating reports (e.g., PDF, Excel, HTML) involves a fixed sequence: fetch data, format it, and export it to a file. The data source or output format may vary, but the process remains the same.

```Java
abstract class ReportGenerator {
    // Template method
    public final void generateReport() {
        fetchData();
        formatData();
        export();
    }

    protected void fetchData() {
        System.out.println("Fetching data from source");
    }

    protected abstract void formatData();
    protected abstract void export();
}

class PDFReportGenerator extends ReportGenerator {
    @Override
    protected void formatData() {
        System.out.println("Formatting data for PDF");
    }

    @Override
    protected void export() {
        System.out.println("Exporting to PDF file");
    }
}

class ExcelReportGenerator extends ReportGenerator {
    @Override
    protected void formatData() {
        System.out.println("Formatting data for Excel");
    }

    @Override
    protected void export() {
        System.out.println("Exporting to Excel file");
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        ReportGenerator pdfReport = new PDFReportGenerator();
        pdfReport.generateReport();

        ReportGenerator excelReport = new ExcelReportGenerator();
        excelReport.generateReport();
    }
}
```

**Order Processing in E-Commerce**

```JavA
abstract class OrderProcessor {
    // Template method
    public final void processOrder() {
        validateOrder();
        processPayment();
        updateInventory();
        notifyCustomer();
    }

    protected abstract void validateOrder();
    protected void processPayment() {
        System.out.println("Processing payment");
    }
    protected abstract void updateInventory();
    protected abstract void notifyCustomer();
}

class PhysicalOrderProcessor extends OrderProcessor {
    @Override
    protected void validateOrder() {
        System.out.println("Validating physical goods order");
    }

    @Override
    protected void updateInventory() {
        System.out.println("Updating inventory for physical goods");
    }

    @Override
    protected void notifyCustomer() {
        System.out.println("Notifying customer via email with shipping details");
    }
}

class DigitalOrderProcessor extends OrderProcessor {
    @Override
    protected void validateOrder() {
        System.out.println("Validating digital goods order");
    }

    @Override
    protected void updateInventory() {
        System.out.println("No inventory update needed for digital goods");
    }

    @Override
    protected void notifyCustomer() {
        System.out.println("Notifying customer via email with download link");
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        OrderProcessor physicalOrder = new PhysicalOrderProcessor();
        physicalOrder.processOrder();

        System.out.println("---");

        OrderProcessor digitalOrder = new DigitalOrderProcessor();
        digitalOrder.processOrder();
    }
}
```

