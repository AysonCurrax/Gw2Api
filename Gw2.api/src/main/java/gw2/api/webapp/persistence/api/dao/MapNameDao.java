package gw2.api.webapp.persistence.api.dao;

import gw2.api.webapp.persistence.api.domain.MapName;

import java.util.List;

public interface MapNameDao {

	public List<MapName> getAllMapNames(String lang);
	
	public MapName getMapNameById(String lang, String id);
}
