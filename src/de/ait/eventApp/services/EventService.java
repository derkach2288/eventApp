package de.ait.eventApp.services;

import de.ait.eventApp.models.Event;

import java.time.LocalDate;
import java.util.List;

public interface EventService {
    Event addEvent(String description, LocalDate date);
    List<Event> getAllEvents();
}
