package de.ait.eventApp;

import de.ait.eventApp.controllers.EventController;
import de.ait.eventApp.repositories.EventRepository;
import de.ait.eventApp.repositories.impl.EventRepositoryFileImpl;
import de.ait.eventApp.repositories.impl.EventRepositoryListImpl;
import de.ait.eventApp.services.impl.EventServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EventRepository eventRepository = new EventRepositoryListImpl();
        EventServiceImpl eventService = new EventServiceImpl(eventRepository);
        EventController eventController = new EventController(scanner, eventService);

        EventRepository eventRepositoryFile = new EventRepositoryFileImpl();
        EventServiceImpl eventServiceFile = new EventServiceImpl(eventRepositoryFile);
        EventController eventControllerFile = new EventController(scanner, eventServiceFile);



        boolean isRun = true;

        while (isRun) {
            System.out.println("Input command (address): ");
            String command = scanner.nextLine();

            switch (command) {
                case "/addEvent" -> eventController.addEvent();
                case "/events" -> eventController.getAllEvents();
                case "/addEventFile" -> eventControllerFile.addEvent();
                case "/eventsFile" -> eventControllerFile.getAllEvents();
                case "/exit" -> isRun = false;
            }
        }

    }
}
