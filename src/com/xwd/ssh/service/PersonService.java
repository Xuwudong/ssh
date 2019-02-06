package com.xwd.ssh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xwd.ssh.dao.PersonDAO;
import com.xwd.ssh.entity.Person;

@Transactional
@Service
public class PersonService {
	@Autowired
	private PersonDAO personDAO;

	public void addPerson(Person person) {
		personDAO.addPerson(person);
	}

	public void updatePerson(Person person) {
		personDAO.updatePerson(person);
	}

	public Person getPersonById(String id) {
		return personDAO.getPersonById(id);
	}

	public void deletePersonById(String id) {
		personDAO.deletePersonById(id);
	}

	public List<Person> getPersons() {
		return personDAO.getPersons();
	}
}
