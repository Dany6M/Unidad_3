package model;

import java.io.Serializable;

public class Creator implements Serializable{
	private Long id;
	private String name;
	private String lastName;
	private String filiation;
	private String area;
	
	public Creator(Long id, String name, String lastName, String filiation, String area) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.filiation = filiation;
		this.area = area;
	}
	
	public Creator() {
		this(0L,"","","","");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFiliation() {
		return filiation;
	}

	public void setFiliation(String filiation) {
		this.filiation = filiation;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Creator [id=" + id + ", name=" + name + ", lastName=" + lastName + ", filiation=" + filiation
				+ ", area=" + area + "]";
	}
	

}
