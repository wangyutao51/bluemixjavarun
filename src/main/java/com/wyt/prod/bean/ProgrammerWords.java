package com.wyt.prod.bean;

import java.io.Serializable;

public class ProgrammerWords implements Serializable
{
	private static final long serialVersionUID = -8970377847894427931L;

	private String words;
	
	private String status;
	
	private String emotion;

	public String getWords()
	{
		return words;
	}

	public ProgrammerWords(String words)
	{
		this.words = words;
	}
	
	public void setWords(String words)
	{
		this.words = words;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getEmotion()
	{
		return emotion;
	}

	public void setEmotion(String emotion)
	{
		this.emotion = emotion;
	}
	
	
}
