package com.springboot.dtos;

public class CarResponseDTO {

	private Long id;
	private String model;
	private String brand;
	private String licensePlate;
	
	public CarResponseDTO(Long id, String model, String brand, String licensePlate) {
		this.id = id;
		this.model = model;
		this.brand = brand;
		this.licensePlate = licensePlate;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
		
}
