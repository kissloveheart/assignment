package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListProduct;
import model.Product;

/**
 * Servlet implementation class SearchShow
 */
@WebServlet("/SearchShow")
public class SearchShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchShow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		try {
			String key = request.getParameter("search");
			request.setAttribute("key", key);
			//query result from database
			List<Product> listSearch = new ListProduct().getListProduct(key,1,Integer.MAX_VALUE);
			if(listSearch.size() == 0) {
				// list is null
				request.setAttribute("search", "Không có sản phẩm nào được tìm thấy");
				
				request.getRequestDispatcher("/SearchEmpty.jsp").forward(request, response);
			} else {
				//show the list follow the page navigation
				int numberProduct1Page = 6;
				int numberPage;
				int allNumberProduct = listSearch.size();
				int page = 1;
				//check number page				
				if (allNumberProduct % numberProduct1Page == 0) {
					numberPage = allNumberProduct / numberProduct1Page;
				} else {
					numberPage = allNumberProduct / numberProduct1Page + 1;
				}
				// define product in page
				if(request.getParameter("page") != null) {
					page = Integer.valueOf(request.getParameter("page"));
				}
				
				int start = (page - 1) * numberProduct1Page;
				int end = page * numberProduct1Page;
				if(end > allNumberProduct) {
					end = allNumberProduct;
				}
				//response the sublist of product
				request.setAttribute("search", listSearch.subList(start, end));
				request.setAttribute("numberProduct", allNumberProduct);
				request.setAttribute("numberPage",numberPage );
				request.getRequestDispatcher("/Search.jsp").forward(request, response);

			}
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
