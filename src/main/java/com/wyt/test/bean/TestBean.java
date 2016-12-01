/**
 * 
 */
package com.wyt.test.bean;

/**
 * @author WANG
 *
 */
public class TestBean
{
	
	public static TestBean testBean = new TestBean();
	
	private String userName;
	
	private String userId;

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}
	
	
}
