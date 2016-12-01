/**
 * 
 */
package com.wyt.test.cxf.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.wyt.test.cxf.HelloWebservice;

/**
 * @author WANG
 *
 */
@Component
@WebService(targetNamespace="http://www.baidu.com",endpointInterface="com.wyt.test.cxf.HelloWebservice")
public class HelloWebserviceImpl implements HelloWebservice
{

	private static Logger logger = Logger.getLogger(HelloWebserviceImpl.class);

	@WebMethod
	@WebResult
	public String sayhi(@WebParam(name="userID") String userId,@WebParam(name="Location") String location)
	{
		//@WebParam(name="userID")设置生成调用客户端参数名称
		logger.info("Hello " + userId + ",your location is " + location);

		return "Hello " + userId + ",your location is " + location;
	}

	public Logger getLogger()
	{
		return logger;
	}

	public void setLogger(Logger logger)
	{
		HelloWebserviceImpl.logger = logger;
	}

}
