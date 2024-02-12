package com.globalaccelerex.pgs.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionStatusRequest {
    public String transactionReference;
}
