# Abstract Factory Design Pattern

**actory Method (In/Out prinicpal)**

1. Creates Multiple type of product.
2. Creates multiple related products that belong to the same family.
3. Provides an interface to create families of related objects without specifying their concrete classes.
4. Instead of creating a single product (like Factory Method), it creates multiple related products.

## Use case

1) communication Services as Interface with has one method to Implement to all the Concreate class
2) Create a Concreate services class, Like -> EmailServices, SMSServices etc.
3) Create the Factory Services Class, In that create the Factory Method(return the communication Services Interface) to get based on preferred Services,  In that create the method to sendMessage 
4) In MAIN Class we can create the Object for FactoryServices Class and We can use the Factory method


## Real Time use Cases

Spring Framework (Beans)

```Java
ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
Vehicle vehicle = context.getBean("car", Vehicle.class);
```
* Spring internally uses a Factory Pattern (BeanFactory) to create and manage objects.

1. Database Engines

```Java
DBFactory factory = new MySQLFactory();
Connection conn = factory.createConnection();
Statement stmt = factory.createStatement();
```

* MySQLFactory returns MySQLConnection and MySQLStatement.
* OracleFactory returns OracleConnection and OracleStatement.

2. Cross-platform UI (OS-specific UI elements)

```Java
UIFactory factory = new WindowsUIFactory();  
Button btn = factory.createButton();  
Checkbox chk = factory.createCheckbox();
```
* WindowsUIFactory → creates WindowsButton, WindowsCheckbox.
* MacUIFactory → creates MacButton, MacCheckbox.

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



