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
@Table(name="distribution", schema="public")
public class Distribution {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="distribution_distribution_id_seq")
    @SequenceGenerator(name="distribution_distribution_id_seq", sequenceName="distribution_distribution_id_seq")
	@Column(name = "distribution_id", nullable = false)
    private Long id;
	
	@NotNull
	@Size(min = 1, max = 256)
	@Column(name = "name", nullable = false, length = 256)
	private String name;
	
	/* *����� �� ������������� (������) (������� ������� ����� ����� ��������� �� ������������� ���� �� ����� ����, ����� ������� ������� ���������� ��������� �������, � ���������� ����� ����� ���� renewalOrder > 0) */
	@Column(name = "time_distribution", nullable = false)
	private int timeDistribution;
	
	/* *��������� ������ (���) (������� ��� ����� ����� �������, �� ��������� timeDistribution ) */
	@Column(name = "renewal_order", nullable = false)
	private int renewalOrder;
	
	/* *����� �� ����� ������ (������) */
	@Size(min = 10)
	@Column(name = "time_select_order", nullable = false)
	private int timeSelectOrder;
	
	/* ����� �������� ������� (������) (������ �� ��������� �������� ����������� � ��������) */
	@Column(name = "client_timeout", nullable = false)
	private int clientTimeout;
	
	/* ���������� ���� ����� (���) (������������ ���������� ������� ������ ������ ������ ��������) */
	@Column(name = "offer_one_order", nullable = false)
	private int offerOneOrder;
	
	/* ���������� �������� ������� */
	@Column(name = "show_active_order", nullable = false)
	private int showActiveOrder;
	
	/* ������� ������������� (������ �������, ������� �������, ����� 2 �������) */
	@Column(name = "border_distribution", nullable = false)
	//@Type(type = "ru.taxiservice.taxi.domain.BorderDistribution")
	private int borderDistribution;
	
	/* ������������ ������ */
	@Column(name = "maximum_radius", nullable = false)
	private int maximumRadius;
	
	/* ������ ������������� */
	@Column(name = "method_distribution", nullable = false)
	private int methodDistribution;
	
	/* ������������ �������� */
	@Column(name = "priority_driver", nullable = false)
	private int priorityDriver;
	
	/* ��������������� */
	
	/* ����������� ����� �� �������� ���������� ������ �� ���������� ������ */
	@Column(name = "advance_orders_silent_time", nullable = false)
	private int advanceOrdersSilentTime;
	
	/* �������� ���������� �� ��������� ���������� ������ �� ����������� ������� � ���������� */
	@Column(name = "advance_orders_distrib_time", nullable = false)
	private int advanceOrdersDistribTime;
	
	/* ����� ��������� �� ����� */
	@Column(name = "max_reserve_drivers", nullable = false)
	private int maxReserveDrivers;
	
	/* ������� � �������� ��  */
	@Column(name = "advance_orders_time_limit", nullable = false)
	private int advanceOrdersTimeLimit;
	
	@Column(name = "taxi_service_id", nullable = false)
	private int taxiServiceId;
	
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

	public int getTimeDistribution() {
		return timeDistribution;
	}

	public void setTimeDistribution(int timeDistribution) {
		this.timeDistribution = timeDistribution;
	}

	public int getRenewalOrder() {
		return renewalOrder;
	}

	public void setRenewalOrder(int renewalOrder) {
		this.renewalOrder = renewalOrder;
	}

	public int getTimeSelectOrder() {
		return timeSelectOrder;
	}

	public void setTimeSelectOrder(int timeSelectOrder) {
		this.timeSelectOrder = timeSelectOrder;
	}

	public int getClientTimeout() {
		return clientTimeout;
	}

	public void setClientTimeout(int clientTimeout) {
		this.clientTimeout = clientTimeout;
	}

	public int getOfferOneOrder() {
		return offerOneOrder;
	}

	public void setOfferOneOrder(int offerOneOrder) {
		this.offerOneOrder = offerOneOrder;
	}

	public int getShowActiveOrder() {
		return showActiveOrder;
	}

	public void setShowActiveOrder(int showActiveOrder) {
		this.showActiveOrder = showActiveOrder;
	}

	/*public BorderDistribution getBorderDistribution() {
		return borderDistribution;
	}*/
	
	public Integer getBorderDistribution() {
		return BorderDistribution.valueOf(borderDistribution).getValue();
	}

	public void setBorderDistribution(int borderDistribution) {
		this.borderDistribution = BorderDistribution.valueOf(borderDistribution).getValue(); 
	}

	public int getMaximumRadius() {
		return maximumRadius;
	}

	public void setMaximumRadius(int maximumRadius) {
		this.maximumRadius = maximumRadius;
	}

	public Integer getMethodDistribution() {
		return MethodDistribution.valueOf(methodDistribution).getValue();
	}

	public void setMethodDistribution(int methodDistribution) {
		this.methodDistribution = MethodDistribution.valueOf(methodDistribution).getValue();
	}

	public Integer getPriorityDriver() {
		return PriorityDriver.valueOf(priorityDriver).getValue();
	}

	public void setPriorityDriver(int priorityDriver) {
		this.priorityDriver = PriorityDriver.valueOf(priorityDriver).getValue();
	}

	public int getAdvanceOrdersSilentTime() {
		return advanceOrdersSilentTime;
	}

	public void setAdvanceOrdersSilentTime(int advanceOrdersSilentTime) {
		this.advanceOrdersSilentTime = advanceOrdersSilentTime;
	}

	public int getAdvanceOrdersDistribTime() {
		return advanceOrdersDistribTime;
	}

	public void setAdvanceOrdersDistribTime(int advanceOrdersDistribTime) {
		this.advanceOrdersDistribTime = advanceOrdersDistribTime;
	}

	public int getMaxReserveDrivers() {
		return maxReserveDrivers;
	}

	public void setMaxReserveDrivers(int maxReserveDrivers) {
		this.maxReserveDrivers = maxReserveDrivers;
	}

	public int getAdvanceOrdersTimeLimit() {
		return advanceOrdersTimeLimit;
	}

	public void setAdvanceOrdersTimeLimit(int advanceOrdersTimeLimit) {
		this.advanceOrdersTimeLimit = advanceOrdersTimeLimit;
	}

	public int getTaxiServiceId() {
		return taxiServiceId;
	}

	public void setTaxiServiceId(int taxiServiceId) {
		this.taxiServiceId = taxiServiceId;
	}
	
	

}


