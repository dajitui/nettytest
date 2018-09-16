package com.dream.springbootframe.jpa.entity;

import com.dream.springbootframe.utils.ColumnName;
import com.dream.springbootframe.utils.TableName;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 *
 * @author Dream
 * 2018年1月31日
 *
 *
 */
@Data
@Entity
@TableName("student")
public class Student {

	@Id
	@ColumnName("id")
	private String id;
	@ColumnName("name")
	private String name;
	@ColumnName("age")
	private String age;
	@ColumnName("address")
	private String address;

	public Student(String id, String name, String age, String address) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public Student() {
	}
}
