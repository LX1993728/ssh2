package ssh2.test.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ssh2.test.dao.BookDao;
import ssh2.test.vo.Book;

@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
public class BookService {
	private BookDao bookDao;

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public void add(Book book) {
		System.out.println("Service层保存图书......");
		bookDao.save(book);
	}

	public void update(Book book) {
		bookDao.update(book);
	}

	public void delete(Book book) {
		bookDao.delete(book);
	}

	public Book findById(Integer id) {
		return bookDao.findById(id);
	}

	public List<Book> findAll() {
		return bookDao.findAll();
	}

	public List<Book> findByCriteria(DetachedCriteria criteria) {
		return bookDao.findByCriteria(criteria);
	}

	public List<Book> findByName(String name) {
		return bookDao.findByName(name);
	}

	public Book findByIdLazy(Integer id) {
		return bookDao.findByIdLazy(id);
	}
}
