package com.demo.hotel.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



@Entity
@Table(name = "`hotel`")
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hotelId;
	private String hotelName;
	private String hotelDesc;
	private String hotelLocation;
	private String hotelCategory;
	private int hotelPrice;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "hotelId")
	@Fetch(FetchMode.JOIN)
	private Set<Image> images;

	
	public Hotel() {
		super();
	}


	public Hotel(int hotelId, String hotelName, String hotelDesc, String hotelLocation, String hotelCategory,
			int hotelPrice, Set<Image> images) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelDesc = hotelDesc;
		this.hotelLocation = hotelLocation;
		this.hotelCategory = hotelCategory;
		this.hotelPrice = hotelPrice;
		this.images = images;
	}


	public int getHotelId() {
		return hotelId;
	}


	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}


	public String getHotelName() {
		return hotelName;
	}


	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}


	public String getHotelDesc() {
		return hotelDesc;
	}


	public void setHotelDesc(String hotelDesc) {
		this.hotelDesc = hotelDesc;
	}


	public String getHotelLocation() {
		return hotelLocation;
	}


	public void setHotelLocation(String hotelLocation) {
		this.hotelLocation = hotelLocation;
	}


	public String getHotelCategory() {
		return hotelCategory;
	}


	public void setHotelCategory(String hotelCategory) {
		this.hotelCategory = hotelCategory;
	}


	public int getHotelPrice() {
		return hotelPrice;
	}


	public void setHotelPrice(int hotelPrice) {
		this.hotelPrice = hotelPrice;
	}


	public Set<Image> getImages() {
		return images;
	}


	public void setImages(Set<Image> images) {
		this.images = images;
	}


	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelDesc=" + hotelDesc
				+ ", hotelLocation=" + hotelLocation + ", hotelCategory=" + hotelCategory + ", hotelPrice=" + hotelPrice
				+ ", images=" + images + "]";
	}

	
}
