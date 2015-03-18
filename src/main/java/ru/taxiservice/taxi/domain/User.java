package ru.taxiservice.taxi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="user", schema="public")
public class User {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "user_id", nullable = false)
    private Long id;
	
	@NotNull
	@Size(min = 1, max = 512)
	@Column(name = "full_name", nullable = false, length = 512)
	private String fullName;
	
	public User() {
		
	}
	
	public User(String fullName) {
		this.fullName = fullName;
	}
	
	@Override
	public String toString() {
		return String.format("User[id = %d, fullName = %s]", id, fullName);
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String name) {
		fullName = name;
	}
	
	
}
