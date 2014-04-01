package gw2.api.webapp.json.impl.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.web.client.RestTemplate;

import gw2.api.webapp.json.api.dao.WorldNameDao;
import gw2.api.webapp.json.api.domain.WorldName;

public class WorldNameDaoImpl implements WorldNameDao{

	public List<WorldName> getAllWorldNames(String lang) {
		List<WorldName> worldNames = new ArrayList<WorldName>();
		worldNames = sendRequest(lang);
		return worldNames;
	}
	
	public WorldName getWorldNameById(String lang, String id) {
		List<WorldName> worldNames = new ArrayList<WorldName>();
		worldNames = sendRequest(lang);
		for(WorldName worldName : worldNames) {
			if(worldName.getId().equals(id)) {
				return worldName;
			}
		}
		return null;
	}
	
	public List<WorldName> sendRequest(String lang) {
		List<WorldName> result = new ArrayList<WorldName>();
		RestTemplate rest = new RestTemplate();
		String json = rest.getForObject("https://api.guildwars2.com/v1/world_names.json?lang="+lang, String.class);
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(json);
			result = mapper.readValue(node.traverse(), new TypeReference<List<WorldName>>() {
			});
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
