package com.example.service;

import java.util.Date;

import com.example.dao.IReservationDao;
import com.example.dao.IRoomDao;
import com.example.model.Guest;
import com.example.model.Reservation;
import com.example.model.Room;
import com.example.dao.IReservationDao;


public class BookService {
	
	private IRoomDao iRoomDao;
	private IReservationDao iReservationDao;
	
	





	public BookService(IRoomDao iRoomDao, IReservationDao iReservationDao) {
		this.iRoomDao = iRoomDao;
		this.iReservationDao = iReservationDao;
	}

	
	

	public BookService(IReservationDao iReservationDao) {
		super();
		this.iReservationDao = iReservationDao;
	}




	public boolean bookRoom(Room room,Date date_in, Date date_out,Guest guest)  {
		
		if((iRoomDao.isAvailable(room, date_in,date_out))) {
			Reservation reservation = new Reservation(date_in,date_out,room,guest);
			return iReservationDao.createReservation(reservation);
		}
		
		return false;
	}
	
	
	public boolean cancelReservation(int id) {
		
		Reservation reservation = iReservationDao.findReservation(id);
		if(reservation!=null) {
			return iReservationDao.cancelReservation(reservation);
		}
	
		return false;
	}
	
	}
	

