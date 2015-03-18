package ru.taxiservice.taxi.domain;

import javax.persistence.*;

@Entity
@Table(name = "public.tariff_gps")
public class TariffGPS {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "tariff_gps_tariff_gps_id_seq")
	@SequenceGenerator(name = "tariff_gps_tariff_gps_id_seq", sequenceName = "tariff_gps_tariff_gps_id_seq")
	@Column(name = "tariff_gps_id", nullable = false)
	private int id;
	
	@Column(name = "rounding_to", nullable = false)
	private int roundingTo;
	
	// Стоимость посадки
	@Column(name = "boarding_current", nullable = false)
	private int boardingCurrent; 
	
	// Стоимость посадки предзаказа
	@Column(name = "boarding_pre_order", nullable = false)
	private int boardingPreOrder;
	
	// Минимальная стоимость поездки
	@Column(name = "cost_min", nullable = false)
	private int costMin;
	
	// Стоимость руб/км
	@Column(name = "cost_unit_distance", nullable = false)
	private double costUnitDistance; 
	
	@Column(name = "cost_minute", nullable = false)
	private double costMinute;
	
	@Column(name = "tariff_id", nullable = false)
	private int tariffId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoundingTo() {
		return roundingTo;
	}

	public void setRoundingTo(int roundingTo) {
		this.roundingTo = roundingTo;
	}

	public int getBoardingCurrent() {
		return boardingCurrent;
	}

	public void setBoardingCurrent(int boardingCurrent) {
		this.boardingCurrent = boardingCurrent;
	}

	public int getBoardingPreOrder() {
		return boardingPreOrder;
	}

	public void setBoardingPreOrder(int boardingPreOrder) {
		this.boardingPreOrder = boardingPreOrder;
	}

	public int getCostMin() {
		return costMin;
	}

	public void setCostMin(int costMin) {
		this.costMin = costMin;
	}

	public double getCostUnitDistance() {
		return costUnitDistance;
	}

	public void setCostUnitDistance(double costUnitDistance) {
		this.costUnitDistance = costUnitDistance;
	}

	public double getCostMinute() {
		return costMinute;
	}

	public void setCostMinute(double costMinute) {
		this.costMinute = costMinute;
	}

	public int getTariffId() {
		return tariffId;
	}

	public void setTariffId(int tariffId) {
		this.tariffId = tariffId;
	}
	
	
	
}
