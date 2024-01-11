package de.ait.eventApp.models;

import java.time.LocalDate;
import java.util.Objects;

public class Event {
    private Long id;
    private String description;
    LocalDate date;

    public Event(Long id, String description, LocalDate date) {
        this.id = id;
        this.description = description;
        this.date = date;
    }

    public Event(String description, LocalDate date) {
        this.description = description;
        this.date = date;
    }

    public Event() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        return Objects.equals(id, event.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}
