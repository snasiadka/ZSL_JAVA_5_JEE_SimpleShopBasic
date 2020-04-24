package pl.gda.zsl;

import java.util.List;

import javax.ejb.Local;

@Local
public interface WarehouseLocal {
	public List<Book> getWarehouseBooks();
	public void reserveBook (int bookId);
	public void unreserveBook (int bookId);
}
