package gw2.api.webapp.controller;

import java.util.List;

import gw2.api.webapp.json.api.dao.EventDao;
import gw2.api.webapp.json.api.domain.Event;

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
	private EventDao dao;
	
	@RequestMapping(value = "/{worldId}", method = RequestMethod.GET)
	@ResponseBody
	public List<Event> getEventsByWorld(@PathVariable int worldId) {
		List<Event> result = dao.getEventsByWorld(worldId);
		return result;
	}
	
	@RequestMapping(value = "/{worldId}/{mapId}", method = RequestMethod.GET)
	@ResponseBody
	public List<Event> getEventsByWorldAndMap(@PathVariable int worldId, @PathVariable int mapId){
		List<Event> result = dao.getEventsByWorldAndMap(worldId, mapId);
		return result;
	}
	
	@RequestMapping(value = "/{worldId}/{mapId}/{eventId}")
	@ResponseBody
	public Event getEventByWorldAndMapAndEvent(@PathVariable int worldId, @PathVariable int mapId, @PathVariable String eventId) {
		Event result = dao.getEventByWorldAndMapAndEvent(worldId, mapId, eventId);
		return result;
	}
}