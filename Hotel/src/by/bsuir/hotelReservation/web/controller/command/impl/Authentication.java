package by.bsuir.hotelReservation.web.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.bsuir.hotelReservation.domain.User;
import by.bsuir.hotelReservation.service.ServiceFactory;
import by.bsuir.hotelReservation.service.UserService;
import by.bsuir.hotelReservation.service.exception.ServiceException;
import by.bsuir.hotelReservation.web.controller.command.Command;

public class Authentication implements Command {
	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";
	private static final String USER = "user";
	private static final String ROLE = "role";
	private static final String URL_VIEW_ALL_ROOM_WITH_INFO = "http://localhost:8082/Hotel/Controller?command=VIEW_ALL_ROOMS&message=Wrong login or password";
	private static final String URL_VIEW_ALL_BOOK_WITH_ERROR = "http://localhost:8082/Hotel/Controller?command=VIEW_ALL_ROOMS&errorMessage=Sorry,technical problems";
	private static final String URL_VIEW_ROOMS = "http://localhost:8082/Hotel/Controller?command=VIEW_ALL_ROOMS";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter(LOGIN);
		String password = request.getParameter(PASSWORD);
		User user = null;

		ServiceFactory factory = ServiceFactory.getInstance();
		UserService userService = factory.getUserService();

		try {
			user = userService.authenticate(login, password);
			if (user != null) {
				HttpSession session = request.getSession(true);

				session.setAttribute(LOGIN, user.getName());
				session.setAttribute(ROLE, String.valueOf(user.getAccessRights()));
				session.setAttribute(USER, user);

				response.sendRedirect(URL_VIEW_ROOMS);

			} else {
				response.sendRedirect(URL_VIEW_ALL_ROOM_WITH_INFO);
			}
		} catch (ServiceException e) {

			response.sendRedirect(URL_VIEW_ALL_BOOK_WITH_ERROR);

		}
	}
}