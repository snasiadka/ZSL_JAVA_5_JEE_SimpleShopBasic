package pl.gda.zsl;

import java.util.List;

import javax.ejb.Local;
import javax.naming.NamingException;

@Local
public interface CartBeanLocal {
	public void addBook(int bookId) throws Exception;
	public void removeBook(int bookId) throws Exception;
	public List<Integer> getBooks();
	public void removeBean();
	public List<Book> getWarehouseState() throws Exception;
}
