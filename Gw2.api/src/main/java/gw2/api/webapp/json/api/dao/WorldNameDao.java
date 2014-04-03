package gw2.api.webapp.json.api.dao;

import gw2.api.webapp.model.WorldName;

import java.util.List;

public interface WorldNameDao {

	List<WorldName> getAllWorldNames(String lang);
	
	List<WorldName> getWorldNameById(String lang, String id);
}
