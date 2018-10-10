package com.example.dao;

import java.util.Date;

import com.example.model.Reservation;
import com.example.model.Room;

public interface IRoomDao {

	public boolean isAvailable(Room room,Date date_in, Date date_out);

	
}
