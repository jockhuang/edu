package cn.chineseall.model.userhomepage;

import java.util.ArrayList;
import java.util.List;

import cn.chineseall.model.user.UserCollectGroup;

public class CollectionGroup {
	
	public CollectionGroup(){}
	
	public CollectionGroup(UserCollectGroup group) {
		
		groupId = group.getId();
		name = group.getName();
		count = group.getBookCount();
		books = new ArrayList<Book>();
		List<cn.chineseall.model.book.Book> listBook = group.getBooks();
		if (books != null) {
			for (cn.chineseall.model.book.Book b : listBook) {
				books.add(new Book(b));
			}
		}
	}

	private Long groupId;

	private String name;

	private List<Book> books;
	
	private Long count;

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}
	
}
