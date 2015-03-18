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

import org.hibernate.annotations.Type;
import org.postgresql.geometric.PGpoint;

@Entity
@Table(name="city", schema="public")
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="city_cityid_seq")
    @SequenceGenerator(name="city_cityid_seq", sequenceName="city_cityid_seq")
	@Column(name = "city_id", nullable = false)
    private Integer id;
	
	@NotNull
	@Size(min = 1, max = 256)
	@Column(name = "name", nullable = false, length = 256)
	private String name;
	
	@Column(name = "coordinates", nullable = true, columnDefinition = "point")
	@Type(type = "ru.taxiservice.taxi.domain.PointUserType")
	private PGpoint coordinates;
	
	public Integer getId() { return id; }
	public void setId(Integer newValue) { id = newValue; }
	
	public String getName() { return name; }
	public void setName(String newValue) { name = newValue; }
	
	public PGpoint getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(PGpoint coordinates) {
		this.coordinates = coordinates;
	}
	
	public Double getCoordinatesX() {
		return coordinates == null ? null : coordinates.x;
	}
	
	public Double getCoordinatesY() {
		return coordinates == null ? null : coordinates.y;
	}
}
