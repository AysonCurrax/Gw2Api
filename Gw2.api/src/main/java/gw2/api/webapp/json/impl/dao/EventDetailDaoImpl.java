package gw2.api.webapp.json.impl.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.web.client.RestTemplate;

import gw2.api.webapp.json.api.dao.EventDetailDao;
import gw2.api.webapp.json.api.domain.EventDetail;

public class EventDetailDaoImpl implements EventDetailDao{

	public Map<String, EventDetail> getAllEventDetails(String lang) {
		Map<String, EventDetail> eventDetails = new HashMap<String,EventDetail>();
		String params = "?lang=" + lang;
		eventDetails = sendRequest(params);
		return eventDetails;
	}
	
	public Map<String, EventDetail> getEventDetailById(String lang, String id) {
		Map<String, EventDetail> eventDetails = new HashMap<String,EventDetail>();
		String params = "?lang=" + lang + "&event_id=" + id;
		eventDetails = sendRequest(params);
		return eventDetails;
	}
	
	public Map<String, EventDetail> sendRequest(String params) {
		Map<String, EventDetail> result = new HashMap<String, EventDetail>();
		RestTemplate rest = new RestTemplate();
		String json = rest.getForObject("https://api.guildwars2.com/v1/event_details.json"+params, String.class);
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(json);
			node = node.get("events");
			result = mapper.readValue(node.traverse(), new TypeReference<Map<String, EventDetail>>() {
			});
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
