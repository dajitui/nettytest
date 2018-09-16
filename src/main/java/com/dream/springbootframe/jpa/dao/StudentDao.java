package com.dream.springbootframe.jpa.dao;

import com.dream.springbootframe.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends JpaRepository<Student, String>{

	
}
