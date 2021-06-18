package com.demo.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.hotel.entity.Hotel;

@Repository
public interface HotelRep extends JpaRepository<Hotel, Integer> {

	Hotel findByhotelId(int hotelId);

	
}
