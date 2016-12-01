/**
 * 
 */
package com.wyt.test.cxf;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @author WANG
 *
 */
@WebService(targetNamespace="http://www.baidu.com")
public interface HelloWebservice {
	
	@WebMethod
	@WebResult
	public String sayhi(@WebParam(name="userID") String userId,@WebParam(name="Location") String location);
	
}
