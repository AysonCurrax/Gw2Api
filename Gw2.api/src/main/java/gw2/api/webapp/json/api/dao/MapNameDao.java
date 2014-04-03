package gw2.api.webapp.json.api.dao;

import gw2.api.webapp.model.MapName;

import java.util.List;

public interface MapNameDao {

	List<MapName> getAllMapNames(String lang);
	
	List<MapName> getMapNameById(String lang, String id);
}
