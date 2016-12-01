/**
 * 
 */
package com.wyt.test.action;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wyt.test.service.ITestService;

/**
 * @author WANG
 *
 */
@Controller
@RequestMapping("test")
public class TestAction
{
	
	private Logger log = Logger.getLogger(TestAction.class);
	
	@Resource(name="testServiceImpl")
	private ITestService testService;
	
	@RequestMapping(value="init.do",method=RequestMethod.GET)
	public String TestInit()
	{
		log.info("The action is runing");
		
		return "/index";
	}

	public Logger getLog()
	{
		return log;
	}

	public void setLog(Logger log)
	{
		this.log = log;
	}

	public ITestService getTestService()
	{
		return testService;
	}

	public void setTestService(ITestService testService)
	{
		this.testService = testService;
	}
	
}
