package com.example.ussd;

import javax.jws.WebMethod;

public interface ISoap {

    @WebMethod(operationName = "sayHello")
    String sayHello(String name);
}
