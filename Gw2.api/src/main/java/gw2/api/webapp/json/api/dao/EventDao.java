package gw2.api.webapp.json.api.dao;

import gw2.api.webapp.model.Event;

import java.util.List;

public interface EventDao {

	List<Event> getAllEvents();
	
	List<Event> getEventsByWorld(int worldId);
	
	List<Event> getEventsByWorldAndMap(int worldId, int mapId);
	
	List<Event> getEventByWorldAndMapAndEvent(int worldId, int mapId, String eventId);
	
}
