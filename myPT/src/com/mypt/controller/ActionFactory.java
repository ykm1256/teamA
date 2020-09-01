package com.mypt.controller;

import java.util.HashMap;
import java.util.Map;

import com.mypt.controller.action.list.TrainerListViewAction;
import com.mypt.controller.action.list.UserListViewAction;


public class ActionFactory 
{
	
	//싱글톤
	private static ActionFactory instance = new ActionFactory();
	
	public static ActionFactory getInstance() 
	{
		return instance;
	}
	
	private ActionFactory()
	{
		//차트기능
//		map.put("/chartExam", new ChartExamAction());
		
		//address기능
//		map.put("/addressList",new AddressListAction());
//		map.put("/addressView",new AddressViewAction());
//		map.put("/addrInsert", new AddressInsertAction());
//		map.put("/addrInsertPro", new AddrInsertProAction());
		
		//userList
		map.put("/userList", new UserListViewAction());
		//trainerList
		map.put("/trainerList", new TrainerListViewAction());
		
	}
	
	private Map<String, Action> map = new HashMap< >();	
	
	
	public Action getAction(String command)
	{
		Action action = null;
		
		action = map.get(command);
		
		return action;
	}
	
}
