package by.bsuir.hotelReservation.dao;

import java.util.List;

import by.bsuir.hotelReservation.dao.exception.DAOException;
import by.bsuir.hotelReservation.domain.Room;

public interface DAORoom {
	List<Room> findAll() throws DAOException;

	List<Room> findVacantRooms() throws DAOException;

	void addRoom(Room room) throws DAOException;

	void bookRoom(int idRoom) throws DAOException;
	
	void freeRoom(int idRoom) throws DAOException;

	void deleteRoom(int idRoom) throws DAOException;
}
