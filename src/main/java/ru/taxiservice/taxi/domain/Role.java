package ru.taxiservice.taxi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="role", schema="public")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="role_role_id_seq")
    @SequenceGenerator(name="role_role_id_seq", sequenceName="role_role_id_seq")
	@Column(name = "role_id", nullable = false)
    private Integer id;
	
	@NotNull
	@Size(min = 1, max = 256)
	@Column(name = "name", nullable = false, length = 256)
	private String name;
	
	@Column(name = "description", nullable = true, length = 1024)
	private String description;
	
	@Column(name = "taxi_service_id", nullable = false)
	private int taxiServiceId;
	
	public Role() { }
	
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
	public String getName() { return name; }
	public void setName(String newValue) { name = newValue; }
	
	public String getDescription() { return description; }
	public void setDescription(String newValue) { description = newValue; }
	
	public Integer getTaxiServiceId() { return taxiServiceId; }
	public void setTaxiServiceId(Integer newValue) { taxiServiceId = newValue; }
	
}
