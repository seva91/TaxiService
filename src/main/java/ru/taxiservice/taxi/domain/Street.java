package ru.taxiservice.taxi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "street", schema = "public")
public class Street {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator ="street_streetid_seq")
	@SequenceGenerator(name = "street_streetid_seq", sequenceName = "street_streetid_seq")
	@Column(name = "street_id", nullable = false)
	private Long id;
	
	@Column(name = "city_id", nullable = false, insertable = false, updatable = false)
	private Integer cityId;
	//@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "city_id", nullable = false, referencedColumnName = "city_id")
	private City city;
	
	@NotNull
	@Size(min = 1, max = 512)
	@Column(name = "name", nullable = false, length = 512)
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
