package com.dream.springbootframe.jpa.service.impl;

import com.dream.springbootframe.jpa.dao.StudentDao;
import com.dream.springbootframe.jpa.entity.Student;
import com.dream.springbootframe.jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 
 * @author Dream
 *
 *
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Override
	public Student save(Student s) {
		return studentDao.save(s);
	}

	@Override
	public List<Student> findAll() {
		return studentDao.findAll();
	}

	@Override
	public List<Student> findAll(Sort sort) {
		return studentDao.findAll(sort);
	}

	@Override
	public List<Student> findAllById(Iterable<String> id) {
		return studentDao.findAllById(id);
	}

	@Override
	public List<Student> saveAll(Iterable<Student> students) {
		return studentDao.saveAll(students);
	}

	@Override
	public void flush() {
		studentDao.flush();
	}

	@Override
	public Student saveAndFlush(Student student) {
		return studentDao.saveAndFlush(student);
	}

	@Override
	public void deleteInBatch(Iterable<Student> students) {
		studentDao.deleteInBatch(students);
	}

	@Override
	public void deleteAllInBatch() {
		studentDao.deleteAllInBatch();
	}

	@Override
	public Student getOne(String id) {
		return studentDao.getOne(id);
	}

	@Override
	public List<Student> findAll(Example<Student> students) {
		return studentDao.findAll(students);
	}

	@Override
	public List<Student> findAll(Example<Student> students, Sort sort) {
		return studentDao.findAll(students, sort);
	}
}
