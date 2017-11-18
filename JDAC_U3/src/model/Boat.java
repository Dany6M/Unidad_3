package model;

import java.io.Serializable;

public class Boat implements Serializable{
	private Long id;
	private String name;
	private String origin;
	private String route;
	
	public Boat(Long id, String name, String origin, String route){
		super();
		this.id = id;
		this.name = name;
		this.origin = origin;
		this.route = route;
	}
	
	public Boat() {
		this(0L, "", "", "");
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

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	@Override
	public String toString() {
		return "Boat [id=" + id + ", name=" + name + ", origin=" + origin + ", route=" + route + "]";
	}
	

}
