package gw2.api.webapp.model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import gw2.api.services.api.ServiceFacade;

import org.springframework.beans.factory.annotation.Autowired;

public class Data {

	@Autowired
	ServiceFacade services;
	
	private String lang = "de";
	private int worldId = 2201;
	
	private List<WorldName> worldNames;
	private List<MapName> mapNames;
	private List<EventName> eventNames;
	private List<Event> events;
	private Map<String, EventDetail> eventDetails;
	
	public List<WorldName> getWorldNames() {
		return worldNames;
	}
	
	public void setWorldNames(List<WorldName> worldNames) {
		this.worldNames = worldNames;
	}
	
	public List<MapName> getMapNames() {
		return mapNames;
	}
	
	public void setMapNames(List<MapName> mapNames) {
		this.mapNames = mapNames;
	}
	
	public List<EventName> getEventNames() {
		return eventNames;
	}
	
	public void setEventNames(List<EventName> eventNames) {
		this.eventNames = eventNames;
	}
	
	public List<Event> getEvents() {
		return events;
	}
	
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	public Map<String, EventDetail> getEventDetails() {
		return eventDetails;
	}
	
	public void setEventDetails(Map<String, EventDetail> eventDetails) {
		this.eventDetails = eventDetails;
	}
	
	@PostConstruct
	public void init() {
		setWorldNames(services.getAllWorldNames(lang));
		setMapNames(services.getAllMapNames(lang));
		setEventNames(services.getAllEventNames(lang));
		setEvents(services.getEventsByWorld(worldId));
		setEventDetails(services.getAllEventDetails(lang));
		System.out.println("Initialization complete.");
	}
}
