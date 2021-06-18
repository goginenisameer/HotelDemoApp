package com.demo.hotel.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.demo.hotel.entity.Hotel;

//Service Pattern for Hotel
public interface HotelService {

	public Hotel getHotelById(int hotelId);
	
	public List<Hotel> getAllHotels();

	public void deleteHotel(int hotelId);
	
	public Hotel saveHotel(Hotel hotel);

}
