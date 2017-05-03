package ssh2.test.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ssh2.test.vo.Book;

public class BookDao extends HibernateDaoSupport {
	public void save(Book book) {
		System.out.println("DAO层保存图书");
		this.getHibernateTemplate().save(book);
	}

	public void update(Book book) {
		this.getHibernateTemplate().update(book);
	}

	public void delete(Book book) {
		this.getHibernateTemplate().delete(book);
	}

	public Book findById(Integer id) {
		return this.getHibernateTemplate().get(Book.class, id);
	}

	public List<Book> findAll() {
		return this.getHibernateTemplate().find("from Book");
	}

	public List<Book> findByCriteria(DetachedCriteria criteria) {
		return this.getHibernateTemplate().findByCriteria(criteria);
	}

	public List<Book> findByName(String name) {
		return this.getHibernateTemplate().findByNamedQuery("findByName", name);
	}

	public Book findByIdLazy(Integer id) {
		return this.getHibernateTemplate().load(Book.class, id);
	}

}
