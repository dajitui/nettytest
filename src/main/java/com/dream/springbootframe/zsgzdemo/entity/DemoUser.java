package com.dream.springbootframe.zsgzdemo.entity;

		import com.dream.springbootframe.utils.ColumnName;
		import com.dream.springbootframe.utils.TableName;
		import lombok.Data;

/**
 *
 * @author Dream
 * 2018年1月31日
 *
 *
 */
@Data
@TableName("user")
public class DemoUser {

	@ColumnName("id")
	private String id;
	@ColumnName("name")
	private String name;
	@ColumnName("pwd")
	private String pwd;

	public DemoUser(String id, String name, String pwd) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}

	public DemoUser() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
