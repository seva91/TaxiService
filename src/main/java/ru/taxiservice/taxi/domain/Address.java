package ru.taxiservice.taxi.domain;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.postgresql.geometric.PGpoint;

@Entity
@Table(name = "address", schema = "public")
public class Address  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="address_address_id_seq")
    @SequenceGenerator(name="address_address_id_seq", sequenceName="address_address_id_seq")
	@Column(name = "address_id", nullable = false)
    private Long id;
	
	@Column(name = "street_id", nullable = false)
	private Long streetId;
	
	@NotNull
	@Size(min = 1, max = 10)
	@Column(name = "house_num", nullable = false, length = 10)
	private String houseNum;
	
	@Column(name = "coordinates", nullable = false, columnDefinition = "point")
	@Type(type = "ru.taxiservice.taxi.domain.PointUserType")
	private PGpoint coordinates;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "street_id", referencedColumnName = "street_id", nullable = false, insertable = false, updatable = false)
	private Street street;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "address", targetEntity = ru.taxiservice.taxi.domain.Place.class) 
	private List<Place> places;
	
	public Address() {
		coordinates = new PGpoint();
		places = new ArrayList<Place>(Arrays.asList(new Place()));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStreetId() {
		return streetId;
	}

	public void setStreetId(Long streetId) {
		this.streetId = streetId;
	}
	
	public String getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}

	public Street getStreet() {
		return street;
	}

	public void setStreet(Street street) {
		this.street = street;
	}
	
	public PGpoint getCoordinates() {
		return coordinates; 
	}

	public void setCoordinates(PGpoint coordinates) {
		this.coordinates = coordinates; 
	}
	
	public Double getCoordinatesX() { return coordinates.x; }
	public void setCoordinatesX(Double x) { coordinates.x = x; }
	public Double getCoordinatesY() { return coordinates.y; }
	public void setCoordinatesY(Double y) { coordinates.y = y;  }

	public List<Place> getPlaces() {
		return places;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
	}
	
	
	
}
