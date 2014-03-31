package gw2.api.webapp.persistence.impl.dao;

import gw2.api.webapp.persistence.api.dao.EventNameDao;
import gw2.api.webapp.persistence.api.domain.EventName;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.web.client.RestTemplate;

public class EventNameDaoImpl implements EventNameDao{

	public List<EventName> getAllEventNames(String lang) {
		List<EventName> eventNames = new ArrayList<EventName>();
		eventNames = sendRequest(lang);
		return eventNames;
	}
	
	public EventName getEventNameById(String lang, String id) {
		List<EventName> eventNames = new ArrayList<EventName>();
		eventNames = sendRequest(lang);
		for(EventName eventName : eventNames) {
			if(eventName.getId().equals(id)) {
				return eventName;
			}
		}
		return null;
	}
	
	public List<EventName> sendRequest(String lang) {
		List<EventName> result = new ArrayList<EventName>();
		RestTemplate rest = new RestTemplate();
		String json = rest.getForObject("https://api.guildwars2.com/v1/event_names.json?lang="+lang, String.class);
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(json);
			result = mapper.readValue(node.traverse(), new TypeReference<List<EventName>>() {
			});
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
