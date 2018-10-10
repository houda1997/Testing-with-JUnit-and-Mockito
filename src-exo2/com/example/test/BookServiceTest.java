package com.example.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.Test.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.dao.IReservationDao;
import com.example.dao.IRoomDao;
import com.example.model.Guest;
import com.example.model.Reservation;
import com.example.model.Room;
import com.example.service.BookService;

public class BookServiceTest {
	
	public IRoomDao iRoomDao;
    public IReservationDao iResDao;
	
	@Before
	public void setUp() throws Exception {
		
     iRoomDao = Mockito.mock(IRoomDao.class);
     iResDao = Mockito.mock(IReservationDao.class);

	}

	/* Tester la methode bookRoom qui Reserve une chambre à un client à une periode donnée   */
	@Test
	public void bookRoomtest() throws ParseException {
			
		 BookService bookService = new BookService(iRoomDao,iResDao);
		 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		 Date date1 = sdf.parse("01-01-2018");
		 Date date2 = sdf.parse("10-01-2018");

		 Room room = new Room (10,"Houda",2);
		 Guest guest = new Guest("Houda","Ab");
		 Reservation reserv = new Reservation(date1,date2,room,guest);
		 
		 when(iRoomDao.isAvailable(room, date1, date2)).thenReturn(true);
		 when(iResDao.createReservation(reserv)).thenReturn(true);
		 
		 assertTrue(bookService.bookRoom(room, date1, date2, guest));
		 
	
	}
	
	
	/* Tester la methode cancelReservation qui annule une reservation donnée en introduisant l'Id de la chambre  */
	@Test
	public void cancelReservationtest() throws ParseException {
			
		 BookService bookService = new BookService(iRoomDao,iResDao);
		 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		 Date date1 = sdf.parse("01-01-2018");
		 Date date2 = sdf.parse("10-01-2018");
		 
		 Room room = new Room (10,"Houda",2);
		 Guest guest = new Guest("Houda","Ab");
		 Reservation reserv = new Reservation(date1,date2,room,guest);
		 
		 when(iResDao.findReservation(0)).thenReturn(reserv);
		 when(iResDao.cancelReservation(reserv)).thenReturn(true);
		 
		 assertTrue(bookService.cancelReservation(0));
		 
	
	}
}
