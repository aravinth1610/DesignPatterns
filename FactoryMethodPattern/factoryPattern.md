# Factory Design Pattern

**actory Method (In/Out prinicpal)**

1. Creates one type of product.
2. You want to delegate object creation to subclasses, but you’re dealing with a single product.
3. It provides a way to create objects without exposing the creation logic to the client.
4. Instead of using new directly, we delegate object creation to a factory class/method.

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

1. Database Drivers (JDBC in Java)

```Java
Connection conn = DriverManager.getConnection(url, user, password);
```

* You don’t know whether it’s MySQL, PostgreSQL, Oracle, or SQL Server.
* DriverManager acts as a Factory and gives you the correct Connection object depending on the DB URL.

2. Logging Frameworks (SLF4J / Log4j / Logback)

```Java
Logger logger = LoggerFactory.getLogger(MyClass.class);
```
* LoggerFactory decides whether to create a LogbackLogger, Log4jLogger, etc.
* Your code is decoupled from the specific logging implementation.

3. Payment Gateways (E-commerce apps)

```Java
Payment payment = PaymentFactory.getPaymentMethod("CREDIT_CARD");
payment.pay(1000);
```

* Could return CreditCardPayment, PaypalPayment, UPIPayment, etc.
* The calling code doesn’t care about the actual implementation.

4. Notification Services

```Java
Notification n = NotificationFactory.createNotification("SMS");
n.notifyUser();
```

* Could return SMSNotification, EmailNotification, PushNotification.

5. Document Conversion / Parser

```Java
Parser parser = ParserFactory.getParser("PDF");
```

* Could return PDFParser, ExcelParser, WordParser.

6. GUI Frameworks (Java AWT/Swing, Android Views)

```Java
Button button = ButtonFactory.createButton("Windows");
```

* The factory can create different UI elements based on platform (Windows, Mac, Linux).



