package de.ait.eventApp.repositories.impl;

import de.ait.eventApp.models.Event;
import de.ait.eventApp.repositories.EventRepository;

import java.util.ArrayList;
import java.util.List;

public class EventRepositoryListImpl implements EventRepository {

    private final List<Event> events = new ArrayList<>();
    private Long generateId = 1L;
    @Override
    public void save(Event event) {
        event.setId(generateId);
        events.add(event);
        generateId++;
    }

    @Override
    public void deleteById(Long id) {
        events.removeIf(event -> event.getId()==id);
    }

    @Override
    public void updateById(Long id) {

    }

    @Override
    public Event findById(Long id) {

        return events.stream()
                .filter(event -> event.getId()==id)
                .findFirst()
                .orElse(null);
    }


    @Override
    public List<Event> findAll() {
        return new ArrayList<>(events);
    }

    @Override
    public List<Event> findByDescription(String description) {
        return events.stream()
                .filter(event -> event.getDescription().equalsIgnoreCase(description))
                .toList();
    }
}
