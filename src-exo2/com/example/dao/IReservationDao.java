package com.example.dao;

import com.example.model.Reservation;

public interface IReservationDao {
	
	public boolean createReservation(Reservation reservation);

	public Reservation findReservation(int id);

	public boolean cancelReservation(Reservation reservation);

}
