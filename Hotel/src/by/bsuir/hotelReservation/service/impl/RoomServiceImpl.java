package by.bsuir.hotelReservation.service.impl;

import java.util.List;

import by.bsuir.hotelReservation.dao.DAOFactory;
import by.bsuir.hotelReservation.dao.DAORoom;
import by.bsuir.hotelReservation.dao.exception.DAOException;
import by.bsuir.hotelReservation.domain.Room;
import by.bsuir.hotelReservation.service.RoomService;
import by.bsuir.hotelReservation.service.exception.ServiceException;

public class RoomServiceImpl implements RoomService {

	@Override
	public List<Room> findAll() throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		DAORoom roomrDAO = daoFactory.getRoomDAO();
		List<Room> listOfRoom;
		try {
			listOfRoom=roomrDAO.findAll();
			return listOfRoom;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Room> findVacantRooms() throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		DAORoom roomrDAO = daoFactory.getRoomDAO();
		List<Room> listOfVacantRoom;
		try {
			listOfVacantRoom=roomrDAO.findVacantRooms();
			return listOfVacantRoom;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void addRoom(Room room) throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		DAORoom roomrDAO = daoFactory.getRoomDAO();
		try {
			roomrDAO.addRoom(room);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void bookRoom(int idRoom) throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		DAORoom roomrDAO = daoFactory.getRoomDAO();
		try {
			roomrDAO.bookRoom(idRoom);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	@Override
	public void freeRoom(int idRoom) throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		DAORoom roomrDAO = daoFactory.getRoomDAO();
		try {
			roomrDAO.freeRoom(idRoom);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void deleteRoom(int idRoom) throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		DAORoom roomrDAO = daoFactory.getRoomDAO();
		try {
			roomrDAO.deleteRoom(idRoom);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
}
