package com.mypt.action.income;

import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mypt.controller.Action;
import com.mypt.dao.HistoryDao;
import com.mypt.dto.HistoryDto;

public class UserCountAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		System.out.println(year);
		HistoryDao dao = HistoryDao.getInstance();
		ArrayList<HistoryDto> arr = dao.getUser(year,month);
		for(HistoryDto dto: arr) {
			System.out.println(dto.getMonth());
			System.out.println(dto.getIncome());
		}
		
		JSONArray jarr = new JSONArray();
		for(HistoryDto dto: arr) {
			JSONObject obj = new JSONObject();			
			obj.put("user", dto.getUsercnt());
			jarr.add(obj);
		}
		request.setAttribute("result", jarr);
		
		
		return "callback";
		
		
	}

}