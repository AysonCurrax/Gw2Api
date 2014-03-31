package gw2.api.webapp.persistence.api.dao;

import gw2.api.webapp.persistence.api.domain.WorldName;

import java.util.List;

public interface WorldNameDao {

	List<WorldName> getAllWorldNames(String lang);
	
	WorldName getWorldNameById(String lang, String id);
}
