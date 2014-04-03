package gw2.api.webapp.json.api.dao;

import gw2.api.webapp.model.EventName;

import java.util.List;

public interface EventNameDao {

	List<EventName> getAllEventNames(String lang);
	
	List<EventName> getEventNameById(String lang, String id);
}
