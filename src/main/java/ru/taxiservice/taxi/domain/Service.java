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
@Table(name="service", schema="public")
public class Service {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="service_service_id_seq")
    @SequenceGenerator(name="service_service_id_seq", sequenceName="service_service_id_seq")
	@Column(name = "service_id", nullable = false)
    private Long id;
	
	@Column(name = "taxi_service_id", nullable = false)
	private int taxiServiceId;
	
	@Column(name = "city_id", nullable = false)
	private Integer cityId;
	
	@NotNull
	@Size(min = 1, max = 256)
	@Column(name = "name", nullable = false, length = 256)
	private String name;
	
	@Column(name = "time_zone", nullable = false, length = 10)
	private String timeZone;
	
	@Column(name = "distribution_id", nullable = true)
	private Integer distributionId;
	
	@Column(name = "tariff_city_id", nullable = true)
	private Integer tariffCityId;
	
	@Column(name = "tariff_outside_city_id", nullable = true)
	private Integer tariffOutsideCityId;
	
	/* Объединять загородной и городской тарифы для автоматического переключения тарификации */
	@Column(name = "tariff_auto_change", nullable = false)
	private Boolean tariffAutoChange;
	
	/* Использовать фиксированную предварительно рассчитанную стоимость поездки */
	@Column(name = "fixed_price", nullable = false)
	private Boolean fixedPrice;
	
	/* Зачислять деньги на счет водителю при безналичном расчете */
	@Column(name = "driver_non_cash", nullable = false)
	private Boolean driverNonCash;
	
	/* Показывать водителю стоимость поездки до взятия заказа */
	@Column(name = "driver_show_cost", nullable = false)
	private Boolean driverShowCost;
	
	/* Показывать водителю поле куда до взятия заказа */
	@Column(name = "driver_show_to_before", nullable = false)
	private Boolean driverShowToBefore;
	
	/* Показывать водителю поле куда */
	@Column(name = "driver_show_to", nullable = false)
	private Boolean driverShowTo;
	
	/* Разрешить предварительные заказы */
	@Column(name = "allow_preliminary", nullable = false)
	private Boolean allowPreliminary;
	
	/* Разрешить назначать заказы вручную */
	@Column(name = "allow_manual_assign", nullable = false)
	private Boolean allowManualAssign;
	
	/* Показывать число машин */
	@Column(name = "show_cars_count", nullable = false)
	private Boolean showCarsCount;
	
	/* Показывать стоянку */
	@NotNull
	@Column(name = "show_parking", nullable = false)
	private Boolean showParking;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "city_id", referencedColumnName = "city_id", nullable = false, insertable = false, updatable = false)
	private City city;
	
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTaxiServiceId() {
		return taxiServiceId;
	}

	public void setTaxiServiceId(int taxiServiceId) {
		this.taxiServiceId = taxiServiceId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public Integer getDistributionId() {
		return distributionId;
	}

	public void setDistributionId(Integer destribution) {
		if (destribution.intValue() == 0) {
			this.distributionId = null;
			return;
		}
		this.distributionId = destribution;
	}

	public Integer getTariffCityId() {
		return tariffCityId;
	}

	public void setTariffCityId(Integer tariffCity) {
		if (tariffCity.intValue() == 0) {
			this.tariffCityId = null;
			return;
		}
		this.tariffCityId = tariffCity;
	}

	public Integer getTariffOutsideCityId() {
		return tariffOutsideCityId;
	}

	public void setTariffOutsideCityId(Integer tariffOutsideCity) {
		if (tariffOutsideCity.intValue() == 0) {
			this.tariffOutsideCityId = null;
			return;
		}
		this.tariffOutsideCityId = tariffOutsideCity;
	}

	public Boolean getTariffAutoChange() {
		return tariffAutoChange;
	}

	public void setTariffAutoChange(Boolean tariffAutoChange) {
		this.tariffAutoChange = tariffAutoChange;
	}

	public Boolean getFixedPrice() {
		return fixedPrice;
	}

	public void setFixedPrice(Boolean fixedPrice) {
		this.fixedPrice = fixedPrice;
	}

	public Boolean getDriverNonCash() {
		return driverNonCash;
	}

	public void setDriverNonCash(Boolean driverNonCash) {
		this.driverNonCash = driverNonCash;
	}

	public Boolean getDriverShowCost() {
		return driverShowCost;
	}

	public void setDriverShowCost(Boolean driverShowCost) {
		this.driverShowCost = driverShowCost;
	}

	public Boolean getDriverShowToBefore() {
		return driverShowToBefore;
	}

	public void setDriverShowToBefore(Boolean driverShowToBefore) {
		this.driverShowToBefore = driverShowToBefore;
	}

	public Boolean getAllowPreliminary() {
		return allowPreliminary;
	}

	public void setAllowPreliminary(Boolean allowPreliminary) {
		this.allowPreliminary = allowPreliminary;
	}

	public Boolean getAllowManualAssign() {
		return allowManualAssign;
	}

	public void setAllowManualAssign(Boolean allowManualAssign) {
		this.allowManualAssign = allowManualAssign;
	}

	public Boolean getShowCarsCount() {
		return showCarsCount;
	}

	public void setShowCarsCount(Boolean showCarsCount) {
		this.showCarsCount = showCarsCount;
	}

	public Boolean getDriverShowTo() {
		return driverShowTo;
	}

	public void setDriverShowTo(Boolean driverShowTo) {
		this.driverShowTo = driverShowTo;
	}

	public Boolean getShowParking() {
		return showParking;
	}

	public void setShowParking(Boolean showParking) {
		this.showParking = showParking;
	}
	
	
}
