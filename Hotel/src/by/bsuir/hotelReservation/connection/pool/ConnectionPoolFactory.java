package by.bsuir.hotelReservation.connection.pool;

import by.bsuir.hotelReservation.connection.pool.exception.ConnectionPoolException;

public final class ConnectionPoolFactory {

	private static final ConnectionPoolFactory instance = new ConnectionPoolFactory();
	private final ConnectionPool pool = new ConnectionPoolImpl();

	public static ConnectionPoolFactory getInstance() {
		return instance;
	}

	public ConnectionPool getConnectionPool() throws ConnectionPoolException {
		try {
			pool.initPoolData();
		} catch (ConnectionPoolException e) {
			throw new ConnectionPoolException(e.getLocalizedMessage());
		}
		return pool;
	}
}
