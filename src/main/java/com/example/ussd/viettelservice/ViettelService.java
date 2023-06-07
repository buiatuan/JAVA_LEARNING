package com.example.ussd.viettelservice;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(serviceName = "viettel-service", targetNamespace = "http://viettel.com/xsd")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class ViettelService implements IViettelService {

    @Override
    public String start(@WebParam(name = "user") String user,
                        @WebParam(name = "pass") String pass,
                        @WebParam(name = "imsi") String imsi,
                        @WebParam(name = "msg") String message,
                        @WebParam(name = "sessionid") String sessionId,
                        @WebParam(name = "transactionid") String transactionId,
                        @WebParam(name = "requestType") String requestType,
                        @WebParam(name = "ussdgw_id") String ussdgwId,
                        @WebParam(name = "msisdn") String msisdn) {
        System.out.println(message);
        return "0";
    }
}
