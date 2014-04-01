package gw2.api.webapp.json.api.dao;

import gw2.api.webapp.json.api.domain.MapName;

import java.util.List;

public interface MapNameDao {

	public List<MapName> getAllMapNames(String lang);
	
	public MapName getMapNameById(String lang, String id);
}
