package com.example.ussd;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(serviceName = "sayHello", targetNamespace = "http://soap.mps.ra.com")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class SoapService implements ISoap {

    @Override
    public String sayHello(@WebParam(name = "name") String name) {
        return "Hello " + name + ".!";
    }
}
