package com.msh.util;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ResponseObject {
	
	private String status;
	private Object resObject;
	private List<String> msg;
	private int result;

	
	public void populateMsg(String m)
	{
		if(msg==null)
		{
			msg = new ArrayList<>();
			msg.add(m);
		}
		else
		{
			msg.add(m);
		}
	}
}
