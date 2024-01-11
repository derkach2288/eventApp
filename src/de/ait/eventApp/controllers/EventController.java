package de.ait.eventApp.controllers;

import de.ait.eventApp.models.Event;
import de.ait.eventApp.services.impl.EventServiceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class EventController {

    private final Scanner scanner;
    private final EventServiceImpl eventService;

    public EventController(Scanner scanner, EventServiceImpl eventService) {
        this.scanner = scanner;
        this.eventService = eventService;
    }

    public void addEvent() {
        System.out.println("Input description: ");
        String description = scanner.nextLine();

        System.out.println("Input date YYY-MM-DD: ");
        String dateStr = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateStr, formatter);

        Event event = eventService.addEvent(description, date);
        System.out.println(event);

    }

    public void getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        System.out.println(events);
    }
}
