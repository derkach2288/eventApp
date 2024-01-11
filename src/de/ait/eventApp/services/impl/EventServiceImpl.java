package de.ait.eventApp.services.impl;

import de.ait.eventApp.models.Event;
import de.ait.eventApp.repositories.EventRepository;
import de.ait.eventApp.services.EventService;

import java.time.LocalDate;
import java.util.List;

public class EventServiceImpl implements EventService {
    public final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event addEvent(String description, LocalDate date) {
        if (description == null || description.trim() =="") {
            throw new IllegalArgumentException("description can't be empty");
        }
        Event event = new Event(description, date);
        eventRepository.save(event);
        return event;
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}
