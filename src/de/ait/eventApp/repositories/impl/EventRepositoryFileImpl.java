package de.ait.eventApp.repositories.impl;

import de.ait.eventApp.models.Event;
import de.ait.eventApp.repositories.EventRepository;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EventRepositoryFileImpl implements EventRepository {

    String FILE_NAME = "src/de/ait/eventApp/eventList.csv";
    private Long generateId;


    @Override
    public void save(Event event) {
        try(FileWriter fw = new FileWriter(FILE_NAME, true);
            BufferedWriter bw = new BufferedWriter(fw)) {
            generateId = findAll().size()+1L;
            event.setId(generateId);
            bw.write(pars(event));
//            generateId++;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String pars(Event event) {
        String line = "\n"+ event.getId() + "," + event.getDescription() + "," + event.getDate();
        return line;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void updateById(Long id) {

    }

    @Override
    public Event findById(Long id) {

        return findAll().stream().filter(event -> event.getId()==id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Event> findAll() {
        List<Event> eventList = new ArrayList<>();
        try(FileReader fileReader = new FileReader(FILE_NAME);
            BufferedReader br = new BufferedReader(fileReader)) {
            String line = br.readLine();
            while (line!=null){
                Event event = parsLine(line);
                eventList.add(event);
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        generateId = eventList.size()+1L;

        return eventList;
    }

    private Event parsLine(String line) {
        String[] parsed = line.split(",");
        Long id = Long.parseLong(parsed[0]);
        String description = parsed[1];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(parsed[2], formatter);
        return new Event(id, description, date);
    }

    @Override
    public List<Event> findByDescription(String description) {
        return null;
    }
}
