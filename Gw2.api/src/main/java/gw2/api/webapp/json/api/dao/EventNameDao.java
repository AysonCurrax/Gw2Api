package gw2.api.webapp.json.api.dao;

import gw2.api.webapp.json.api.domain.EventName;

import java.util.List;

public interface EventNameDao {

	List<EventName> getAllEventNames(String lang);
	
	EventName getEventNameById(String lang, String id);
}
