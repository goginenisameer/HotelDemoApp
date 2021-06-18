package com.demo.hotel.temp;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class CurrentReservation {
	
	// temp class to filter data and get it from controller to database using services
	//  current reservation fields and annotate to get the required data
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String hotelName;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private int id;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private int stayPeriod;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String room;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private int price;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private int rooms;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private int persons;

	@NotNull(message = "is required")
	@Size(message = "is required")
	private int children;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String openBuffet;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date arrivalDate;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private int usertId;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private int hotelPrice;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String status;

	// current reservation super and fields constructors

	public CurrentReservation() {
	}

	public CurrentReservation(@NotNull(message = "is required") @Size(min = 1, message = "is required") String hotelName,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") int id,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") int stayPeriod,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") String room,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") int price,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") int rooms,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") int persons,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") int children,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") String openBuffet,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") Date arrivalDate,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") int usertId,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") int hotelPrice,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") String status) {
		super();
		this.hotelName=hotelName;
		this.id = id;
		this.stayPeriod = stayPeriod;
		this.room = room;
		this.price = price;
		this.rooms = rooms;
		this.persons = persons;
		this.children = children;
		this.openBuffet = openBuffet;
		this.arrivalDate = arrivalDate;
		this.usertId = usertId;
		this.hotelPrice=hotelPrice;
		this.status=status;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStayPeriod() {
		return stayPeriod;
	}

	public void setStayPeriod(int stayPeriod) {
		this.stayPeriod = stayPeriod;
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

	public int getUsertId() {
		return usertId;
	}

	public void setUsertId(int usertId) {
		this.usertId = usertId;
	}

	public int getHotelPrice() {
		return hotelPrice;
	}

	public void setHotelPrice(int hotelPrice) {
		this.hotelPrice = hotelPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CurrentReservation [hotelName=" + hotelName + ", id=" + id + ", stayPeriod=" + stayPeriod + ", room="
				+ room + ", price=" + price + ", rooms=" + rooms + ", persons=" + persons + ", children=" + children
				+ ", openBuffet=" + openBuffet + ", arrivalDate=" + arrivalDate + ", usertId=" + usertId
				+ ", hotelPrice=" + hotelPrice + ", status=" + status + "]";
	}

	
	

}
