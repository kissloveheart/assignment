package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MVC
 */
@WebServlet("/MVC")
public class MVC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MVC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		try {
		String action = request.getParameter("action");
		String page = null;
		switch(action){
		case "home":
			page = "/Home.jsp";
			break;
		case "login":
			page = "/Login.jsp";
			break;
		case "dash":
			page = "/admin/Dashboard.jsp";
			break;	
		case "logout":
			page = "/Logout";
			break;
		case "register":
			page = "/Register.jsp";
			break;
		case "checkout":
			page = "/CheckOut.jsp";
		
		}
		getServletContext().getRequestDispatcher(page).forward(request, response);
		
	} catch(Exception e) {
		out.print(e);
	   // response.sendRedirect("Home.jsp");
	}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
