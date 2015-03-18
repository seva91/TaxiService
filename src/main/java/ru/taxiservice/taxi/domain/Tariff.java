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
@Table(name="public.tariff")
public class Tariff {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "tariff_tariff_id_seq")
	@SequenceGenerator(name = "tariff_tariff_id_seq", sequenceName = "tariff_tariff_id_seq")
	@Column(name = "tariff_id", nullable = false)
	private int id;
	
	@NotNull
	@Size(min = 1, max = 250)
	@Column(name = "name", nullable = false, length = 250)
	private String name;
	
	@Column(name = "service_id", nullable = false)
	private long serviceId;
	
	@Column(name = "archive", nullable = false)
	private boolean archive;
	
	@Column(name = "type", nullable = false)
	private short type;
	
	@Column(name = "tariff_gps_id", nullable = true)
	private Integer tariffGpsId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getServiceId() {
		return serviceId;
	}

	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}

	public boolean isArchive() {
		return archive;
	}

	public void setArchive(boolean archive) {
		this.archive = archive;
	}

	public short getType() {
		return type;
	}

	public void setType(short type) {
		this.type = type;
	}

	public Integer getTariffGpsId() {
		return tariffGpsId;
	}

	public void setTariffGpsId(Integer tariffGpsId) {
		this.tariffGpsId = tariffGpsId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
