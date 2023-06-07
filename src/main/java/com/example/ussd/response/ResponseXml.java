package com.example.ussd.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "errorType"
})
@XmlRootElement(name = "ussdresponse")
public class ResponseXml {
    String errorType;
    public ResponseXml() {}
    public ResponseXml(String errorType) {
        this.errorType = errorType;
    }
}
