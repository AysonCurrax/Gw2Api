package gw2.api.webapp.json.impl.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.web.client.RestTemplate;

import gw2.api.webapp.json.api.dao.MapNameDao;
import gw2.api.webapp.model.MapName;

public class MapNameDaoImpl implements MapNameDao{

	public List<MapName> getAllMapNames(String lang) {
		List<MapName> mapNames = new ArrayList<MapName>();
		mapNames = sendRequest(lang);
		return mapNames;
	}
	
	public List<MapName> getMapNameById(String lang, String id) {
		List<MapName> mapNames = new ArrayList<MapName>();
		List<MapName> result = new ArrayList<MapName>();
		mapNames = sendRequest(lang);
		for(MapName mapName : mapNames) {
			if(mapName.getId().equals(id)) {
				result.add(mapName);
			}
		}
		return result;
	}
	
	public List<MapName> sendRequest(String lang) {
		List<MapName> result = new ArrayList<MapName>();
		RestTemplate rest = new RestTemplate();
		String json = rest.getForObject("https://api.guildwars2.com/v1/map_names.json?lang="+lang, String.class);
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(json);
			result = mapper.readValue(node.traverse(), new TypeReference<List<MapName>>() {
			});
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
