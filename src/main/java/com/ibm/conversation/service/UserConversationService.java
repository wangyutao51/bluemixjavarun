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
	private static ConversationService conversationService = null;

	private UserConversationService()
	{

	}

	public static synchronized ConversationService newConversationService(
			String versionDate, String userName, String passWd)
	{
		if (null == conversationService)
		{
			conversationService = new ConversationService(versionDate, userName, passWd);
		}
		return conversationService;
	}
}
