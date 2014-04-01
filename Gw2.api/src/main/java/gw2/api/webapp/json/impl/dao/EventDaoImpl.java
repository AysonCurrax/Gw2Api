package gw2.api.webapp.json.impl.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.web.client.RestTemplate;

import gw2.api.webapp.json.api.dao.EventDao;
import gw2.api.webapp.json.api.domain.Event;

public class EventDaoImpl implements EventDao{

	public List<Event> getEventsByWorld(int worldId) {
		List<Event> events = new ArrayList<Event>();
		String params = "?world_id=" + worldId;
		events = sendRequest(params);
		return events;
	}
	
	public List<Event> getEventsByWorldAndMap(int worldId, int mapId) {
		List<Event> events = new ArrayList<Event>();
		String params = "?world_id=" + worldId + "&map_id=" + mapId;
		events = sendRequest(params);
		return events;
	}
	
	public Event getEventByWorldAndMapAndEvent(int worldId, int mapId, String eventId) {
		List<Event> events = new ArrayList<Event>();
		String params = "?world_id=" + worldId + "&map_id=" + mapId + "&event_id=" + eventId;
		events = sendRequest(params);
		return events.get(0);
	}
	
	public List<Event> sendRequest(String params) {
		StringBuilder builder = new StringBuilder();
		builder.append("https://api.guildwars2.com/v1/events.json");
		builder.append(params);
		String url = builder.toString();
		List<Event> result = new ArrayList<Event>();
		RestTemplate rest = new RestTemplate();
		String json = rest.getForObject(url, String.class);
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(json);
			node = node.get("events");
			result = mapper.readValue(node.traverse(), new TypeReference<List<Event>>() {
			});
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
