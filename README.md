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
CreateRequestResponse res = payment.createPayment(request, username, password);
Replace the placeholders with your actual data. 
For test purposes, use `"Test"`  as the mode and "production" for live.
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
          
        CreateRequestResponse response = payment.createPayment(requestDto,  
          "talk2phasahsyyahoocom",  
         "f0bedbea93df09264a4f09a6b38de6e9b924b6cb92bf4a0c07ce46f26f85");
  
  

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
TransactionStatusResponse res = payment.transactionStatus(request, username, password);


### Sample Requests and Responses

#### Transaction Status Request

    TransactionStatusDto transactionStatusDto = TransactionStatusDto.builder()  
          .mode("test")  
          .referenceNumber("sm23oyr1122")  
          .build();  
    TransactionStatusResponse response = payment.transactionStatus(transactionStatusDto,  
      "talk2phasahsyyahoocom",  
      "f0bedbea93df09264a4f09a6b38de6e9b924b6cb92bf4a0c07ce46f26f85"  
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
