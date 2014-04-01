package gw2.api.webapp.json.api.dao;

import gw2.api.webapp.json.api.domain.EventDetail;

import java.util.Map;

public interface EventDetailDao {

	Map<String, EventDetail> getAllEventDetails(String lang);
	
	Map<String, EventDetail> getEventDetailById(String lang, String id);
}
