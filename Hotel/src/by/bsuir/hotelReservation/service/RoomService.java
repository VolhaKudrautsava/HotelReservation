package by.bsuir.hotelReservation.service;

import java.util.List;

import by.bsuir.hotelReservation.domain.Room;
import by.bsuir.hotelReservation.service.exception.ServiceException;

public interface RoomService {

	List<Room> findAll() throws ServiceException;

	List<Room> findVacantRooms() throws ServiceException;

	void addRoom(Room room) throws ServiceException;

	void bookRoom(int idRoom) throws ServiceException;
	
	void freeRoom(int idRoom) throws ServiceException;

	void deleteRoom(int idRoom) throws ServiceException;
}
