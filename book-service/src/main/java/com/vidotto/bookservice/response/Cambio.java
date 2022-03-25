package com.vidotto.bookservice.response;

import java.io.Serializable;
import java.util.Objects;

public class Cambio implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String from;
	private String to;
	private String environment;
	private Double conversionFactor;
	private Double convertedValue;
	
	public Cambio(Long id, String from, String to, String environment, Double convertionFactor,
			Double convertedValue) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.environment = environment;
		this.conversionFactor = convertionFactor;
		this.convertedValue = convertedValue;
	}

	public Cambio() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public Double getConvertionFactor() {
		return conversionFactor;
	}

	public void setConvertionFactor(Double convertionFactor) {
		this.conversionFactor = convertionFactor;
	}

	public Double getConvertedValue() {
		return convertedValue;
	}

	public void setConvertedValue(Double convertedValue) {
		this.convertedValue = convertedValue;
	}

	@Override
	public int hashCode() {
		return Objects.hash(convertedValue, conversionFactor, environment, from, id, to);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cambio other = (Cambio) obj;
		return Objects.equals(convertedValue, other.convertedValue)
				&& Objects.equals(conversionFactor, other.conversionFactor)
				&& Objects.equals(environment, other.environment) && Objects.equals(from, other.from)
				&& Objects.equals(id, other.id) && Objects.equals(to, other.to);
	}
}
