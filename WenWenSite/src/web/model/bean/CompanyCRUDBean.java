package web.model.bean;

import java.util.Date;

public class CompanyCRUDBean {
	private int id;
	private String name;
	private int age;
	private String cellphone;
	private String email;
	private Date hiredate;
	private String database;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	@Override
	public String toString() {
		return "CompanyCRUDBean [id=" + id + ", name=" + name + ", age=" + age + ", cellphone=" + cellphone + ", email=" + email + ", hiredate=" + hiredate + ", database=" + database + "]";
	}

}
