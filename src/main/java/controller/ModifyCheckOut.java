package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;

/**
 * Servlet implementation class ModifyCheckOut
 */
@WebServlet("/ModifyCheckOut")
public class ModifyCheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyCheckOut() {
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
		
		// Get product from database
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		// Get cart from session
		Cart cart;
		HttpSession session = request.getSession();
		if (session.getAttribute("Cart") == null) {
			cart = new Cart();
		} else {
			cart = (Cart) session.getAttribute("Cart");
		}
		
		
		// Remove product from cart
		if (action.equals("remove")) {
			cart.remove(Integer.valueOf(id));
		}
		// Increase number item in cart
		if(action.equals("ins")) {
			cart.increaseItem(Integer.valueOf(id));
		}
		
		// Decrease number item in cart
		if(action.equals("des")) {
			cart.decreaseItem(Integer.valueOf(id));
		}
		
		session.setAttribute("Cart", cart);
		request.getRequestDispatcher("/CheckOut.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
