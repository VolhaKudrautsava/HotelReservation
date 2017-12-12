package by.bsuir.hotelReservation.web.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.bsuir.hotelReservation.service.RoomService;
import by.bsuir.hotelReservation.service.ServiceFactory;
import by.bsuir.hotelReservation.service.exception.ServiceException;
import by.bsuir.hotelReservation.web.controller.command.Command;

public class FreeRoom implements Command {
	private static final String ID ="id";
	private static final String ERROR_MESSAGE = "errorMessage";
	private static final String MESSAGE_FAIL_FREE_ROOM = "The room is not released!";
	private static final String MESSAGE_SUCCESSFUL_FREE_ROOM = "&messageInfo=The room was successfully released!";
	private static final String URL_VIEW_ALL_BOOK=" http://localhost:8082/Hotel/Controller?command=VIEW_ALL_ROOMS";
	private static final String VIEW_JSP = "WEB-INF/jsp/viewAllRoom.jsp";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idRoom=request.getParameter(ID);
		 
		int id=Integer.parseInt(idRoom);
		
		ServiceFactory factory=ServiceFactory.getInstance();
		RoomService roomService=factory.getRoomService();
	
		String page = null;
		try {
			    roomService.freeRoom(id);
				String url=URL_VIEW_ALL_BOOK+MESSAGE_SUCCESSFUL_FREE_ROOM;
			    response.sendRedirect(url);
		
		} catch (ServiceException e) {
						
			request.setAttribute(ERROR_MESSAGE, MESSAGE_FAIL_FREE_ROOM);
			page=VIEW_JSP;
			
			RequestDispatcher dispatcher=request.getRequestDispatcher(page);
			dispatcher.forward(request, response);
		}		
			
	}	

}
