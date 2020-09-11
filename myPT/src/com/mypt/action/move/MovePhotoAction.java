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
		HttpSession session = request.getSession();
		session.setAttribute("board", "pboard");
		String nick=session.getAttribute("nick").toString();
		PboardDao pdao=PboardDao.getInstance();
		ArrayList<PboardDto> parr=pdao.getList();
		ArrayList<Integer> coments=new ArrayList<Integer>();
		ArrayList<String> likes=new ArrayList<String>();
		
		for(int i=0;i<parr.size();i++) {
			int pb_num=parr.get(i).getNum();
			coments.add(pdao.commentNum(pb_num));
			likes.add(pdao.photoLikeCheck(pb_num, nick));
		}
		request.setAttribute("photoList", parr);
		request.setAttribute("comment", coments);
		request.setAttribute("likes", likes);
		return "common/photoBoard";
	}

}
