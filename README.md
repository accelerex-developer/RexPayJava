This is a JAVA library for implementing RexPayJava payment 

#Getting Started This JAVA library provides a wrapper to implement RexPayJava Payment to your application for Both Maven and Gradle

#IMPORTING LIBRARY TO YOUR PROJECT

#MAVEN PROJECT

This library can be implemented into your application by importing it.

Download RexPayJava.zip from  https://github.com/accelerex-developer/RexPayJava/raw/master/RexPayJava.zip extract the file and copy it to your project folder

procedure to Add a jar file as a Module to your Java project:

  On IntelliJ IDEA: File -> Project Structure -> libraries -> Click + sign then select java ->select the RexPayJava.jar from the Directories you copy it to-> click ok and apply
  
  On Netbeans: Project properties -> Libraries -> Compile -> ADD JAR/folder -> Add Jar



  #GRADLE PROJECT

This library can be implemented into your application by importing it.

#Option 1

Download RexPayJava.zip from  https://github.com/accelerex-developer/RexPayJava/raw/master/RexPayJava.zip  and Extract the RexPayJava.jar file
create a folder name libs in your project module
copy the RexPayJava.jar file you extracted to the libs folder you created
add implementation fileTree(include: ['*.jar'], dir: 'libs') to your build.gradle dependencies (note: only add that line once, if already in your project, don't add it again)
reload your build.gradle
#Option 2

Download RexPayJava.zip from  https://github.com/accelerex-developer/RexPayJava/raw/master/RexPayJava.zip and Extract the RexPayJava.jar file
create a folder name libs in your project module
copy the RexPayJava.jar file you extracted to the libs folder you created
Add implementation files('libs/RexPayJava.jar')
please only use either of the option, dont use both. option 1 will add all libraries in your libs folder while option 2 will only add the specific library



#USAGE
#For Create payment Method


#NOTE for test purposes use "Test" as mode and use "production" for the production environment 

PaymentTransaction paymentTransaction = new PaymentTransaction();

ResponseData ss = paymentTransaction.createPayment( string mode, String referenceNumber, String customerName, double amount, String email, String userId, String callbackUrl, String username, String password);

this method returned status of the createPayment payment, referenceNumber and Authorization URL(paymentUrl) which you will redirect your user to for payment.

#For transactionStatus  Method

PaymentTransaction paymentTransaction = new PaymentTransaction();

JSONObject ss = paymentTransaction.transactionStatus("String mode, String referenceNumber, String username, String password);

Sample Test CreatePayment request 
transaction.createPayment("Test","sm23oyr1122","Victor Musa", 2.6,"awoyeyetimilehin@gmail.com","awoyeyetimilehin@gmail.com","www.google.com", "talk2phasahsyyahoocom","f0bedbea93df09264a4f09a6b38de6e9b924b6cb92bf4a0c07ce46f26f85");

Response::::{
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

Sample Transaction status :

paymentTransaction.transactionStatus("test","sm23oyr1122","talk2phasahsyyahoocom","f0bedbea93df09264a4f09a6b38de6e9b924b6cb92bf4a0c07ce46f26f85");

Response:: {
    "amount": "2.00",
    "paymentReference": "sm23oyr1122",
    "transactionDate": "12/01/2024 11:49",
    "currency": "NGN",
    "fees": 0.03,
    "channel": "CARD",
    "responseCode": "02",
    "responseDescription": "Transaction is Pending"
}








