package com.dream.springbootframe.jpa.service;

import com.dream.springbootframe.jpa.entity.Student;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * 
 * @author Dream
 * 2018年1月31日
 *
 *
 */
public interface StudentService {

	Student save(Student s);

	List<Student> findAll();

	List<Student> findAll(Sort sort);

	List<Student> findAllById(Iterable<String> id);

	List<Student> saveAll(Iterable<Student> students);

	void flush();

	Student saveAndFlush(Student student);

	void deleteInBatch(Iterable<Student> students);

	void deleteAllInBatch();

	Student getOne(String id);

	List<Student> findAll(Example<Student> students);

	List<Student> findAll(Example<Student> students, Sort sort);

}
