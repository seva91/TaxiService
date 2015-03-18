package ru.taxiservice.taxi.domain;

import java.util.List;

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

//import org.postgis.Polygon;

@Entity
@Table(name = "parking", schema = "public")
public class Parking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="paking_parking_id_seq")
    @SequenceGenerator(name="paking_parking_id_seq", sequenceName="paking_parking_id_seq")
	@Column(name = "parking_id", nullable = false)
    private Long id;
	
	@NotNull
	@Size(min = 1, max = 256)
	@Column(name = "name", nullable = false, length = 256)
	private String name;
	
	/*@Column(name = "coordinates", nullable = false)
	private Polygon coordinates;*/
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parking_id", referencedColumnName = "parking_adjacent_id")
	private List<Parking> adjacent;

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

	/*public Polygon getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Polygon coordinates) {
		this.coordinates = coordinates;
	}*/

	public List<Parking> getAdjacent() {
		return adjacent;
	}

	public void setAdjacent(List<Parking> adjacent) {
		this.adjacent = adjacent;
	}
}
