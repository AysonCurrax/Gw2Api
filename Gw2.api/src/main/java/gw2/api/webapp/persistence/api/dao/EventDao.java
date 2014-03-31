package gw2.api.webapp.persistence.api.dao;

import gw2.api.webapp.persistence.api.domain.Event;

import java.util.List;

public interface EventDao {

	List<Event> getEventsByWorld(int worldId);
	
	List<Event> getEventsByWorldAndMap(int worldId, int mapId);
	
	Event getEventByWorldAndMapAndEvent(int worldId, int mapId, String eventId);
	
}
