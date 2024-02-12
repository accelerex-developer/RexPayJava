package com.globalaccelerex.pgs.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionStatusResponse {
    public String amount;
    public String paymentReference;
    public String transactionDate;
    public String currency;
    public double fees;
    public String channel;
    public String responseCode;
    public String responseDescription;
}
