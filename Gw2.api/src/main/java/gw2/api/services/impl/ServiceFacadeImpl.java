package gw2.api.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import gw2.api.services.api.ServiceFacade;
import gw2.api.webapp.json.api.dao.EventDao;
import gw2.api.webapp.json.api.dao.EventDetailDao;
import gw2.api.webapp.json.api.dao.EventNameDao;
import gw2.api.webapp.json.api.dao.MapNameDao;
import gw2.api.webapp.json.api.dao.WorldNameDao;
import gw2.api.webapp.model.Event;
import gw2.api.webapp.model.EventDetail;
import gw2.api.webapp.model.EventName;
import gw2.api.webapp.model.MapName;
import gw2.api.webapp.model.WorldName;

public class ServiceFacadeImpl implements ServiceFacade{

	@Autowired
	WorldNameDao worldNameDao;
	
	@Autowired
	MapNameDao mapNameDao;
	
	@Autowired
	EventNameDao eventNameDao;
	
	@Autowired
	EventDao eventDao;
	
	@Autowired
	EventDetailDao eventDetailDao;
	
	@Override
	public List<WorldName> getAllWorldNames(String lang) {
		return worldNameDao.getAllWorldNames(lang);
	}
	
	@Override
	public List<WorldName> getWorldNameById(String lang, String id) {
		return worldNameDao.getWorldNameById(lang, id);
	}
	
	@Override
	public List<MapName> getAllMapNames(String lang) {
		return mapNameDao.getAllMapNames(lang);
	}
	
	@Override
	public List<MapName> getMapNameById(String lang, String id) {
		return mapNameDao.getMapNameById(lang, id);
	}
	
	@Override
	public List<EventName> getAllEventNames(String lang) {
		return eventNameDao.getAllEventNames(lang);
	}
	
	@Override
	public List<EventName> getEventNameById(String lang, String id) {
		return eventNameDao.getEventNameById(lang, id);
	}
	
	@Override
	public List<Event> getAllEvents() {
		return eventDao.getAllEvents();
	}
	
	@Override
	public List<Event> getEventsByWorld(int worldId) {
		return eventDao.getEventsByWorld(worldId);
	}
	
	@Override
	public List<Event> getEventsByWorldAndMap(int worldId, int mapId) {
		return eventDao.getEventsByWorldAndMap(worldId, mapId);
	}
	
	@Override
	public List<Event> getEventByWorldAndMapAndEvent(int worldId, int mapId, String eventId) {
		return eventDao.getEventByWorldAndMapAndEvent(worldId, mapId, eventId);
	}
	
	@Override
	public Map<String, EventDetail> getAllEventDetails(String lang) {
		return eventDetailDao.getAllEventDetails(lang);
	}
	
	@Override
	public Map<String, EventDetail> getEventDetailById(String lang, String id) {
		return eventDetailDao.getEventDetailById(lang, id);
	}
}
