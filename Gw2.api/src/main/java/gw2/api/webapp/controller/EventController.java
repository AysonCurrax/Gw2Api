package gw2.api.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import gw2.api.webapp.model.Data;
import gw2.api.webapp.model.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/events")
public class EventController {

	@Autowired
	private Data data;
	
	@RequestMapping(value = "/{worldId}", method = RequestMethod.GET)
	@ResponseBody
	public List<Event> getEventsByWorld(@PathVariable int worldId) {
		List<Event> result = new ArrayList<Event>();
		List<Event> events = data.getEvents();
		for(Event event : events) {
			if(event.getWorldId() == worldId) {
				result.add(event);
			}
		}
		return result;
	}
	
	@RequestMapping(value = "/{worldId}/{mapId}", method = RequestMethod.GET)
	@ResponseBody
	public List<Event> getEventsByWorldAndMap(@PathVariable int worldId, @PathVariable int mapId){
		List<Event> result = new ArrayList<Event>();
		List<Event> events = data.getEvents();
		for(Event event : events) {
			if(event.getWorldId() == worldId && event.getMapId() == mapId) {
				result.add(event);
			}
		}
		return result;
	}
	
	@RequestMapping(value = "/{worldId}/{mapId}/{eventId}")
	@ResponseBody
	public List<Event> getEventByWorldAndMapAndEvent(@PathVariable int worldId, @PathVariable int mapId, @PathVariable String eventId) {
		List<Event> result = new ArrayList<Event>();
		List<Event> events = data.getEvents();
		for(Event event : events) {
			if(event.getWorldId() == worldId && event.getMapId() == mapId && event.getEventId().equals(eventId)) {
				result.add(event);
			}
		}
		return result;
	}
}