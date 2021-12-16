package bean;

import java.util.List;
import dao.ListProduct;
import model.Product;

public class ShowListProduct {
	private int numberPage;
	private int numberProduct1Page;
	private String key;
	private ListProduct listProduct;
	private int page;

	public ShowListProduct() {
		listProduct = new ListProduct();
		numberProduct1Page = 6;
		key = "";
		int allNumberProduct = listProduct.getNumberProduct(key);
		if (allNumberProduct % numberProduct1Page == 0) {
			numberPage = allNumberProduct / numberProduct1Page;
		} else {
			numberPage = allNumberProduct / numberProduct1Page + 1;
		}
		page = 1;

	}

	public int getNumberPage() {
		return numberPage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page > numberPage) {
			this.page = 1;
		} else {
			this.page = page;
		}
	}

	public List<Product> getListProducts() {
		int start = (page - 1) * numberProduct1Page + 1;
		int end = page * numberProduct1Page;

		return listProduct.getListProduct(key, start, end);
	}
}
