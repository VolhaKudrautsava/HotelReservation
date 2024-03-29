package by.bsuir.hotelReservation.web.controller;

import java.util.HashMap;
import java.util.Map;

import by.bsuir.hotelReservation.web.controller.command.Command;
import by.bsuir.hotelReservation.web.controller.command.impl.AddRoom;
import by.bsuir.hotelReservation.web.controller.command.impl.Authentication;
import by.bsuir.hotelReservation.web.controller.command.impl.BookRoom;
import by.bsuir.hotelReservation.web.controller.command.impl.DeleteRoom;
import by.bsuir.hotelReservation.web.controller.command.impl.Exit;
import by.bsuir.hotelReservation.web.controller.command.impl.FreeRoom;
import by.bsuir.hotelReservation.web.controller.command.impl.LocaleEn;
import by.bsuir.hotelReservation.web.controller.command.impl.LocaleRu;
import by.bsuir.hotelReservation.web.controller.command.impl.Registration;
import by.bsuir.hotelReservation.web.controller.command.impl.ShowRegistrationForm;
import by.bsuir.hotelReservation.web.controller.command.impl.ViewAllRoom;


public class CommandProvider {
	private Map<String, Command> commands = new HashMap<>();

	public CommandProvider() {
		commands.put("AUTHENTICATION", new Authentication());
		commands.put("REGISTRATION", new Registration());
		commands.put("VIEW_ALL_ROOMS", new ViewAllRoom());
		commands.put("LOCALERU", new LocaleRu());
		commands.put("LOCALEEN", new LocaleEn());
		commands.put("EXIT", new Exit());
		commands.put("SHOW_REGISTRATION_FORM", new ShowRegistrationForm());
		commands.put("ADD_NEW_ROOM", new AddRoom());
		commands.put("BOOK_ROOM", new BookRoom());
		commands.put("FREE_ROOM", new FreeRoom());
		commands.put("DELETE_ROOM", new DeleteRoom());
	}

	public Command getCommand(String commandName) {
		Command command = commands.get(commandName);
		return command;
	}

}
