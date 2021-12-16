package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dao.ListProduct;
import model.Cart;
import model.Product;

/**
 * Servlet implementation class CartBehavior
 */
@WebServlet("/CartBehavior")
public class CartBehavior extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartBehavior() {
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
		
		// Get product from database
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		Product product = new ListProduct().getProduct(id);
		// Get cart from session
		Cart cart;
		HttpSession session = request.getSession();
		if (session.getAttribute("Cart") == null) {
			cart = new Cart();
		} else {
			cart = (Cart) session.getAttribute("Cart");
		}
		
		if(product == null) {
			out.println("Can not connect data");
			return;
		}
		
		
		// Add product to cart
		if (action.equals("add")) {
			cart.add(product);
			// convert list to json
			String json = new Gson().toJson(cart.getListItems());
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.write(json);
			
		}
		// Remove product from cart
		if (action.equals("remove")) {
			cart.remove(Integer.valueOf(id));
			if(cart.getListItems().size() == 0) {
				out.write("null");
				return;
			}
			
			// response list to json
			String json = new Gson().toJson(cart.getListItems());
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.write(json);
		}
		
		session.setAttribute("Cart", cart);
		

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
