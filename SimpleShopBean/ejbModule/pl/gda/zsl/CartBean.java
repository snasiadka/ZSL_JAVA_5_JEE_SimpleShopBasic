package pl.gda.zsl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Session Bean implementation class CartBean
 */
@Stateful
public class CartBean implements CartBeanRemote, CartBeanLocal {
	
	List<Integer> books = null;
	
    /**
     * Default constructor. 
     */
    public CartBean() {
        // TODO Auto-generated constructor stub
    	books = new ArrayList<Integer>();
    }

	@Override
	public void addBook(int bookId) throws Exception {
		WarehouseLocal warehouse = (WarehouseLocal) (new InitialContext()).lookup("java:module/Warehouse!pl.gda.zsl.Warehouse");
		if (warehouse.getWarehouseBooks().get(bookId).getAmount() > 0) {
			books.add(bookId);
			warehouse.reserveBook(bookId);
		} else {
			throw new Exception ("No available books in warehouse");
		}
	}

	@Override
	public void removeBook(int bookId) throws Exception {
		WarehouseLocal warehouse = (WarehouseLocal) (new InitialContext()).lookup("java:module/Warehouse!pl.gda.zsl.Warehouse");

		books.remove(bookId);
		warehouse.unreserveBook(bookId);
	}

	@Override
	public List<Book> getWarehouseState() throws Exception {
		WarehouseLocal warehouse = (WarehouseLocal) (new InitialContext()).lookup("java:module/Warehouse!pl.gda.zsl.Warehouse");

		return warehouse.getWarehouseBooks();
	}
	
	@Override
	public List<Integer> getBooks() {
		return books;
	}

	@Remove
	public void removeBean() {
		books.clear();
		books = null;
	}

}
