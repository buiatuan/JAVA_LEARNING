package com.example.ussd.viettelservice;

import javax.jws.WebMethod;

public interface IViettelService {

    @WebMethod(operationName = "start")
    String start(String user,
                 String pass,
                 String imsi,
                 String message,
                 String sessionId,
                 String transactionId,
                 String requestType,
                 String ussdgw_id,
                 String msisdn);
}
