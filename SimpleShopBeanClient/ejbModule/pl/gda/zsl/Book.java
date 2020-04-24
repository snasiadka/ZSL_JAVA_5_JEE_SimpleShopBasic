package pl.gda.zsl;

import java.io.Serializable;

public class Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2521760037483421153L;
	private int bookId;
	private String name;
	private int amount;
	
	public Book (int bookId, String name, int amount) {
		this.bookId = bookId;
		this.name = name;
		this.amount = amount;
	}
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
