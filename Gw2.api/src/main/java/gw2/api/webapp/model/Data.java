package gw2.api.webapp.model;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;

import gw2.api.services.api.ServiceFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class Data {

	@Autowired
	private ServiceFacade services;
	
	private ExecutorService pool = Executors.newFixedThreadPool(4);
	
	public enum Service {
		WORLDNAMES,
		MAPNAMES,
		EVENTNAMES,
		EVENTS,
		EVENTDETAILS;
	}
	private class RunService implements Runnable {
		
		private Service serv;
		
		public RunService(Service serv) {
			this.serv = serv;
		}
		public void run() {
			switch(serv) {
				case WORLDNAMES:
					setWorldNames(services.getAllWorldNames(lang));
					System.out.println("worldnames: "+worldNames.size());
					break;
				case MAPNAMES:
					setMapNames(services.getAllMapNames(lang));
					System.out.println("mapnames: "+mapNames.size());
					break;
				case EVENTNAMES:
					setEventNames(services.getAllEventNames(lang));
					System.out.println("eventnames: "+eventNames.size());
					break;
				case EVENTS:
					setEvents(services.getEventsByWorld(2201));
					System.out.println("events: "+events.size()+" updated." + new Date());
					break;
				case EVENTDETAILS:
					setEventDetails(services.getAllEventDetails(lang));
					System.out.println("eventdetails: "+eventDetails.size());
			}
		}
	}
	private String lang = "de";
	
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
	
	public ServiceFacade getServices() {
		return services;
	}
	
	public void setServices(ServiceFacade services) {
		this.services = services;
	}
	
	@PostConstruct
	private void init() {
		pool = Executors.newFixedThreadPool(4);
		pool.submit(new RunService(Service.WORLDNAMES));
		pool.submit(new RunService(Service.MAPNAMES));
		pool.submit(new RunService(Service.EVENTNAMES));
		//pool.submit(new RunService(Service.EVENTS));
		pool.submit(new RunService(Service.EVENTDETAILS));
		System.out.println("Initialization complete.");
		//pool.shutdown();
	}
	
	@Scheduled(fixedRate=1000)
	public void updateEvents() {
		pool.submit(new RunService(Service.EVENTS));
		System.out.println("Events updated.");
	}
}
