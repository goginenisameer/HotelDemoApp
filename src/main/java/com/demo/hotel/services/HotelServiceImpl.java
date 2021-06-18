package com.demo.hotel.services;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.demo.hotel.entity.FileUploadUtil;
import com.demo.hotel.entity.Hotel;
import com.demo.hotel.entity.Image;
import com.demo.hotel.repository.HotelRep;

@Service
public class HotelServiceImpl implements HotelService {

	// service pattern to manage transactionals
	// and handle services for reservation between server and client

	private HotelRep hotelRepo;

	@Autowired
	public HotelServiceImpl(HotelRep hotelRepo) {
		this.hotelRepo = hotelRepo;
	}

	@Override
	@Transactional
	public Hotel getHotelById(int hotelId) {
		
		return hotelRepo.findByhotelId(hotelId);
	}

	@Override
	public List<Hotel> getAllHotels() {
		
		return hotelRepo.findAll();
	}

	@Override
	public void deleteHotel(int hotelId) {
		hotelRepo.deleteById(hotelId);
		
	}
	
	@Override
	public Hotel saveHotel(Hotel hotel) {
		
	     return hotelRepo.save(hotel);
	}

}
