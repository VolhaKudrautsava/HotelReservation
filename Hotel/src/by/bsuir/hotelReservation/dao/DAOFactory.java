package by.bsuir.hotelReservation.dao;

import by.bsuir.hotelReservation.dao.impl.DAORoomImpl;
import by.bsuir.hotelReservation.dao.impl.DAOUserImpl;

public class DAOFactory {

	private static final DAOFactory factory = new DAOFactory();

	private final DAOUser userDAO = new DAOUserImpl();
	private final DAORoom roomDAO = new DAORoomImpl();

	private DAOFactory() {
	}

	public static DAOFactory getInstance() {
		return factory;
	}

	public DAOUser getUserDAO() {
		return userDAO;
	}

	public DAORoom getRoomDAO() {
		return roomDAO;
	}

}
