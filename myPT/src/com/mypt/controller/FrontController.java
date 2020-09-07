package com.mypt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "*.do", loadOnStartup = 1)
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 실행");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1단계: 요청 명령어 command 가져오기
		String command = getCommand(request);	
		
		//2단계: 명령어에 대해 처리하기
		
//		프론트컨트롤러에서 객체를 생성하면 호출될때마다 객체가 만들어짐. 낭비.
//		이럴 때 싱글톤패턴을 활용
		ActionFactory actionFactory = ActionFactory.getInstance();
		
		
		Action action = null;
		String strView = null;
		
		
		//명령어에 해당하는 Action 타입 객체 구하기
		action = actionFactory.getAction(command);
		
		if(action==null)
		{
			System.out.println(command+"를 처리하는 Action이 없습니다.");
			return;
		}
		
//		Action 객체가 있으면 execute() 호출.
		try 
		{
			strView= action.execute(request, response);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}			
			
//		3. 화면응답 또는 리다이렉트 이동
		if (strView == null) 
		{
			return;
		}
		
//		특정 문자열로 시작하면 true
		if (strView.startsWith("redirect:")) 
		{
			//리다이렉트 명령어(aa.do) 형식으로 재요청
			//String 리터럴도 객체			
			String redirectPath = strView.substring("redirect:".length());
			response.sendRedirect(redirectPath);
		}else if(strView=="callback") {
		      PrintWriter out = response.getWriter();      
		      out.println(request.getAttribute("result"));
		      System.out.println(request.getAttribute("result"));
		      
		} else {
			//디스패치 방식으로 jsp 바로 실행
			String prefix = "/WEB-INF/views/";
			String suffix = ".jsp";
			String jspPath = prefix + strView + suffix;
			RequestDispatcher dispatcher = request.getRequestDispatcher(jspPath);
			dispatcher.forward(request, response);
		}
		
	} // doGet()

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post 방식 요청 파라미터 한글처리 . post 방식은 텍스트 뿐 아니라 파일 등도 전송.
		//request.setCharacterEncoding("utf-8");
		//response.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	
	
	private String getCommand(HttpServletRequest request) {
//		URI(포트 번호 다음의 주소) 가져오기  /model2/aa.do
//		cf.전체 주소는 URL
		String requestURI = request.getRequestURI();
		System.out.println("URI 주소: " + requestURI); // /model2/aaa.do
		
		String contextPath = request.getContextPath();
		System.out.println("contextPath: " + contextPath); // /model2
		
//		subString() 활용, 요청명령어만 추출함
		int beginIndex = contextPath.length();
		String command = requestURI.substring(beginIndex);
		System.out.println("command: " + command); // /aaa.do
		
////////////		여기까지 해도 됨 
//		아래는 .do빼는 작업

		int endIndex = command.indexOf(".do");
		command = command.substring(0, endIndex);
		System.out.println("command: " + command); // /aaa
		
		return command;
	}

}



