package com.example.ussd.params;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UssdParamModel {
    private String imsi;
    private String requestType;
    private String transactionId;
    private String ussdgwId;
    private String sessionId;
    private String msisdn;
}
