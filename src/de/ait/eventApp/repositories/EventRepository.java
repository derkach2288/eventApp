package de.ait.eventApp.repositories;

import de.ait.eventApp.models.Event;

import java.util.List;

public interface EventRepository extends CrudRepository<Event>{
    List<Event> findByDescription(String description);
}
