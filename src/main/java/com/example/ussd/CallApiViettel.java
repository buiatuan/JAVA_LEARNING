package com.example.ussd;

import com.example.ussd.params.UssdParamModel;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

public class CallApiViettel {

    public static CallApiViettel getInstance() {
        return CallApiViettelHolder.INSTANCE;
    }

    private CallApiViettel() {
    }

    public static final String USER = "Movitel";
    public static final String PASSWORD = "Movitel1234";

    public String callApiViettelSendMenu(String content, UssdParamModel ussdParamModel) {
        String url = "http://localhost:8080/musicws/viettel-service?wsdl";
        String response = "";
        String error = "";
        PostMethod post = new PostMethod(url);
        try {
            HttpClient httpclient = new HttpClient();
            String reqContent
                    = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
                    + "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n"
                    + "        xmlns:urn=\"http://viettel.com/xsd\">\n"
                    + "    <soapenv:Header/>\n"
                    + "    <soapenv:Body>\n"
                    + "        <urn:start>\n"
                    + "            <user>" + USER + "</user>\n"
                    + "            <pass>" + PASSWORD + "</pass>   \n"
                    + "            <imsi>" + ussdParamModel.getImsi() + "</imsi>\n"
                    + "            <msg>" + content + "</msg>\n"
                    + "            <sessionid>" + ussdParamModel.getSessionId() + "</sessionid>\n"
                    + "            <transactionid>" + ussdParamModel.getTransactionId() + "</transactionid>\n"
                    + "            <requestType>" + ussdParamModel.getRequestType() + "</requestType>\n"
                    + "            <ussdgw_id>" + ussdParamModel.getUssdgwId() + "</ussdgw_id>\n"
                    + "            <msisdn>" + ussdParamModel.getMsisdn() + "</msisdn>  \n"
                    + "        </urn:start>\n"
                    + "    </soapenv:Body>\n"
                    + "</soapenv:Envelope>\n";

            RequestEntity entity = new StringRequestEntity(reqContent, "text/xml", "UTF-8");
            post.setRequestEntity(entity);
            httpclient.executeMethod(post);
            response = post.getResponseBodyAsString();
            int start = response.indexOf("<return>") + "<return>".length();
            int end = response.lastIndexOf("</return>");
            error = response.substring(start, end);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("soap message error " + ex.getMessage());
            System.out.println("response content:" + response);
            error = "1";
        } finally {
            post.releaseConnection();
        }
        return error;
    }

    private static class CallApiViettelHolder {
        private static final CallApiViettel INSTANCE = new CallApiViettel();

        private CallApiViettelHolder() {
        }
    }
}
