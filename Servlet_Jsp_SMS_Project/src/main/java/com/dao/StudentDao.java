package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.dto.Student;

public class StudentDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void saveStudent(Student student) {
		et.begin();
		em.persist(student);
		et.commit();
	}

	public List<Student> findAll() {

		Query q = em.createQuery("from Student s");
		List<Student> list = q.getResultList();

		return list;

	}

	public Student findStudentById(int id) {
		return em.find(Student.class, id);

	}

	public void updateStudent(Student s) {

		et.begin();
		em.merge(s);
		et.commit();
		
	}

	public void deleteStudentById(Student std) {
		et.begin();
		em.remove(std);
		et.commit();
		
	}

}
