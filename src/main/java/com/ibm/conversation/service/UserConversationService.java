/**
 * ConversationService.java
 *TODO	
 */
package com.ibm.conversation.service;

import org.springframework.stereotype.Service;

import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;

/**
 * @author Yu Tao Wang
 *
 */
@Service
public class UserConversationService
{
	private final static String username = "390ce196-75f9-48ca-ac50-6de5dfb5181c";
	
	private final static String password = "kBahYbkUQIAD";
	
	private static ConversationService conversationService = new ConversationService(ConversationService.VERSION_DATE_2016_07_11, username, password);

	private UserConversationService()
	{

	}

	public static synchronized ConversationService newConversationService()
	{
		if (null == conversationService)
		{
			conversationService = new ConversationService(ConversationService.VERSION_DATE_2016_07_11, username, password);
		}
		return conversationService;
	}
}
