package com.globalaccelerex.pgs.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRequestResponse {
    public String reference;
    public String clientId;
    public String paymentUrl;
    public String status;
    public String paymentChannel;
    public String paymentUrlReference;
    public String externalPaymentReference;
    public double fees;
    public String currency;
}
