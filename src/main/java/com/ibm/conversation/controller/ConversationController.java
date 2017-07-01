/**
 * ConversationController.java
 * TODO	
 */
package com.ibm.conversation.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.ibm.conversation.service.UserConversationService;
import com.ibm.conversation.utils.JsonUtil;
import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;

/**
 * @author Yu Tao Wang
 *
 */
@Controller
@RequestMapping("/conversation")
@Scope("prototype")
public class ConversationController
{
	private Logger log = Logger.getLogger(ConversationController.class);

	private final static String WORE_SPACE_ID = "c0c6a366-4d45-4bf9-bb16-4ee0a31aa5bf";

	Map<String, Object> context = new HashMap<String, Object>();

	@Autowired
	private UserConversationService userConversationService;
	
	@RequestMapping(value = "init.do", method = RequestMethod.GET)
	public String init(@RequestParam(value = "username", required = false) String username,Model model,HttpServletResponse response,HttpServletRequest request)
	{
		log.info("conversation api init...........");
		log.info(username);
//		model.addAttribute("username", username);
		request.setAttribute("username", username);
		return "conversation/conversation";
	}

	@RequestMapping("mainflow.do")
	public void conversation(String input, String contextid, @RequestParam(value = "username", required = false) String username, HttpServletResponse httpServletResponse,HttpServletRequest request)
			throws IOException
	{
		System.out.println(input + " " + contextid);

		JSONObject json = new JSONObject();

		log.info(contextid);

		if (!StringUtils.isNotEmpty(input))
		{
			String res = "Hello I am Watson, How can I help you? (Get more about us in <a href=\'#\' onclick=\'window.open(\"http://www.ibm.com/watson\"); return;\'> IBM Watson</a>\")";
			if (StringUtils.isNotEmpty(username))
			{
				res = "Hello "+username+" I am Watson, How can I help you? (Get more about us in <a href=\'#\' onclick=\'window.open(\"http://www.ibm.com/watson\"); return;\'> IBM Watson</a>\")";
			}
			
			json.put("contextid", null);
			json.put("text", res);
			httpServletResponse.getWriter().print(json.toString());
			return;
		}

		if (StringUtils.isNotEmpty(contextid))
		{
			context = JsonUtil.convertJsonStrToMap(contextid);
		}

		ConversationService service = userConversationService.newConversationService();

		MessageRequest message = new MessageRequest.Builder().context(context).inputText(input).build();

		MessageResponse msgResponse = service.message(WORE_SPACE_ID, message).execute();

		log.info(msgResponse);

		// context = msgResponse.getContext();

		log.info("==========================================================================");

		log.info(msgResponse.toString());

		Map<String, Object> map = JsonUtil.convertJsonStrToMap(msgResponse.toString());
		context = msgResponse.getContext();
		log.info("==========================================================================");

		Map<String, Object> outputObj = msgResponse.getOutput();

		try
		{

			String res = outputObj.get("text").toString().substring(1, outputObj.get("text").toString().length() - 1);
			if (StringUtils.isEmpty(res))
			{
				res = "I did not quite get that. Please refine your question.";
			}

			json.put("contextid", map.get("context").toString());
			json.put("text", res);
			httpServletResponse.getWriter().print(json.toString());
		} catch (IOException e)
		{
			log.error("print coversation output infomation failed.please check the input.");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping("/demo.do")
	public void conversationDemo(String inputText, HttpServletResponse httpServletResponse,
			HttpServletRequest httpServletRequest)
	{
		if (StringUtils.isEmpty(inputText))
		{
			try
			{
				httpServletResponse.getWriter().print("the input info is null.");
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		// ConversationService service = new ConversationService(
		// ConversationService.VERSION_DATE_2016_09_20,
		// "390ce196-75f9-48ca-ac50-6de5dfb5181c", "kBahYbkUQIAD");

		ConversationService service = userConversationService.newConversationService();

		String WORKSPACE_ID = "5147a357-bb14-4a94-8359-6bcc7d263839";

		MessageRequest msgRequest = new MessageRequest.Builder().inputText(inputText).build();
		MessageResponse msgResponse = service.message(WORKSPACE_ID, msgRequest).execute();
		Map<String, Object> outputObj = msgResponse.getOutput();
		try
		{
			httpServletResponse.getWriter().print(outputObj.get("text").toString());
		} catch (IOException e)
		{
			log.error("print coversation output infomation failed.please check the input.");
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

	public void setUserConversationService(UserConversationService userConversationService)
	{
		this.userConversationService = userConversationService;
	}

}
