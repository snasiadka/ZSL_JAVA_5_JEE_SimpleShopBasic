package pl.gda.zsl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class Warehouse
 */
@Singleton
@LocalBean
public class Warehouse implements WarehouseRemote, WarehouseLocal {

	private List<Book> books;
	
    /**
     * Default constructor. 
     */
    public Warehouse() {
        // TODO Auto-generated constructor stub
    	books = new ArrayList<Book>();
    	Book b1 = new Book(0, "Ogniem i Mieczem", 2);    	
    	Book b2 = new Book(1, "Potop", 2);  
    	books.add(b1);
    	books.add(b2);
    }
 
	public int getAvailableBooks(int bookId) {
		return books.get(bookId).getAmount();
	}
	
	public List<Book> getWarehouseBooks() {
		return books;
	}
	
	public void reserveBook (int bookId) {
		books.get(bookId).setAmount(books.get(bookId).getAmount()-1);
	}
	
	public void unreserveBook (int bookId) {
		books.get(bookId).setAmount(books.get(bookId).getAmount()+1);
	}
    
}
