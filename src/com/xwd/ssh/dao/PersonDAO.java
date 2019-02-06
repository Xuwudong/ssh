package com.xwd.ssh.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.xwd.ssh.entity.Person;

@Repository
public class PersonDAO {

	@Resource
	private SessionFactory sessionFactory;
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	/**
	 * ����id��ѯ
	 * @param id
	 * @return
	 */
	public Person getPersonById(String id) {
		return (Person) this.getSession().createQuery("from Person where id=?").setParameter(0, id).uniqueResult();
	}
	/**
	 * ���
	 * @param person
	 */
	public void addPerson(Person person) {
		this.getSession().save(person);
	}
	/**
	 * ����
	 * @param person
	 */
	public void updatePerson(Person person) {
		this.getSession().update(person);
	}
	/**
	 * ɾ��
	 * @param id
	 */
	public void deletePersonById(String id) {
		this.getSession().createQuery("delete Person where id=?").setParameter(0, id).executeUpdate();
	}
	/**
	 * ��ѯ����
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Person> getPersons() {
		return this.getSession().createCriteria(Person.class).list();
	}
}
