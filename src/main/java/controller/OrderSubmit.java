package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Login;
import dao.OrderDB;
import model.Account;
import model.Cart;
import model.Order;

/**
 * Servlet implementation class OrderSubmit
 */
@WebServlet("/OrderSubmit")
public class OrderSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderSubmit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		// get parameter
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("adr");
		// get account from session
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("login");
		// Update account
		if (account == null) {
			out.print("No login");
			return;
		}
		account.setUsername(name);
		account.setPhone(phone);
		account.setAddress(address);
		
		session.setAttribute("login", account);
		// update database 
		int rs = new Login().updateAccount(account);
		if(rs == 0) {
			out.println("Can not update on database");
			return;
		}
		
		// create instance orders
		Cart cart = (Cart) session.getAttribute("Cart");
		if(cart == null) {
			out.println("No cart");
			return;
		}
		// update database order
		Order order = new Order(account.getMail(), phone, address);
		rs = new OrderDB().createOrderDetail(order, cart);
		if(rs == 0) {
			out.println("Can not update on database");
			return;
		}
		
		// delete session cart
		cart.getListItems().clear();
		session.setAttribute("Cart", cart);
		request.setAttribute("orderSuccess", "ok");
		request.getRequestDispatcher("/OrderSuccess.jsp").forward(request, response);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
