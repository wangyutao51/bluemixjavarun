/**
 * ConversationController.java
 * TODO	
 */
package com.ibm.conversation.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ibm.conversation.service.UserConversationService;
import com.ibm.utils.IPUtils;
import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;

/**
 * @author Yu Tao Wang
 *
 */
@Controller
@RequestMapping("/conversation")
public class ConversationController
{
	private Logger log = Logger.getLogger(ConversationController.class);

	@Autowired
	private UserConversationService userConversationService;

	@RequestMapping(value = "init.do", method = RequestMethod.GET)
	public String init()
	{
		log.info("conversation api init...........");
		return "conversation/conversation";
	}

	@RequestMapping("/demo.do")
	public void conversationDemo(String inputText,
			HttpServletResponse httpServletResponse,HttpServletRequest httpServletRequest)
	{
		log.error("访问Conversation接口的ip地址为："+IPUtils.getIpAddr(httpServletRequest));
		if (StringUtils.isEmpty(inputText))
		{
			try
			{
				httpServletResponse.getWriter()
						.print("the input info is null.");
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

//		ConversationService service = new ConversationService(
//				ConversationService.VERSION_DATE_2016_09_20,
//				"390ce196-75f9-48ca-ac50-6de5dfb5181c", "kBahYbkUQIAD");

		ConversationService service = userConversationService.newConversationService(
				ConversationService.VERSION_DATE_2016_09_20,
				"390ce196-75f9-48ca-ac50-6de5dfb5181c", "kBahYbkUQIAD");

		String WORKSPACE_ID = "5147a357-bb14-4a94-8359-6bcc7d263839";

		MessageRequest msgRequest = new MessageRequest.Builder()
				.inputText(inputText).build();
		MessageResponse msgResponse = service.message(WORKSPACE_ID, msgRequest)
				.execute();
		Map<String, Object> outputObj = msgResponse.getOutput();
		try
		{
			httpServletResponse.getWriter()
					.print(outputObj.get("text").toString());
		} catch (IOException e)
		{
			log.error(
					"print coversation output infomation failed.please check the input.");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(outputObj.get("text").toString());
	}

	public Logger getLog()
	{
		return log;
	}

	public void setLog(Logger log)
	{
		this.log = log;
	}

	public UserConversationService getUserConversationService()
	{
		return userConversationService;
	}

	public void setUserConversationService(
			UserConversationService userConversationService)
	{
		this.userConversationService = userConversationService;
	}

}
