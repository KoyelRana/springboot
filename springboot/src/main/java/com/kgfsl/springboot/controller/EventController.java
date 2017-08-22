package com.kgfsl.springboot.controller;

import java.util.List;
import com.kgfsl.springboot.model.Event;
import com.kgfsl.springboot.repository.EventRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/rest/Event")
@RestController
public class EventController {
private EventRepository eventRepository;
//private AgendaRepository agendaRepository;

public EventController(EventRepository eventRepository) {
this.eventRepository = eventRepository;
}

// @GetMapping(value = "/all")
// public List<Event> getUsersContact() {
// return eventRepository.findAll();
// }

@RequestMapping(method = RequestMethod.GET)
public List<Event> allEvents() {
return eventRepository.findAll();
}

@RequestMapping(value = "/{id}",method = RequestMethod.GET)
public Event findoneEvent(@PathVariable Long id) {
return eventRepository.findOne(id);
}

@RequestMapping(method = RequestMethod.POST)
public Event addEvent(@RequestBody Event event) {
//event.setId(null);
return eventRepository.saveAndFlush(event);
}

@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
public Event updateEvent(@RequestBody Event updateEvent, @PathVariable Long id) {
updateEvent.setId(id);
return eventRepository.saveAndFlush(updateEvent);
}

@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
public void deleteEvent(@PathVariable Long id) {
eventRepository.delete(id);
}
// @GetMapping(value = "/update")
// public List<Event> update() {
//
// Event event = new Event();
//
// Agenda agenda = new Agenda();
// agenda.setDescription("one2onemapping");
// agenda.setTime("6.30 PM");
// agenda.setInstructor("You tube");
//
// event.setDate("23/08/2017");
// event.setAgenda(agenda);
//
// eventRepository.save(event);
//
// return eventRepository.findAll();
//
// }
}

