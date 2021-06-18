package com.demo.hotel.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "`reservation`")
public class Reservation {
	
	// reservation fields and annotate with it's column to connect to jpa entity manager
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reservation_id")
	private int id;

	
	private String hotelName;
	
	@Column(name = "reservation_room")
	private String room;

	@Column(name = "reservation_price")
	private int price;

	@Column(name = "reservation_num_of_rooms")
	private int rooms;

	@Column(name = "reservation_num_of_persons")
	private int persons;

	@Column(name = "reservation_num_of_children")
	private int children;

	@Column(name = "reservation_open_buffet")
	private String openBuffet;

	@Column(name = "reservation_from_date")
	private Date arrivalDate;

	@Column(name = "reservation_stay_days")
	private int stayDays;

	@Column(name = "reservation_user_id")
	private int userId;
	
	
	@Column(name = "reservation_status")
	private String status;

	
	// reservation super and fields constructors
	
	public Reservation() {
	}


	public Reservation(int id, String hotelName, String room, int price, int rooms, int persons, int children,
			String openBuffet, Date arrivalDate, int stayDays, int userId, String status) {
		super();
		this.id = id;
		this.hotelName = hotelName;
		this.room = room;
		this.price = price;
		this.rooms = rooms;
		this.persons = persons;
		this.children = children;
		this.openBuffet = openBuffet;
		this.arrivalDate = arrivalDate;
		this.stayDays = stayDays;
		this.userId = userId;
		this.status = status;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getHotelName() {
		return hotelName;
	}


	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}


	public String getRoom() {
		return room;
	}


	public void setRoom(String room) {
		this.room = room;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getRooms() {
		return rooms;
	}


	public void setRooms(int rooms) {
		this.rooms = rooms;
	}


	public int getPersons() {
		return persons;
	}


	public void setPersons(int persons) {
		this.persons = persons;
	}


	public int getChildren() {
		return children;
	}


	public void setChildren(int children) {
		this.children = children;
	}


	public String getOpenBuffet() {
		return openBuffet;
	}


	public void setOpenBuffet(String openBuffet) {
		this.openBuffet = openBuffet;
	}


	public Date getArrivalDate() {
		return arrivalDate;
	}


	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}


	public int getStayDays() {
		return stayDays;
	}


	public void setStayDays(int stayDays) {
		this.stayDays = stayDays;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Reservation [id=" + id + ", hotelName=" + hotelName + ", room=" + room + ", price=" + price + ", rooms="
				+ rooms + ", persons=" + persons + ", children=" + children + ", openBuffet=" + openBuffet
				+ ", arrivalDate=" + arrivalDate + ", stayDays=" + stayDays + ", userId=" + userId + ", status="
				+ status + "]";
	}


	
	

}
