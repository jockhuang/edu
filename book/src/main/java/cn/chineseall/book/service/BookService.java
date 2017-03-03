/**
 * ChineseAll Inc.
 * Copyright (c) 2013 All Rights Reserved.
 * @author Jock
 */
package cn.chineseall.book.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.chineseall.model.book.Book;
import cn.chineseall.model.book.vo.BookSelfSortDetail;
import cn.chineseall.model.user.vo.UserInfo;
import cn.chineseall.model.user.vo.UserReadingDetail;

/**
 * 
 * @author Jock
 */
public interface BookService {

	/**
	 * 从实体集合中提取bookId集合
	 * 
	 * @param entitys
	 *            实体集合
	 * @return bookId集合
	 */
	public Set<Long> getBookIds(Collection<? extends Object> entitys);

	public Map<String, Book> mapBook(Collection<Long> listBookId) throws Exception;
	
	public Map<String , Long> mapHaveCollectionBookId(Long userId ,Collection<Long> listBookId)throws Exception;
	
	/**
	 * 获取图书简介
	 * 
	 * @param bookIds
	 *            图书id列表
	 * @return 图书简介<图书id , 简介文本>
	 * @throws Exception
	 */
	public Map<String, String> getIntros(Collection<Long> bookIds)
			throws Exception;

	/**
	 * 获取图书简介
	 * 
	 * @param bookIds
	 *            图书id列表
	 * @return 图书简介<图书id , 简介文本>
	 * @throws Exception
	 */
	public Map<String, String> getUserToBookScore(Long userId,
			Collection<Long> bookIds) throws Exception;

	public List<BookSelfSortDetail> listOrgSelfSortDetail(Long orgTreeId)
			throws Exception;

	public List<Book> listRecommendUserBook(Long orgTreeId, Integer pageSize)
			throws Exception;

	public List<Book> listOtherUserReadingBook(Long orgTreeId, Long bookId,
			Integer pageSize) throws Exception;

	public List<UserReadingDetail> listUserReadingDetail(Long userId,
			Long orgTreeId, Integer currentPage, Integer pageSize)
			throws Exception;

	public List<Book> listOrgReadingTopBook(Long orgTreeId,
			Integer currentPage, Integer pageSize) throws Exception;

	public List<Book> listOrgCollectionTopBook(Long orgTreeId,
			Integer currentPage, Integer pageSize) throws Exception;

	public List<Book> listOrgDayReadTopBook(Long orgTreeId,
			Integer currentPage, Integer pageSize) throws Exception;

	public List<UserInfo> listReadBookUser(Long orgTreeId, Long bookId,
			Integer pageSize) throws Exception;

	/**
	 * 查看用户是否购买图书
	 * @param bookIds
	 * @param userId
	 * @return
	 */
	public Map<String, String> getBuyInfo(Set<Long> bookIds, Long userId) throws Exception;

	/**
	 * 获取图书简介
	 * 
	 * @param bookId
	 * @return 图书简介
	 * @throws Exception
	 */
	// public String getIntro(Long bookId) throws Exception;

	// public Chapter getChapter(long chapterid);
	//
	// public List<Chapter> getChapters(long bookid);
	//
	// public Section getSection(long id);
	//
	// public List<Section> getSections(long bookid, long chapterid);
	//
	// public void addBook(Book book);

}
