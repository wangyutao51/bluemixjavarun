package com.wyt.test.cxf.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.18
 * 2016-07-31T22:05:51.412+08:00
 * Generated source version: 2.7.18
 * 
 */
@WebService(targetNamespace = "http://www.baidu.com", name = "HelloWebservice")
@XmlSeeAlso({ObjectFactory.class})
public interface HelloWebserviceClient {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "sayhi", targetNamespace = "http://www.baidu.com", className = "com.wyt.test.cxf.client.Sayhi")
    @WebMethod
    @ResponseWrapper(localName = "sayhiResponse", targetNamespace = "http://www.baidu.com", className = "com.wyt.test.cxf.client.SayhiResponse")
    public java.lang.String sayhi(
        @WebParam(name = "userID", targetNamespace = "")
        java.lang.String userID,
        @WebParam(name = "Location", targetNamespace = "")
        java.lang.String location
    );
}
