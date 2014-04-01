package gw2.api.webapp.json.api.dao;

import gw2.api.webapp.json.api.domain.Event;

import java.util.List;

public interface EventDao {

	List<Event> getEventsByWorld(int worldId);
	
	List<Event> getEventsByWorldAndMap(int worldId, int mapId);
	
	Event getEventByWorldAndMapAndEvent(int worldId, int mapId, String eventId);
	
}
