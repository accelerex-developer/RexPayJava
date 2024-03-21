# RexPayJava Library

The RexPayJava library provides a convenient wrapper for integrating RexPayJava payments into your Java applications.

## Getting Started

This library supports both Maven and Gradle for easy integration into your projects.

### Maven Project

To add the RexPayJava library to your Maven project:

1.  Download the RexpayLibrary.rar file from [here](https://github.com/accelerex-developer/RexPayJava/raw/main/RexpayLibrary.rar).
2.  Extract the RexpayLibrary.jar file from the downloaded zip file.
3.  Copy the RexpayLibrary.jar file into your project directory.
4.  Add the jar file as a module to your Java project:
    -   For IntelliJ IDEA:
        -   Navigate to `File` -> `Project Structure`.
        -   Click on `Libraries` and then the `+` sign.
        -   Select `Java` and choose the RexpayLibrary.jar file from the directory where you copied it.
        -   Click `OK` and then `Apply`.
    -   For NetBeans:
        -   Navigate to `Project Properties`.
        -   Go to `Libraries` -> `Compile` and click `Add JAR/Folder`.
        -   Select the RexpayLibrary.jar file from the directory where you copied it.   
5. ** Add Below Dependency to pom.xml file:**

pom.xml
```
<dependency>  
 <groupId>com.fasterxml.jackson.core</groupId>  
 <artifactId>jackson-databind</artifactId>  
 <version>2.13.4</version>  
</dependency>  

<dependency>  
 <groupId>com.konghq</groupId>  
 <artifactId>unirest-java</artifactId>  
 <version>3.13.6</version>  
</dependency>  

<dependency>  
 <groupId>com.mashape.unirest</groupId>  
 <artifactId>unirest-java</artifactId>  
 <version>1.4.9</version> <!-- Adjust the version as needed -->  
</dependency>

```


### Gradle Project

To add the RexPayJava library to your Gradle project, you have two options:

#### Option 1

1.  Download the RexpayLibrary.rarfile from [here](https://github.com/accelerex-developer/RexPayJava/raw/main/RexpayLibrary.rar).
    
2.  Extract the RexpayLibrary.jar file from the downloaded zip file.
    
3.  Create a folder named `libs` in your project module.
    
4.  Copy the RexpayLibrary.jar file into the `libs` folder.
    
5.  Add the following line to your build.gradle file's dependencies block:
       ```
    'implementation files('libs/RexpayLibrary.jar')'
	'implementation 'com.konghq:unirest-java:3.13.6'
	'implementation 'com.mashape.unirest:unirest-java:1.4.9'
	'implementation 'com.fasterxml.jackson.core:jackson-databind:2.13.4'
 
`6.  Reload your build.gradle file.
    

#### Option 2

1.  Download the RexpayLibrary.rar file from [here](https://github.com/accelerex-developer/RexPayJava/raw/main/RexpayLibrary.rar).
    
2.  Extract the RexpayLibrary.jar file from the downloaded zip file.
    
3.  Create a folder named `libs` in your project module.
    
4.  Copy the RexpayLibrary.jar file into the `libs` folder.
    
5.  Add the following line to your build.gradle file's dependencies block:
    ```
    'implementation files('libs/RexpayLibrary.jar')'
	'implementation 'com.konghq:unirest-java:3.13.6'
	'implementation 'com.mashape.unirest:unirest-java:1.4.9'
	'implementation 'com.fasterxml.jackson.core:jackson-databind:2.13.4'
 
6.  Ensure to only use one of the options, not both.
7. Reload your build.gradle file.


# Usage

## Creating a Payment
To create a payment, use the following method:
initialize Payment class 

Payment payment = new Payment();
also initialize CreatePaymentRequestDto to build your request
CreatePaymentRequestDto request = new CreatePaymentRequestDto();
call the creatpament method and pass the necessary information.
get base64 of the username and password separated with fullcolon eg base64(username:password)
CreateRequestResponse res = payment.createPayment(request, base64(username:password));
Replace the placeholders with your actual data. 
For test purposes, use `"test"`  as the mode and "production" for live.
#### Example

 

      ###Request
        Payment payment = new Payment();
            CreatePaymentRequestDto requestDto = CreatePaymentRequestDto.builder()  
                  .amount(10.0)  
                  .callbackUrl("www.google.com")  
                  .customerName("faymos")  
                  .email("awoyeyetimilehin@gmail.com")  
                  .mode("test")  
                  .referenceNumber("sm23oyr1122")  
                  .userId("awoyeyetimilehin@gmail.com")  
                  .build(); 
		  
          String result = "talk2phasahsyyahoocom"+":"+"f0bedbea93df09264a4f09a6b38de6e9b924b6cb92bf4a0c07ce46f26f85";
	  String encodedString = Base64.getEncoder().encodeToString(result.getBytes());

        CreateRequestResponse response = payment.createPayment(requestDto,  
          encodedString);
  
  

    Sample Response:
        {
            "reference": "sm23oyr1122",
            "clientId": "talk2phasahsyyahoocom",
            "paymentUrl": "https://checkout-dev.globalaccelerex.com/pay/170506013zAoMmvkMu",
            "status": "ONGOING",
            "paymentChannel": "CARD",
            "paymentUrlReference": "170506013zAoMmvkMu",
            "externalPaymentReference": "170506013zAoMmvkMu",
            "fees": 0.03,
            "currency": "NGN"
        }


## Checking Transaction Status

To check the status of a transaction, use the following method:
also initialize TransactionStatusDto to build your request
TransactionStatusDto request = new TransactionStatusDto();
call the transactionStatus method and pass the necessary information.
get base64 of the username and password separated with fullcolon eg base64(username:password)
TransactionStatusResponse res = payment.transactionStatus(request, base64(username:password));


### Sample Requests and Responses

#### Transaction Status Request

    TransactionStatusDto transactionStatusDto = TransactionStatusDto.builder()  
          .mode("test")  
          .referenceNumber("sm23oyr1122")  
          .build();  
	   String result = "talk2phasahsyyahoocom"+":"+"f0bedbea93df09264a4f09a6b38de6e9b924b6cb92bf4a0c07ce46f26f85";
	  String encodedString = Base64.getEncoder().encodeToString(result.getBytes());
    TransactionStatusResponse response = payment.transactionStatus(transactionStatusDto,  
     encodedString
    );` 

#### Response:

`{
    "amount": "2.00",
    "paymentReference": "sm23oyr1122",
    "transactionDate": "12/01/2024 11:49",
    "currency": "NGN",
    "fees": 0.03,
    "channel": "CARD",
    "responseCode": "02",
    "responseDescription": "Transaction is Pending"
}`


#
## Parameters Details

1.  **mode**: A string indicating the mode of operation, typically used for testing (`"Test"`) or production (`"Production"`). This parameter determines the environment in which the payment transaction will be processed.
    
2.  **referenceNumber**: A string representing a unique reference number associated with the payment transaction. This reference number is used to identify and track the payment.
    
3.  **customerName**: A string representing the name of the customer initiating the payment transaction. This parameter provides information about the customer associated with the payment.
    
4.  **amount**: A double value representing the amount of money involved in the payment transaction. This parameter specifies the monetary value of the payment to be processed.
    
5.  **email**: A string representing the email address of the customer initiating the payment transaction. This parameter is used to contact the customer or send notifications related to the payment.
    
6.  **userId**: A string representing the unique identifier of the user initiating the payment transaction. This parameter helps identify the user within the system or application.
    
7.  **callbackUrl**: A string representing the URL to which the payment gateway should send callback notifications or responses related to the payment transaction. This parameter is used for handling asynchronous payment responses or updates.
    
8.  **username**: A string representing the username or credentials required for authentication when interacting with the payment gateway or API. This parameter is used for authenticating the application or user making the payment request.
    
9.  **password**: A string representing the password or credentials required for authentication when interacting with the payment gateway or API. This parameter, along with the username, is used for secure authentication during the payment transaction process.

10.  **reference**: A string representing a unique reference number associated with the payment transaction. This reference number is generated by the payment system and is used to identify and track the payment.
    
11.  **clientId**: A string representing the client ID or identifier associated with the payment transaction. This identifier may refer to the customer or client initiating the payment.
    
12.  **paymentUrl**: A string representing the URL to the payment gateway or payment processing page where the customer can complete the payment transaction. This URL is provided as a link for the customer to proceed with the payment.
    
13.  **status**: A string indicating the current status of the payment transaction. Common status values include "ONGOING", "SUCCESS", "FAILED", etc., indicating whether the payment was successfully processed or not.
    
14.  **paymentChannel**: A string indicating the payment channel or method used for the payment transaction. Examples include "CARD" for credit/debit card payments, "BANK_TRANSFER" for bank transfers, etc.
    
15.  **paymentUrlReference**: A string representing a reference or identifier associated with the payment URL. This reference may be used internally by the payment system to track or identify the specific payment transaction.
    
16.  **externalPaymentReference**: A string representing an external reference or identifier associated with the payment transaction. This reference may be provided by an external system or service integrated with the payment system.
    
17.  **fees**: A double value representing any fees or charges associated with the payment transaction. This parameter specifies the additional costs incurred by the customer for processing the payment.
    
18.  **currency**: A string representing the currency used for the payment transaction. This parameter specifies the currency in which the payment amount and fees are denominated (e.g.,  "NGN", etc.). 

    
19.  **paymentReference**: A string representing a unique reference number associated with the payment transaction. This reference number is used to identify and track the payment within the system.
    
20.  **transactionDate**: A string representing the date and time when the transaction occurred. This parameter provides the timestamp of when the transaction was processed.
    
21.  **responseCode**: A string representing the response code indicating the status or outcome of the transaction. This parameter provides a code that represents the result of the transaction processing.
    
22.  **responseDescription**: A string providing a description or message explaining the response code. This parameter offers additional information about the outcome of the transaction, such as success, failure, or pending status.




