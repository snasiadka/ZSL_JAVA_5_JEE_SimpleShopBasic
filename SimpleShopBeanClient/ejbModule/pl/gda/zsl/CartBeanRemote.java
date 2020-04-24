package pl.gda.zsl;

import java.util.List;

import javax.ejb.Remote;
import javax.naming.NamingException;

@Remote
public interface CartBeanRemote {
	public void addBook(int bookId) throws Exception;
	public void removeBook(int bookId) throws Exception;
	public List<Integer> getBooks();
	public void removeBean();
	public List<Book> getWarehouseState() throws Exception;
}
