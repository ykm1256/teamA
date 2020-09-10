package com.mypt.action.move;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypt.controller.Action;
import com.mypt.dao.PboardDao;
import com.mypt.dto.PboardDto;

public class MovePhotoAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		PboardDao pdao=PboardDao.getInstance();
		ArrayList<PboardDto> parr=pdao.getList();
		ArrayList<Integer> coments=new ArrayList<Integer>();
		for(int i=0;i<parr.size();i++) {
			int pb_num=parr.get(i).getNum();
			coments.add(pdao.commentNum(pb_num));
		}
		request.setAttribute("photoList", parr);
		request.setAttribute("comment", coments);
		return "common/photoBoard";
	}

}
