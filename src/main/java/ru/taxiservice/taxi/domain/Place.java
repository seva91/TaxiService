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
@Table(name = "object", schema = "public")
public class Place {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="object_object_id_seq")
    @SequenceGenerator(name="object_object_id_seq", sequenceName="object_object_id_seq")
	@Column(name = "object_id", nullable = false)
    private Long id;
	
	@Column(name = "address_id", nullable = false)
	private Long addressId;
	
	@NotNull
	@Size(min = 1, max = 512)
	@Column(name = "name", nullable = false, length = 512)
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "address_id", referencedColumnName = "address_id", nullable = false, insertable = false, updatable = false)
	private Address address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
