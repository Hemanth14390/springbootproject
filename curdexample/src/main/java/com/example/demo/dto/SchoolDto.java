package com.example.demo.dto;

import lombok.Data;

@Data
public class SchoolDto {
	private long id;
	private String name;
	private double fee;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public SchoolDto(long id, String name, double fee) {
		super();
		this.id = id;
		this.name = name;
		this.fee = fee;
	}
	public SchoolDto() {
		super();
	}
	@Override
	public String toString() {
		return "SchoolDto [id=" + id + ", name=" + name + ", fee=" + fee + "]";
	}

}
