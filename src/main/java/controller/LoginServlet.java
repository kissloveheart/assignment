package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Login;
import model.Account;

/**
 * Servlet implementation class Controller
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
	//	PrintWriter out = response.getWriter();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
	//	PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		
		try {
			// collect data from login form
			String userID = request.getParameter("uname");
			String passID = request.getParameter("psw");

			// Remember user to cookie
			String remember = request.getParameter("remember");
			if(remember == null) {

				Cookie[] cookies = request.getCookies();
				if (cookies != null) {
					for (Cookie cookie : cookies) {
						if (cookie.getName().equals("user")) {
							cookie.setValue("");
//							response.addCookie(cookie);
						}
						if (cookie.getName().equals("pass")) {
							cookie.setValue("");
//							response.addCookie(cookie);
						}

					}
				}
			}

			if (remember != null && remember.equals("on")) {
				Cookie cookieU = new Cookie("user", userID);
				Cookie cookieP = new Cookie("pass", passID);
				response.addCookie(cookieU);
				response.addCookie(cookieP);

			}


			
			// check account data from database 
			
			boolean validated = new Login().checkLogin(userID,passID);
					
			// check account is valid
			if (validated) {
				// success login, set session instance user
				Account user = new Login().getAccount(userID);
				session.setAttribute("login", user);
				// Go to login page
				request.setAttribute("loginSuccess", "ok");
				request.getRequestDispatcher("/LoginSucess.jsp").forward(request, response);

			} else {
				// Go to login page notify false
				request.setAttribute("loginSuccess", "nok");
			request.getRequestDispatcher("/Login.jsp").forward(request, response);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
