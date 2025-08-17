# Adapter Design Pattern

**actory Method (In/Out prinicpal)**

1. The Adapter Pattern is a structural design pattern.
2. The adapter acts like a bridge between two different systems.

## Real Time use Cases


1. Legacy System Integration

* Suppose you have a modern app that expects JSON but your legacy system only gives XML.

```Java
interface DataReader {
   String getData();
}

class XMLReader {
   String getXMLData() { return "<data>...</data>"; }
}

class XMLToJSONAdapter implements DataReader {
   private XMLReader xmlReader;
   public XMLToJSONAdapter(XMLReader reader) { this.xmlReader = reader; }
   public String getData() {
      String xml = xmlReader.getXMLData();
      return convertXMLtoJSON(xml); // conversion logic
   }
}
```


2. Different File Format Readers

* Imagine an application that needs to read .csv, .xlsx, .json.
* Instead of rewriting everything, create adapters for each format so all can be read via a common interface.

3. E-commerce Payment Ecosystem

```Java
PaymentFactory factory = new CreditCardFactory();
Validator validator = factory.createValidator();
Processor processor = factory.createProcessor();
```

* CreditCardFactory → CreditCardValidator, CreditCardProcessor.
* PayPalFactory → PayPalValidator, PayPalProcessor.

5. Cloud Providers SDKs

```Java
CloudResourceFactory factory = new AWSFactory();
Storage storage = factory.createStorage();
Compute compute = factory.createCompute();
```

* AWSFactory → creates S3Storage, EC2Compute.
* AzureFactory → creates BlobStorage, AzureVMCompute.



