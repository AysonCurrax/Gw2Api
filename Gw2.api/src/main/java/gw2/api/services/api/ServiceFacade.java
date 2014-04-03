package gw2.api.services.api;

import gw2.api.webapp.model.Event;
import gw2.api.webapp.model.EventDetail;
import gw2.api.webapp.model.EventName;
import gw2.api.webapp.model.MapName;
import gw2.api.webapp.model.WorldName;

import java.util.List;
import java.util.Map;

public interface ServiceFacade {

	List<WorldName> getAllWorldNames(String lang);
	
	List<WorldName> getWorldNameById(String lang, String id);
	
	List<MapName> getAllMapNames(String lang);
	
	List<MapName> getMapNameById(String lang, String id);
	
	List<EventName> getAllEventNames(String lang);
	
	List<EventName> getEventNameById(String lang, String id);
	
	List<Event> getAllEvents();
	
	List<Event> getEventsByWorld(int worldId);
	
	List<Event> getEventsByWorldAndMap(int worldId, int mapId);
	
	List<Event> getEventByWorldAndMapAndEvent(int worldId, int mapId, String eventId);
	
	Map<String, EventDetail> getAllEventDetails(String lang);
	
	Map<String, EventDetail> getEventDetailById(String lang, String id);
}
