package com.example.ussd;

import com.example.ussd.params.UssdParamModel;
import com.example.ussd.response.ResponseXml;
import com.example.ussd.ussdcomposite.ComponentGetWay;
import com.example.ussd.ussdcomposite.InitComposite;
import com.example.ussd.ussdcomposite.ListenByStoryteller;
import com.example.ussd.ussdcomposite.UssdComponent;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.Map;

@WebService(serviceName = "ussd", targetNamespace = "http://viettel.com/xsd")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class UssdViettelService implements IUssdViettel {

    private Map<String, UssdComponent> mapCurrentLocation = new HashMap<>();
    private UssdComponent welcomeNode;
    private static final String REQUEST_TYPE_CUSTOMER_FIRST_REQUEST = "100";
    private static final String REQUEST_TYPE_CUSTOMER_SEND_CHOSE_MENU = "101";
    private static final String REQUEST_TYPE_TRANSACTION_ERROR = "104";
    private static final String REQUEST_TYPE_SYSTEM_SENT_MENU = "202";

    @Override
    public ResponseXml start(@WebParam(name = "user") String user,
                             @WebParam(name = "pass") String pass,
                             @WebParam(name = "imsi") String imsi,
                             @WebParam(name = "msg") String message,
                             @WebParam(name = "sessionid") String sessionId,
                             @WebParam(name = "transactionid") String transactionId,
                             @WebParam(name = "requestType") String requestType,
                             @WebParam(name = "ussdgw_id") String ussdgwId,
                             @WebParam(name = "msisdn") String msisdn) {
        UssdComponent welcomeNode =  getMenu(new UssdParamModel(imsi,
                requestType,
                transactionId,
                ussdgwId,
                sessionId,
                msisdn));
        welcomeNode.execute();
        return new ResponseXml("1");
    }

    private UssdComponent getMenu(UssdParamModel ussdParamModel) {
        this.welcomeNode = new InitComposite(ussdParamModel);
        ComponentGetWay.getInstance().register("1", welcomeNode);
        welcomeNode.put('1', new ListenByStoryteller(welcomeNode, ussdParamModel));
        return welcomeNode;
    }

}
