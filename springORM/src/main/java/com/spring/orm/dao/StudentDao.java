package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entity.Student;

public class StudentDao {
	
	
	HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	//insert student
	@Transactional
	public int insert(Student student) {
		Integer res = (Integer)this.hibernateTemplate.save(student);
		return res;
	}
	//fetching  student based on id
	public Student getStudent(int id) {
		return hibernateTemplate.get(Student.class, id);
	}
	//fetching all students
	public List<Student> getStudents() {
		return hibernateTemplate.loadAll(Student.class);
	}
	
	//delete student
	public void delete(int id) {
		Student student = this.hibernateTemplate.get(Student.class, id);
		hibernateTemplate.delete(student);
	}
	
	
	//updating student
	public void update(Student student) {
		hibernateTemplate.update(student);
	}
	
	
}
