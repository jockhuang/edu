/**
 * ChineseAll Inc.
 * Copyright (c) 2013 All Rights Reserved.
 * @author Jock
 */
package cn.chineseall.book.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.book.service.BookService;
import cn.chineseall.model.book.Book;
import cn.chineseall.model.book.BookComment;
import cn.chineseall.model.book.BookIntro;
import cn.chineseall.model.book.BookRecommend;
import cn.chineseall.model.book.BookScore;
import cn.chineseall.model.book.vo.BookDetail;
import cn.chineseall.model.book.vo.BookSelfSortDetail;
import cn.chineseall.model.user.UserCollection;
import cn.chineseall.model.user.vo.UserInfo;
import cn.chineseall.model.user.vo.UserReadingDetail;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.JsonUtil;

/**
 * 
 * @author Jock
 */
@Service("bookService")
public class BookServiceImpl implements BookService {

	@Override
	public Set<Long> getBookIds(Collection<? extends Object> entitys) {
		HashSet<Long> set = new HashSet<Long>();
		if (entitys != null) {
			for (Object entity : entitys) {
				if (entity instanceof Book) {
					set.add(((Book) entity).getId());
				} else if (entity instanceof BookDetail) {
					set.add(((BookDetail) entity).getBook().getId());
				} else if (entity instanceof BookComment) {
					set.add(((BookComment) entity).getBookId());
				} else if (entity instanceof UserCollection) {
					set.add(((UserCollection) entity).getBookId());
				} else if (entity instanceof BookRecommend) {
					set.add(((BookRecommend) entity).getBookId());
				} else if (entity instanceof UserReadingDetail) {
					set.add(((UserReadingDetail) entity).getBook().getId());
				}
			}
		}
		return set;
	}

	@Override
	public Map<String, Book> mapBook(Collection<Long> listBookId)
			throws Exception {

		HashMap<String, Book> mapBook = new HashMap<String, Book>();

		if (listBookId == null || listBookId.size() == 0) {
			return mapBook;
		}
		HashMap<Object, Object> params = new HashMap<Object, Object>();
		params.put("bookIds", listBookId);
		String json = ClientUtil.getStringClient(ClientURL.GET_BOOKS, params);

		List<Book> listBook = JsonUtil.jsonToList(json, "list", Book.class);
		if (listBook == null || listBook.size() == 0) {
			return mapBook;
		}

		for (Book book : listBook) {
			mapBook.put(book.getId().toString(), book);
		}

		return mapBook;
	}
	
	@Override
	public Map<String, Long> mapHaveCollectionBookId(Long userId,
			Collection<Long> listBookId) throws Exception {
		HashMap<String, Long> mapBookId = new HashMap<String, Long>();
		if (userId == null || listBookId == null || listBookId.size() == 0) {
			return mapBookId;
		}

		HashMap<Object, Object> params = new HashMap<Object, Object>();
		params.put("userId", userId);
		params.put("bookIds", listBookId);
		String json = ClientUtil.getStringClient(
				ClientURL.LIST_HAVE_COLLECTION_BOOK_ID, params);

		listBookId = JsonUtil.jsonToList(json, "list", Long.class);
		if (listBookId == null || listBookId.size() == 0) {
			return mapBookId;
		}
		for (Long bookId : listBookId) {
			mapBookId.put(bookId.toString(), bookId);
		}
		return mapBookId;
	}

	@Override
	public Map<String, String> getIntros(Collection<Long> bookIds)
			throws Exception {

		Map<String, String> intros = new HashMap<String, String>();
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("bookIds", bookIds);

		String returnStr = ClientUtil.getStringClient(
				ClientURL.GET_BOOK_INTROS, params);

		List<BookIntro> bookIntros = JsonUtil.jsonToList(returnStr, "list",
				BookIntro.class);
		for (BookIntro bookIntro : bookIntros) {
			intros.put(bookIntro.getBookId().toString(), bookIntro.getIntro());
		}

		return intros;
	}

	@Override
	public Map<String, String> getUserToBookScore(Long userId,
			Collection<Long> bookIds) throws Exception {
		Map<String, String> intros = new HashMap<String, String>();
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("userId", userId);
		params.put("bookIds", bookIds);
		String returnStr = ClientUtil.getStringClient(
				ClientURL.LIST_USER_TO_BOOK_SCORE, params);
		List<BookScore> bookScores = JsonUtil.jsonToList(returnStr, "list",
				BookScore.class);
		for (BookScore bookScore : bookScores) {
			intros.put(bookScore.getBookId().toString(), bookScore.getScore()
					.toString());
		}

		return intros;
	}

	@Override
	public List<BookSelfSortDetail> listOrgSelfSortDetail(Long orgTreeId)
			throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orgTreeId", orgTreeId);
		String returnStr = ClientUtil.getStringClient(
				ClientURL.LIST_ORG_BOOK_SELF_SORT, params);
		return JsonUtil.jsonToList(returnStr, "list", BookSelfSortDetail.class);
	}

	@Override
	public List<Book> listRecommendUserBook(Long orgTreeId, Integer pageSize)
			throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orgTreeId", orgTreeId);
		params.put("pageSize", pageSize);
		String returnStr = ClientUtil.getStringClient(
				ClientURL.LIST_RECOMMEND_USER_BOOK, params);
		return JsonUtil.jsonToList(returnStr, "list", Book.class);
	}

	@Override
	public List<Book> listOtherUserReadingBook(Long orgTreeId, Long bookId,
			Integer pageSize) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orgTreeId", orgTreeId);
		params.put("pageSize", pageSize);
		params.put("bookId", bookId);
		String returnStr = ClientUtil.getStringClient(
				ClientURL.LIST_OTHER_USER_READING_BOOK, params);
		return JsonUtil.jsonToList(returnStr, "list", Book.class);
	}

	@Override
	public List<UserInfo> listReadBookUser(Long orgTreeId, Long bookId,
			Integer pageSize) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orgTreeId", orgTreeId);
		params.put("currentPage", 1);
		params.put("pageSize", pageSize);
		params.put("bookId", bookId);
		String returnStr = ClientUtil.getStringClient(
				ClientURL.LIST_READ_BOOK_USER, params);
		return JsonUtil.jsonToList(returnStr, "list", UserInfo.class);
	}

	@Override
	public List<UserReadingDetail> listUserReadingDetail(Long userId,
			Long orgTreeId, Integer currentPage, Integer pageSize)
			throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("currentPage", currentPage);
		params.put("pageSize", pageSize);
		params.put("orgTreeId", orgTreeId);
		String returnStr = ClientUtil.getStringClient(
				ClientURL.LIST_USER_READING_DETAIL, params);
		return JsonUtil.jsonToList(returnStr, "list", UserReadingDetail.class);
	}

	@Override
	public List<Book> listOrgReadingTopBook(Long orgTreeId,
			Integer currentPage, Integer pageSize) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("currentPage", currentPage);
		params.put("pageSize", pageSize);
		params.put("orgTreeId", orgTreeId);
		String returnStr = ClientUtil.getStringClient(
				ClientURL.LIST_ORG_READING_TOP_BOOK, params);
		return JsonUtil.jsonToList(returnStr, "list", Book.class);
	}

	@Override
	public List<Book> listOrgCollectionTopBook(Long orgTreeId,
			Integer currentPage, Integer pageSize) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("currentPage", currentPage);
		params.put("pageSize", pageSize);
		params.put("orgTreeId", orgTreeId);
		String returnStr = ClientUtil.getStringClient(
				ClientURL.LIST_ORG_COLLECTION_TOP_BOOK, params);
		return JsonUtil.jsonToList(returnStr, "list", Book.class);
	}

	@Override
	public List<Book> listOrgDayReadTopBook(Long orgTreeId,
			Integer currentPage, Integer pageSize) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("currentPage", currentPage);
		params.put("pageSize", pageSize);
		params.put("orgTreeId", orgTreeId);
		String returnStr = ClientUtil.getStringClient(
				ClientURL.LIST_ORG_DAY_READ_TOP_BOOK, params);
		return JsonUtil.jsonToList(returnStr, "list", Book.class);
	}

	@Override
	public Map<String, String> getBuyInfo(Set<Long> bookIds, Long userId) throws Exception {
		Map<String, String> buyInfo = new HashMap<String, String>();
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("userId", userId);
		params.put("bookIds", bookIds);
		String returnStr = ClientUtil.getStringClient(
				ClientURL.GET_USER_BUY_BOOK_INFO, params);
		return JsonUtil.jsonToObject(returnStr, "list", Map.class);
	}

}
