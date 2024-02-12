package com.globalaccelerex.pgs.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.globalaccelerex.pgs.entities.*;
import org.json.JSONObject;

public class PaymentTransaction  {
    private Connections connections;

    public Object createPayment(String mode, String referenceNumber, String customerName,
                                                                       double amount, String email, String userId,
                                                                       String callbackUrl, String username, String password) {
            try {
                this.connections = new Connections(username, password,
                        mode.equalsIgnoreCase("production") ? Enums.liveUrlCreate : Enums.testUrlCreate);

                MetaData metaData = MetaData.builder()
                        .customerName(customerName)
                        .email(email)
                        .build();

                CreatePaymentRequest request = CreatePaymentRequest.builder()
                        .reference(referenceNumber)
                        .amount(amount)
                        .currency("NGN")
                        .userId(userId)
                        .callbackUrl(callbackUrl)
                        .metadata(metaData)
                        .build();

                JSONObject response = this.connections.post(request);

                ObjectMapper mapper = new ObjectMapper();
                return mapper.readValue(response.toString(), Object.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException("Error processing JSON", e);
            }
    }

    public Object transactionStatus(String mode, String referenceNumber,
                                                                               String username, String password) {
            try {
                this.connections = new Connections(username, password,
                        mode.equalsIgnoreCase("production") ? Enums.liveUrlQuery : Enums.testUrlQuery);
                TransactionStatusRequest request = TransactionStatusRequest.builder()
                        .transactionReference(referenceNumber)
                        .build();
                JSONObject response = this.connections.post(request);
                ObjectMapper mapper = new ObjectMapper();
                return mapper.readValue(response.toString(), Object.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException("Error processing JSON", e);
            }
    }
}
