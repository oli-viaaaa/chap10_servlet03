package com.javalab.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
// @WebServlet("/login") 이런 요청이 들어오면 내가 받겠다.
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 인코딩
		request.setCharacterEncoding("utf-8");
		
		// 웹브라우저에 응답 인코딩
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("user_id");
		String pwd = request.getParameter("user_pw");
		
			if(id.equals("admin") && pwd.equals("1234")) {
				String welcomeMessage = "환영합니다, " + id + "!";
				request.setAttribute("welcomeMessage", welcomeMessage);
				
				// RequestDispatcher : 페이지 이동
				// - 프로그램의 흐름을 다른 jsp 화면으로 이동
				// - forward() 메소드로 기존 request값 사용 가능
				RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
				dispatcher.forward(request, response);
				
			} else {
				// 로그인 페이지로 다시 돌아감
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
			}
	}
	
	public void destory() {
		System.out.println("destory 메서드 호출");
	}

}
