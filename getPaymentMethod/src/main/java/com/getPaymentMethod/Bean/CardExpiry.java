package com.getPaymentMethod.Bean;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class CardExpiry 
{
	@Id
	private String month;
	private int year;
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "CarsExpiry [month=" + month + ", year=" + year + "]";
	}
	
	
}
