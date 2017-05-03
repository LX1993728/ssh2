package ssh2.test.junitDemo;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ssh2.test.service.BookService;
import ssh2.test.vo.Book;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SSHTest {
	@Autowired
	@Qualifier("bookService")
	private BookService bookService;

	@Test
	public void demo1() {
		Book book = new Book();
		book.setId(1);
		book.setName("Java从入门到精通");
		book.setPrice(98d);
		bookService.update(book);
	}

	@Test
	public void demo2() {
		Book book = new Book();
		book.setId(1);
		bookService.delete(book);
	}

	@Test
	public void demo3() {
		Book book = bookService.findById(2);
		System.out.println(book);
	}

	@Test
	public void demo4() {
		List<Book> books = bookService.findAll();
		for (Book book : books) {
			System.out.println(book);
		}
	}

	@Test
	public void demo5() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Book.class);
		criteria.add(Restrictions.eq("name", "Struts2开发入门"));
		List<Book> books = bookService.findByCriteria(criteria);
		for (Book book : books) {
			System.out.println(book);
		}
	}

	@Test
	public void demo6() {
		List<Book> books = bookService.findByName("SSH整合2");
		for (Book book : books) {
			System.out.println(book);
		}
	}

}
