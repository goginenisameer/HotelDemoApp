package com.demo.hotel.services;

import java.util.Collection;

import com.demo.hotel.entity.Reservation;
import com.demo.hotel.temp.CurrentReservation;

//Service Pattern for Reservation
public interface ReservationService {
	
	public Reservation getReservationForLoggedUserById(int resId);

	public Collection<Reservation> getReservationsForLoggedUser();
	
	public void saveOrUpdateReservation(CurrentReservation currentReservation);
	
	public void deleteReservation(int resId);

	public CurrentReservation reservationToCurrentReservationById(int resId);
	
	public Collection<Reservation> getAllReservations();

	public void setStatus(Reservation user);
	
	

	
}
