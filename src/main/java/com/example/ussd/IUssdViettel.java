package com.example.ussd;

import com.example.ussd.response.ResponseXml;

import javax.jws.WebMethod;

public interface IUssdViettel {

    @WebMethod(operationName = "start")
    ResponseXml start(String user,
                      String pass,
                      String imsi,
                      String message,
                      String sessionId,
                      String transactionId,
                      String requestType,
                      String ussdgw_id,
                      String msisdn);
}
