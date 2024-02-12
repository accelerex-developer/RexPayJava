package com.globalaccelerex.pgs.entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreatePaymentRequest {
    public String reference;
    public double amount;
    public String currency;
    public String userId;
    public String callbackUrl;
    public MetaData metadata;
}
