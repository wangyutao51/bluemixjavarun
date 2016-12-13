/**
 * ConversationController.java
 *TODO	
 */
package com.ibm.conversation;

import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;

/**
 * @author Yu Tao Wang
 *
 */
public class ConversationController
{

	public static void main(String[] args)
	{
		ConversationService service = new ConversationService(
				ConversationService.VERSION_DATE_2016_09_20,
				"390ce196-75f9-48ca-ac50-6de5dfb5181c", "kBahYbkUQIAD");
		
		String WORKSPACE_ID = "5147a357-bb14-4a94-8359-6bcc7d263839";
		service.getToken();
		
		String text = "Turn off the radio.";
		
	    MessageRequest request = new MessageRequest.Builder().inputText(text).build();
	    MessageResponse response = service.message(WORKSPACE_ID, request).execute();
	    System.out.println(response);
	}
	
}
