package com.mypt.controller;

import java.util.HashMap;
import java.util.Map;

import com.mypt.action.check.EmailCheckAction;
import com.mypt.action.check.NickCheckAction;
import com.mypt.action.detail.AdminTrainerDetailAction;
import com.mypt.action.detail.AdminTrainerUpdateAction;
import com.mypt.action.detail.AdminUserDetailAction;
import com.mypt.action.detail.AdminUserUpdateAction;
import com.mypt.action.detail.UserMyDetailAction;
import com.mypt.action.detail.UserMyUpdateAction;
import com.mypt.action.income.IncomeAction;
import com.mypt.action.income.MoveIncomeAction;
import com.mypt.action.list.AdminTrainerListViewAction;
import com.mypt.action.list.AdminUserListViewAction;
import com.mypt.action.list.TrainerUserListViewAction;
import com.mypt.action.login.TrainerLoginAction;
import com.mypt.action.login.UserLoginAction;
import com.mypt.action.move.MoveIntroAction;
import com.mypt.action.move.MoveUserMain;
import com.mypt.action.move.MoveUserRegister;
import com.mypt.action.register.AdminUserRegisterAction;


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
		map.put("/userList", new AdminUserListViewAction());
		//trainerList
		map.put("/trainerList", new AdminTrainerListViewAction());
		//ptUserList
		map.put("/ptUserList", new TrainerUserListViewAction());
		
		// 인트로 화면
		map.put("/moveIntro", new MoveIntroAction());
		//userLogin
		map.put("/userLogin", new UserLoginAction());
		map.put("/userMain", new MoveUserMain());
		
		//trainerLogin
		map.put("/trainerLogin", new TrainerLoginAction());
		
		//회원가입
		map.put("/moveUserRegister", new MoveUserRegister());		

		map.put("/userInsertAction", new AdminUserRegisterAction());
		map.put("/nickCheck", new NickCheckAction());
		map.put("/emailCheck", new EmailCheckAction());
		
		//매출
		map.put("/moveIncome", new MoveIncomeAction());
		map.put("/incomeChart", new IncomeAction());
		
		//detail
		map.put("/adminTrainerDetail", new AdminTrainerDetailAction());
		map.put("/adminUserDetail", new AdminUserDetailAction());
		map.put("/userMyDetail", new UserMyDetailAction());
		
		//update
		map.put("/userMyUpdate", new UserMyUpdateAction());
		map.put("/adminTrainerUpdate", new AdminTrainerUpdateAction());
		map.put("/adminUserUpdate", new AdminUserUpdateAction());
		
		
	}
	
	private Map<String, Action> map = new HashMap< >();	
	
	
	public Action getAction(String command)
	{
		Action action = null;
		
		action = map.get(command);
		
		return action;
	}
	
}
