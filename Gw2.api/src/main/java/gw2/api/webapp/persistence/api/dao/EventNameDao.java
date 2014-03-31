package gw2.api.webapp.persistence.api.dao;

import gw2.api.webapp.persistence.api.domain.EventName;

import java.util.List;

public interface EventNameDao {

	List<EventName> getAllEventNames(String lang);
	
	EventName getEventNameById(String lang, String id);
}
